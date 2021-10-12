package com.tech4me.vendams.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Venda {
    @Id
    private String id;

    private Integer dataVenda;

    private String produtoVendido;

    private Integer quantidadeVendida;

    private Double valorInicial;

    private Double valorParaPagar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Integer dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorParaPagar() {
        return valorParaPagar;
    }

    public void setValorParaPagar(Double valorParaPagar) {
        this.valorParaPagar = valorParaPagar;
    }

    
}
