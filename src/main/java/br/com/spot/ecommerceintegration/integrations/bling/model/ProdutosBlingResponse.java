package br.com.spot.ecommerceintegration.integrations.bling.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutosBlingResponse {

    @JsonProperty("retorno")
    private Retorno retorno;
}
