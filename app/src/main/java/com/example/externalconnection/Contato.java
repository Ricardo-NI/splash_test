package com.example.externalconnection;

public class Contato {

    public int id;
    public String nome;
    public String email;

    public Contato() {
    }
    /*
    public Contato(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
