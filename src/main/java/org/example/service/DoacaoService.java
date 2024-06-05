package org.example.service;

import org.example.entities.Doacao;
import org.example.repository.DoacaoRepository;

import java.util.List;

public class DoacaoService {
    private DoacaoRepository doacaoRepository = new DoacaoRepository();

    public void create(Doacao doacao) {
        doacaoRepository.Create(doacao);
    }

    public Doacao readById(int id) {
        return doacaoRepository.ReadById(id);
    }

    public List<Doacao> readAll() {
        return doacaoRepository.ReadAll();
    }

    public void updateById(Doacao doacao, int id) {
        doacaoRepository.UpdateById(doacao, id);
    }

    public void deleteById(int id) {
        doacaoRepository.DeleteById(id);
    }
}
