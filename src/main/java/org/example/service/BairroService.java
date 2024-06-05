package org.example.service;

import org.example.entities.Bairro;
import org.example.repository.BairroRepository;

import java.util.List;

public class BairroService {
    private BairroRepository bairroRepository = new BairroRepository();

    public void create(Bairro bairro) {
        bairroRepository.Create(bairro);
    }

    public Bairro readById(int id) {
        return bairroRepository.ReadById(id);
    }

    public List<Bairro> readAll() {
        return bairroRepository.ReadAll();
    }

    public void updateById(Bairro bairro, int id) {
        bairroRepository.UpdateById(bairro, id);
    }

    public void deleteById(int id) {
        bairroRepository.DeleteById(id);
    }
}
