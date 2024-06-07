package org.example.entities;

import java.util.StringJoiner;

public class Cliente extends _BaseEntity {

    private String nome;
    private String email;
    private String telefone;
    private int cod_endereco;

    public Cliente(String nome, String email, String telefone, int cod_endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cod_endereco = cod_endereco;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cliente.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("email='" + email + "'")
                .add("telefone='" + telefone + "'")
                .add("cod_endereco=" + cod_endereco)
                .toString();
    }

    public int getCod_endereco() {
        return cod_endereco;
    }

    public void setCod_endereco(int cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

    public Cliente(int id, String nome, String email, String telefone, int cod_endereco) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cod_endereco = cod_endereco;
    }

    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
