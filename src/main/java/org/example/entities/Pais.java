package org.example.entities;

import java.util.StringJoiner;

public class Pais {
    private String nome;


    public Pais() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pais.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .toString();
    }
}
