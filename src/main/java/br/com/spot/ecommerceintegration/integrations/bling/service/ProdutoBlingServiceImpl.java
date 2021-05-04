package br.com.spot.ecommerceintegration.integrations.bling.service;

import br.com.spot.ecommerceintegration.component.RequestComponentImpl;
import br.com.spot.ecommerceintegration.component.model.RequestModel;
import br.com.spot.ecommerceintegration.config.BaseUriProperties;
import br.com.spot.ecommerceintegration.exceptionhandler.exceptions.BadRequestException;
import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutosBlingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ProdutoBlingServiceImpl implements ProdutoBlingService {

      private final BaseUriProperties baseUriProperties;

    private final RequestComponentImpl requestComponent;

    public ProdutoBlingServiceImpl(BaseUriProperties baseUriProperties, RequestComponentImpl requestComponent) {
        this.baseUriProperties = baseUriProperties;
        this.requestComponent = requestComponent;
    }

    @Override
    public ProdutosBlingResponse getProdutosBling() {

        try {
            String apiKey = baseUriProperties.getApiKey();

            Map<String, String> queryParamsMap = new HashMap<>();
            queryParamsMap.put("apikey",apiKey );
            queryParamsMap.put("estoque", "S");
            queryParamsMap.put("loja", baseUriProperties.getMercadoLivreBligId());

            RequestModel requestModel = RequestModel.builder()
                    .url(baseUriProperties.getUrlBlingProdutos())
                    .queryParamsMap(queryParamsMap)
                    .returnClass(ProdutosBlingResponse.class)
                    .build();

            return requestComponent.get(requestModel);

        } catch (Exception e){
            log.error(e.getMessage());
            throw new BadRequestException("Erro ao buscar produtos bling ==> " , e );
        }
    }
}
