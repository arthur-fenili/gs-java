package org.example.service;

import org.example.entities.UsuarioAplicacao;
import org.example.repository.UsuarioAplicacaoRepository;

import java.util.List;

public class UsuarioAplicacaoService {
    private UsuarioAplicacaoRepository usuarioAplicacaoRepository = new UsuarioAplicacaoRepository();

    public void create(UsuarioAplicacao usuarioAplicacao) {
        usuarioAplicacaoRepository.Create(usuarioAplicacao);
    }

    public UsuarioAplicacao readById(int id) {
        return usuarioAplicacaoRepository.ReadById(id);
    }

    public List<UsuarioAplicacao> readAll() {
        return usuarioAplicacaoRepository.ReadAll();
    }

    public void updateById(UsuarioAplicacao usuarioAplicacao, int id) {
        usuarioAplicacaoRepository.UpdateById(usuarioAplicacao, id);
    }

    public void deleteById(int id) {
        usuarioAplicacaoRepository.DeleteById(id);
    }
}
