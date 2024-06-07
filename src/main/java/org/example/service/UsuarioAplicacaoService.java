package org.example.service;

import org.example.entities.UsuarioAplicacao;
import org.example.repository.UsuarioAplicacaoRepository;

import java.util.List;

public class UsuarioAplicacaoService {
    private UsuarioAplicacaoRepository usuarioAplicacaoRepository = new UsuarioAplicacaoRepository();

    public void create(UsuarioAplicacao usuarioAplicacao) {
        usuarioAplicacaoRepository.create(usuarioAplicacao);
    }

    public UsuarioAplicacao readById(int id) {
        return usuarioAplicacaoRepository.readById(id);
    }

    public List<UsuarioAplicacao> readAll() {
        return usuarioAplicacaoRepository.readAll();
    }

    public void updateById(UsuarioAplicacao usuarioAplicacao, int id) {
        usuarioAplicacaoRepository.updateById(usuarioAplicacao, id);
    }

    public void deleteById(int id) {
        usuarioAplicacaoRepository.deleteById(id);
    }
}
