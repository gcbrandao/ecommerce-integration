package br.com.spot.ecommerceintegration.integrations.bling.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoLoja {

    @JsonProperty("idProdutoLoja")
    private String idProdutoLoja;

    @JsonProperty("preco")
    private Preco preco;

    @JsonProperty("dataInclusao")
    private LocalDate dataInclusao;

    @JsonProperty("dataAlteracao")
    private LocalDate dataAlteracao;

    @JsonProperty("categoria")
    private List<Categoria> categoria;
}
