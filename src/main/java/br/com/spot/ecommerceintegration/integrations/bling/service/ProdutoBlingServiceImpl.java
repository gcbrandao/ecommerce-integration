package br.com.spot.ecommerceintegration.integrations.bling.service;

import br.com.spot.ecommerceintegration.component.RequestComponentImpl;
import br.com.spot.ecommerceintegration.component.model.RequestModel;
import br.com.spot.ecommerceintegration.config.BaseUriProperties;
import br.com.spot.ecommerceintegration.exceptionhandler.exceptions.BadRequestException;
import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutoElement;
import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutosBlingResponse;
import br.com.spot.ecommerceintegration.integrations.bling.model.Retorno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProdutoBlingServiceImpl implements ProdutoBlingService {

    private final BaseUriProperties baseUriProperties;

    private final RequestComponentImpl requestComponent;

    private final WebClient webClient;


    public ProdutoBlingServiceImpl(BaseUriProperties baseUriProperties, RequestComponentImpl requestComponent, WebClient webClient) {
        this.baseUriProperties = baseUriProperties;
        this.requestComponent = requestComponent;
        this.webClient = webClient;
    }

    @Override
    public ProdutosBlingResponse getProdutosBling(String pagina) {

        try {
            String apiKey = baseUriProperties.getApiKey();

            Map<String, String> queryParamsMap = new HashMap<>();
            queryParamsMap.put("apikey", apiKey);
            queryParamsMap.put("estoque", "S");
            queryParamsMap.put("loja", baseUriProperties.getMercadoLivreBligId());

            RequestModel requestModel = RequestModel.builder()
                    .url(String.format(baseUriProperties.getUrlBlingProdutos(), pagina))
                    .queryParamsMap(queryParamsMap)
                    .returnClass(ProdutosBlingResponse.class)
                    .build();

            return requestComponent.get(requestModel);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BadRequestException("Erro ao buscar produtos bling ==> ", e);
        }
    }

    @Override
    public List<ProdutoElement> getTodosProdutosBling() {

        List<ProdutoElement> listaProdutos = new ArrayList<>();

        Integer pagina = 1;

        List<ProdutoElement> produtoElements = getProdutosBling(pagina.toString()).getRetorno().getProdutos();

        listaProdutos.addAll(produtoElements);
        pagina++;

        while (produtoElements != null) {
            produtoElements = getProdutosBling(pagina.toString()).getRetorno().getProdutos();

            if (produtoElements != null){
                listaProdutos.addAll(produtoElements);
                pagina++;
            }
        }

        log.info("Total de Produtos  ==> " + listaProdutos.size());
        return listaProdutos;
    }

    @Override
    public ProdutosBlingResponse getTodosProdutosBlingMono() {

        String pagina = "1";

        Mono<ProdutosBlingResponse> retornoMono = this.webClient.method(HttpMethod.GET)
                //.uri("/page={pagina}/json/", "1")
                .uri(uriBuilder -> uriBuilder
                        .path("/page={pagina}/json/")
                        .queryParam("apikey", baseUriProperties.getApiKey())
                        .queryParam("estoque", "S")
                        .queryParam("loja", baseUriProperties.getMercadoLivreBligId())
                        .build(pagina))
                .retrieve()
                .bodyToMono(ProdutosBlingResponse.class);



        ProdutosBlingResponse produtoRetorno = retornoMono.block();
        //log.info(webClient.get().uri().toString());


        return produtoRetorno;
    }


}
