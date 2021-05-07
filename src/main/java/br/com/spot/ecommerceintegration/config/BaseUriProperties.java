package br.com.spot.ecommerceintegration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ComponentScan
@ConfigurationProperties(prefix = "baseuri")
public class BaseUriProperties {

    String apiKey;

    String lojaIntegradaBlingId;

    String mercadoLivreBligId;

    String b2wBligId;

    String urlBlingProdutos;

    String urlBlingProdutosDefault;

    String urlBlingProdutoByCodigo;
}
