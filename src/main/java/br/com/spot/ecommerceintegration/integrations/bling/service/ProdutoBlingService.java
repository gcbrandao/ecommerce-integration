package br.com.spot.ecommerceintegration.integrations.bling.service;

import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutoElement;
import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutosBlingResponse;

import java.util.List;

public interface ProdutoBlingService {

    ProdutosBlingResponse getProdutosBling(String pagina);

    List<ProdutoElement> getTodosProdutosBling();

    List<ProdutosBlingResponse> getTodosProdutosBlingMono();

    ProdutosBlingResponse getProdutoByCodigo(String codigo);
}
