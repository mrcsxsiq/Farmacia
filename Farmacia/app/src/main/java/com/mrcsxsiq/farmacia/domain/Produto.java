package com.mrcsxsiq.farmacia.domain;

public class Produto {

    private String foto;
    private String nome;
    private String descricacao;
    private String bula;

    public Produto (){}

    public Produto(String nome, String descricacao, String bula) {
        this.nome = nome;
        this.descricacao = descricacao;
        this.bula = bula;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public String getBula() {
        return bula;
    }

    public void setBula(String bula) {
        this.bula = bula;
    }
}
