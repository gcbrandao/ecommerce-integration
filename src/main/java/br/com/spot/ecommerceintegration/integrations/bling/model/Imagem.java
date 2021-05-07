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
public class Imagem {

        @JsonProperty("link")
        private String link;

        @JsonProperty("validade")
        private String validade;

        @JsonProperty("tipoArmazenamento")
        private String tipoArmazenamento;

}
