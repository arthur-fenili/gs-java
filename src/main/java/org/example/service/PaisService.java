package org.example.service;

import org.example.entities.Pais;
import org.example.repository.PaisRepository;

import java.util.List;

public class PaisService {
    private PaisRepository paisRepository = new PaisRepository();

    public void create(Pais pais) {
        paisRepository.Create(pais);
    }

    public Pais readById(int id) {
        return paisRepository.ReadById(id);
    }

    public List<Pais> readAll() {
        return paisRepository.ReadAll();
    }

    public void updateById(Pais pais, int id) {
        paisRepository.UpdateById(pais, id);
    }

    public void deleteById(int id) {
        paisRepository.DeleteById(id);
    }
}
