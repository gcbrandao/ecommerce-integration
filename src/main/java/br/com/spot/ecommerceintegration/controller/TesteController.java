package br.com.spot.ecommerceintegration.controller;


import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutosBlingResponse;
import br.com.spot.ecommerceintegration.integrations.bling.service.ProdutoBlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    ProdutoBlingService produtoBlingService;


    @GetMapping(value = "teste")
    public ProdutosBlingResponse getProdutosBling(){
        log.info("entrei no controller ");


        ProdutosBlingResponse produtosBling = produtoBlingService.getProdutosBling();

        return produtosBling;
    }
}
