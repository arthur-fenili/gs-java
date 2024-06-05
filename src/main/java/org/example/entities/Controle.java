package org.example.entities;

import java.util.StringJoiner;

public class Controle {
    private int codAdministrador;
    private String nome;

    public Controle() {
    }

    public Controle(int codAdministrador, String nome) {
        this.codAdministrador = codAdministrador;
        this.nome = nome;
    }

    public int getCodAdministrador() {
        return codAdministrador;
    }

    public void setCodAdministrador(int codAdministrador) {
        this.codAdministrador = codAdministrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Controle.class.getSimpleName() + "[", "]")
                .add("codAdministrador=" + codAdministrador)
                .add("nome='" + nome + "'")
                .toString();
    }
}
