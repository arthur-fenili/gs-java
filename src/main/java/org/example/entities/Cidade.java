package org.example.entities;

import java.util.StringJoiner;

public class Cidade {

    private String nome;

    public Cidade() {
    }

    public Cidade(String nome) {
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
        return new StringJoiner(", ", Cidade.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
