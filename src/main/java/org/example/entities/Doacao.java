package org.example.entities;

import java.sql.Date;
import java.util.StringJoiner;

public class Doacao {

    private Date dataDoacao;
    private double valor;

    public Doacao() {
    }

    public Doacao(Date dataDoacao, double valor) {
        this.dataDoacao = dataDoacao;
        this.valor = valor;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Doacao.class.getSimpleName() + "[", "]")
                .add("dataDoacao=" + dataDoacao)
                .add("valor=" + valor)
                .toString();
    }


}
