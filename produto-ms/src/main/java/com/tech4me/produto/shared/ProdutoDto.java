package com.tech4me.produto.shared;

public class ProdutoDto {
    
    private String id;
   
    private Integer codigo;
 
    private String nome;
 
    private Double valor;
 
    private Integer quantidadeEmEstoque;
 
    public String getId() {
       return id;
    }
 
    public void setId(String id) {
       this.id = id;
    }
 
    public Integer getCodigo() {
       return codigo;
    }
 
    public void setCodigo(Integer codigo) {
       this.codigo = codigo;
    }
 
    public String getNome() {
       return nome;
    }
 
    public void setNome(String nome) {
       this.nome = nome;
    }
 
    public Double getValor() {
       return valor;
    }
 
    public void setValor(Double valor) {
       this.valor = valor;
    }
 
    public Integer getQuantidadeEmEstoque() {
       return quantidadeEmEstoque;
    }
 
    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
       this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
