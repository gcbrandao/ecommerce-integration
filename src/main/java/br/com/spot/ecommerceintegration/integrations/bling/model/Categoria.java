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
public class Categoria {
    @JsonProperty("id")
    private String id;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("idCategoriaPai")
    private String idCategoriaPai;
}

