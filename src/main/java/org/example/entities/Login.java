package org.example.entities;

import java.util.StringJoiner;

public class Login {
    private String email;
    private String senha;
    private String tipoUsuario;

    public Login() {
    }

    public Login(String email, String senha, String tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Login.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("senha='" + senha + "'")
                .add("tipoUsuario='" + tipoUsuario + "'")
                .toString();
    }
}
