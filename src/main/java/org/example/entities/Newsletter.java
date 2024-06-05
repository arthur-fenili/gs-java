package org.example.entities;

import java.sql.Date;
import java.util.StringJoiner;

public class Newsletter {

    private String assunto;
    private Date data;

    public Newsletter() {
    }

    public Newsletter(String assunto, Date data) {
        this.assunto = assunto;
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Newsletter.class.getSimpleName() + "[", "]")
                .add("assunto='" + assunto + "'")
                .add("data=" + data)
                .toString();
    }
}
