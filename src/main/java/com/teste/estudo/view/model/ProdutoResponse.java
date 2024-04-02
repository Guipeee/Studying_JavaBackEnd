package com.teste.estudo.view.model;

public class ProdutoResponse {
    //Integer -> Números menores
    //Long -> Números maiores

    //#region Atributos
    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    // private String observacao;

    //Separando as variaveis com 1 linha de espaço, a geração de getters and setters fica automática 
    //a partir do caminho: botão direito, ação de origem, generate getters and setters.

    //#endregion

    //#region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
/*
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
*/
    //#endregion
}
