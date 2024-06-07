package org.example.entities;

import java.util.StringJoiner;

public class UsuarioAplicacao extends _BaseEntity {

    private String nome;
    private String telefone;

    public UsuarioAplicacao() {
    }

    public UsuarioAplicacao(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UsuarioAplicacao.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("telefone='" + telefone + "'")
                .toString();
    }
}
