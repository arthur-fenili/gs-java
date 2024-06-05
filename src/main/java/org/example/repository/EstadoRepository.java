package org.example.repository;

import org.example.entities.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoRepository {
    private List<Estado> estados = new ArrayList<>();

    public void Create(Estado estado) {
        estados.add(estado);
    }

    public Estado ReadById(int id) {
        return estados.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Estado> ReadAll() {
        return new ArrayList<>(estados);
    }

    public void UpdateById(Estado estado, int id) {
        Estado existingEstado = ReadById(id);
        if (existingEstado != null) {
            estados.remove(existingEstado);
            estados.add(estado);
        }
    }

    public void DeleteById(int id) {
        Estado estado = ReadById(id);
        if (estado != null) {
            estados.remove(estado);
        }
    }
}
