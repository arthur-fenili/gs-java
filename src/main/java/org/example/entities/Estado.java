package org.example.entities;

import java.util.StringJoiner;

public class Estado {

    private String nome;

    public Estado() {
    }

    public Estado(String nome) {
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
        return new StringJoiner(", ", Estado.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
