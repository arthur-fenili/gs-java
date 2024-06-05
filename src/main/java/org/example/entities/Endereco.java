package org.example.entities;

import java.util.StringJoiner;

public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String complemento, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Endereco.class.getSimpleName() + "[", "]")
                .add("rua='" + rua + "'")
                .add("numero='" + numero + "'")
                .add("complemento='" + complemento + "'")
                .add("cep='" + cep + "'")
                .toString();
    }
}
