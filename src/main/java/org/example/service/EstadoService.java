package org.example.service;

import org.example.entities.Estado;
import org.example.repository.EstadoRepository;

import java.util.List;

public class EstadoService {
    private EstadoRepository estadoRepository = new EstadoRepository();

    public void create(Estado estado) {
        estadoRepository.Create(estado);
    }

    public Estado readById(int id) {
        return estadoRepository.ReadById(id);
    }

    public List<Estado> readAll() {
        return estadoRepository.ReadAll();
    }

    public void updateById(Estado estado, int id) {
        estadoRepository.UpdateById(estado, id);
    }

    public void deleteById(int id) {
        estadoRepository.DeleteById(id);
    }
}
