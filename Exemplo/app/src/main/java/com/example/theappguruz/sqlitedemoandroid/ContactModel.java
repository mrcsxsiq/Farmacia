package com.example.theappguruz.sqlitedemoandroid;

public class ContactModel {

    private String ID, Nome, Preco;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public String getPreco() {
        return Preco;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setPreco(String preco) {
        this.Preco = preco;
    }
}
