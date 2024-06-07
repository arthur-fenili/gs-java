package org.example.service;

import org.example.entities.Controle;
import org.example.repository.ControleRepository;

import java.util.List;

public class ControleService {
    private ControleRepository controleRepository = new ControleRepository();

    public void create(Controle controle) {
        controleRepository.create(controle);
    }

    public Controle readById(int id) {
        return controleRepository.readById(id);
    }

    public List<Controle> readAll() {
        return controleRepository.readAll();
    }

    public void updateById(Controle controle, int id) {
        controleRepository.updateById(controle, id);
    }

    public void deleteById(int id) {
        controleRepository.deleteById(id);
    }
}
