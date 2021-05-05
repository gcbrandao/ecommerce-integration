package br.com.spot.ecommerceintegration.component;

import br.com.spot.ecommerceintegration.component.model.RequestModel;
import br.com.spot.ecommerceintegration.exceptionhandler.exceptions.ConverterResponseException;
import br.com.spot.ecommerceintegration.util.ParserUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Slf4j
@Component
public class RequestComponentImpl implements RequestComponent {

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    @Autowired
    public RequestComponentImpl(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T post(RequestModel requestModel) throws HttpClientErrorException {

        String token = getToken(requestModel);

        HttpHeaders headers = getHeaders(requestModel, token);

        String url = getUrl(requestModel);

        Object object = objectJson(requestModel);

        HttpEntity<Object> request = new HttpEntity<>(object, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return converterResponseData(requestModel, response);
    }

    private Object objectJson(RequestModel requestModel) {
        Object object = requestModel.getObject();

        String jsonRequester = ParserUtil.objectToJson(object);

        log.debug(jsonRequester);
        return object;
    }

    @Override
    public <T> T get(RequestModel requestModel) throws HttpClientErrorException {

        String token = getToken(requestModel);

        HttpHeaders headers = getHeaders(requestModel, token);

        String url = getUrl(requestModel);

        HttpEntity<Object> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return converterResponseData(requestModel, response);

    }

    private <T> T converterResponseData(RequestModel requestModel, ResponseEntity<String> response) {
        JavaType javaType = objectMapper.getTypeFactory().constructType(requestModel.getReturnClass());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return readValue(response, javaType);
    }

    private HttpHeaders getHeaders(RequestModel requestModel, String token) {
        HttpHeaders headers = setMapHeaders(requestModel.getHeadersMap());

        if (StringUtils.isNotBlank(token)) {
            headers.add("Authorization", token);
        }
        return headers;
    }

    private String getUrl(RequestModel requestModel) {
        String url = requestModel.getUrl();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        Map<String, String> queryParamsMap = requestModel.getQueryParamsMap();

        if (queryParamsMap != null) {
            builder = setQueryParams(queryParamsMap, builder);
        }

        return builder.build().toString();

    }

    private <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
        T result = null;
        if (!response.getStatusCode().is2xxSuccessful()) {
            log.info(String.format("No data found - HttpSatatus: %s", response.getStatusCode()));

            throw new HttpClientErrorException(response.getStatusCode(), response.getBody());
        }

        try {
            result = objectMapper.readValue(response.getBody(), javaType);
        } catch (IOException e) {
            log.error("Converter error response to object");

            throw new ConverterResponseException("Converter error response to object", e);
        }

        return result;
    }

    private String getToken(RequestModel requestModel) {
        String accessToken = requestModel.getAccessToken();

        return StringUtils.isBlank(accessToken) ? Strings.EMPTY : ("Bearer " + accessToken);
    }

    private UriComponentsBuilder setQueryParams(Map<String, String> queryParamsMap, UriComponentsBuilder builder) {
        Set<Entry<String, String>> setQueryParams = queryParamsMap.entrySet();

        for (Entry<String, String> param : setQueryParams) {
            String name = param.getKey();
            String values = param.getValue();

            builder.queryParam(name, values);
        }

        return builder;
    }

    private HttpHeaders setMapHeaders(Map<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();

        if (headersMap == null) {

            return headers;
        }

        Set<Entry<String, String>> setHeaders = headersMap.entrySet();

        for (Entry<String, String> header : setHeaders) {
            String headerName = header.getKey();
            String headerValue = header.getValue();

            headers.add(headerName, headerValue);
        }

        if (!headers.containsKey("Content-Type")) {
            headers.setContentType(MediaType.APPLICATION_JSON);
        }

        return headers;
    }

}
