package org.example.service;

import org.example.entities.Doacao;
import org.example.repository.DoacaoRepository;

import java.util.List;

public class DoacaoService {
    private DoacaoRepository doacaoRepository = new DoacaoRepository();

    public void create(Doacao doacao) {
        doacaoRepository.create(doacao);
    }

    public Doacao readById(int id) {
        return doacaoRepository.readById(id);
    }

    public List<Doacao> readAll() {
        return doacaoRepository.readAll();
    }

    public void updateById(Doacao doacao, int id) {
        doacaoRepository.updateById(doacao, id);
    }

    public void deleteById(int id) {
        doacaoRepository.deleteById(id);
    }
}
