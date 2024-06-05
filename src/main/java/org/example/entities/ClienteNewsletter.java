package org.example.entities;

import java.sql.Date;
import java.util.StringJoiner;

public class ClienteNewsletter {

    private Date dataEnvio;

    public ClienteNewsletter() {
    }

    public ClienteNewsletter(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClienteNewsletter.class.getSimpleName() + "[", "]")
                .add("dataEnvio=" + dataEnvio)
                .toString();
    }
}
