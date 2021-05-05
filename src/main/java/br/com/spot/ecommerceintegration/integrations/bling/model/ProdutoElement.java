package br.com.spot.ecommerceintegration.integrations.bling.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoElement {

    @JsonProperty("produto")
    private Produto produto;

}
