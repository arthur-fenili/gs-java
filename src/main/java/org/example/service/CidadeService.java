package org.example.service;

import org.example.entities.Cidade;
import org.example.repository.CidadeRepository;

import java.util.List;

public class CidadeService {
    private CidadeRepository cidadeRepository = new CidadeRepository();

    public void create(Cidade cidade) {
        cidadeRepository.Create(cidade);
    }

    public Cidade readById(int id) {
        return cidadeRepository.ReadById(id);
    }

    public List<Cidade> readAll() {
        return cidadeRepository.ReadAll();
    }

    public void updateById(Cidade cidade, int id) {
        cidadeRepository.UpdateById(cidade, id);
    }

    public void deleteById(int id) {
        cidadeRepository.DeleteById(id);
    }
}
