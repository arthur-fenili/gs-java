package org.example.repository;

import org.example.entities.Controle;

import java.util.ArrayList;
import java.util.List;

public class ControleRepository {
    private List<Controle> controles = new ArrayList<>();

    public void Create(Controle controle) {
        controles.add(controle);
    }

    public Controle ReadById(int id) {
        return controles.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Controle> ReadAll() {
        return new ArrayList<>(controles);
    }

    public void UpdateById(Controle controle, int id) {
        Controle existingControle = ReadById(id);
        if (existingControle != null) {
            controles.remove(existingControle);
            controles.add(controle);
        }
    }

    public void DeleteById(int id) {
        Controle controle = ReadById(id);
        if (controle != null) {
            controles.remove(controle);
        }
    }
}
