package org.example.service;

import org.example.entities.Controle;
import org.example.repository.ControleRepository;

import java.util.List;

public class ControleService {
    private ControleRepository controleRepository = new ControleRepository();

    public void create(Controle controle) {
        controleRepository.Create(controle);
    }

    public Controle readById(int id) {
        return controleRepository.ReadById(id);
    }

    public List<Controle> readAll() {
        return controleRepository.ReadAll();
    }

    public void updateById(Controle controle, int id) {
        controleRepository.UpdateById(controle, id);
    }

    public void deleteById(int id) {
        controleRepository.DeleteById(id);
    }
}
