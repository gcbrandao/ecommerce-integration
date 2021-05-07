package br.com.spot.ecommerceintegration.controller;


import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutoElement;
import br.com.spot.ecommerceintegration.integrations.bling.model.ProdutosBlingResponse;
import br.com.spot.ecommerceintegration.integrations.bling.model.Retorno;
import br.com.spot.ecommerceintegration.integrations.bling.service.ProdutoBlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    ProdutoBlingService produtoBlingService;


    @GetMapping(value = "teste")
    public ProdutosBlingResponse getProdutosBling(){
        log.info("entrei no controller ");


        ProdutosBlingResponse produtosBling = produtoBlingService.getProdutosBling("17");

        return produtosBling;
    }

    @GetMapping(value = "listAll")
    public ResponseEntity<List<ProdutoElement>> getTodosProdutosBling(){
        log.info("entrei no controller ");

        List<ProdutoElement> todosProdutosBling = produtoBlingService.getTodosProdutosBling();

        return ResponseEntity.ok(todosProdutosBling);
    }

    @GetMapping(value = "listAllMono")
    public ResponseEntity<ProdutosBlingResponse> getTodosProdutosBlingMono(){
        log.info("entrei no controller ");

        ProdutosBlingResponse todosProdutosBling = produtoBlingService.getTodosProdutosBlingMono();

        return ResponseEntity.ok(todosProdutosBling);
    }
}
