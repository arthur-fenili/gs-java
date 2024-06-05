package org.example.repository;

import org.example.entities.Pais;

import java.util.ArrayList;
import java.util.List;

public class PaisRepository {
    private List<Pais> paises = new ArrayList<>();

    public void Create(Pais pais) {
        paises.add(pais);
    }

    public Pais ReadById(int id) {
        return paises.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Pais> ReadAll() {
        return new ArrayList<>(paises);
    }

    public void UpdateById(Pais pais, int id) {
        Pais existingPais = ReadById(id);
        if (existingPais != null) {
            paises.remove(existingPais);
            paises.add(pais);
        }
    }

    public void DeleteById(int id) {
        Pais pais = ReadById(id);
        if (pais != null) {
            paises.remove(pais);
        }
    }
}
