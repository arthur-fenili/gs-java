package org.example.repository;

import org.example.entities.UsuarioAplicacao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAplicacaoRepository {
    private List<UsuarioAplicacao> usuarioAplicacoes = new ArrayList<>();

    public void Create(UsuarioAplicacao usuarioAplicacao) {
        usuarioAplicacoes.add(usuarioAplicacao);
    }

    public UsuarioAplicacao ReadById(int id) {
        return usuarioAplicacoes.stream().filter(ua -> ua.getId() == id).findFirst().orElse(null);
    }

    public List<UsuarioAplicacao> ReadAll() {
        return new ArrayList<>(usuarioAplicacoes);
    }

    public void UpdateById(UsuarioAplicacao usuarioAplicacao, int id) {
        UsuarioAplicacao existingUsuarioAplicacao = ReadById(id);
        if (existingUsuarioAplicacao != null) {
            usuarioAplicacoes.remove(existingUsuarioAplicacao);
            usuarioAplicacoes.add(usuarioAplicacao);
        }
    }

    public void DeleteById(int id) {
        UsuarioAplicacao usuarioAplicacao = ReadById(id);
        if (usuarioAplicacao != null) {
            usuarioAplicacoes.remove(usuarioAplicacao);
        }
    }
}
