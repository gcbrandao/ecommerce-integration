package br.com.spot.ecommerceintegration.integrations.bling.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposito {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("saldo")
    private BigDecimal saldo;

    @JsonProperty("desconsiderar")
    private String desconsiderar;

    @JsonProperty("saldoVirtual")
    private BigDecimal saldoVirtual;
}
