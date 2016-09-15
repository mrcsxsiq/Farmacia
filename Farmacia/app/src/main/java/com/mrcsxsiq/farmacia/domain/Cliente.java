package com.mrcsxsiq.farmacia.domain;

public class Cliente {

    private String nome;
    private String nascimento;
    private String rg;
    private String cpf;
    private String endereco;

   // public Cliente() {}

    public Cliente(String nome, String nascimento, String rg, String cpf, String endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }
}
