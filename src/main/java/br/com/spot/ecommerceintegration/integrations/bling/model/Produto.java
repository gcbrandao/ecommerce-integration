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
public class Produto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("unidade")
    private String unidade;

    @JsonProperty("preco")
    private String preco;

    @JsonProperty("precoCusto")
    private String precoCusto;

    @JsonProperty("descricaoCurta")
    private String descricaoCurta;

    @JsonProperty("descricaoComplementar")
    private String descricaoComplementar;

    @JsonProperty("dataInclusao")
    private LocalDate dataInclusao;

    @JsonProperty("dataAlteracao")
    private LocalDate dataAlteracao;

    @JsonProperty("imageThumbnail")
    private Object imageThumbnail;

    @JsonProperty("urlVideo")
    private String urlVideo;

    @JsonProperty("nomeFornecedor")
    private String nomeFornecedor;

    @JsonProperty("codigoFabricante")
    private String codigoFabricante;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("class_fiscal")
    private String classFiscal;

    @JsonProperty("cest")
    private String cest;

    @JsonProperty("origem")
    private String origem;

    @JsonProperty("idGrupoProduto")
    private String idGrupoProduto;

    @JsonProperty("linkExterno")
    private String linkExterno;

    @JsonProperty("observacoes")
    private String observacoes;

    @JsonProperty("grupoProduto")
    private Object grupoProduto;

    @JsonProperty("garantia")
    private String garantia;

    @JsonProperty("descricaoFornecedor")
    private String descricaoFornecedor;

    @JsonProperty("idFabricante")
    private String idFabricante;

    @JsonProperty("categoria")
    private Produto categoria;

    @JsonProperty("pesoLiq")
    private String pesoLiq;

    @JsonProperty("pesoBruto")
    private String pesoBruto;

    @JsonProperty("estoqueMinimo")
    private String estoqueMinimo;

    @JsonProperty("estoqueMaximo")
    private String estoqueMaximo;

    @JsonProperty("gtin")
    private String gtin;

    @JsonProperty("gtinEmbalagem")
    private String gtinEmbalagem;

    @JsonProperty("larguraProduto")
    private String larguraProduto;

    @JsonProperty("alturaProduto")
    private String alturaProduto;

    @JsonProperty("profundidadeProduto")
    private String profundidadeProduto;

    @JsonProperty("unidadeMedida")
    private String unidadeMedida;

    @JsonProperty("itensPorCaixa")
    private long itensPorCaixa;

    @JsonProperty("volumes")
    private long volumes;

    @JsonProperty("localizacao")
    private String localizacao;

    @JsonProperty("crossdocking")
    private String crossdocking;

    @JsonProperty("condicao")
    private String condicao;

    @JsonProperty("freteGratis")
    private String freteGratis;

    @JsonProperty("producao")
    private String producao;

    @JsonProperty("dataValidade")
    private String dataValidade;

    @JsonProperty("spedTipoItem")
    private String spedTipoItem;

    @JsonProperty("estoqueAtual")
    private long estoqueAtual;

    @JsonProperty("depositos")
    private List<Deposito> depositos;

    @JsonProperty("produtoLoja")
    private ProdutoLoja produtoLoja;
}
