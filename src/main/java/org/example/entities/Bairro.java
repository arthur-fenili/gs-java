package org.example.entities;

import java.util.StringJoiner;

public class Bairro {

    private String nome;

    public Bairro() {
    }

    public Bairro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bairro.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
