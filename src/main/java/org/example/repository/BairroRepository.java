package org.example.repository;

import org.example.entities.Bairro;

import java.util.ArrayList;
import java.util.List;

public class BairroRepository {
    private List<Bairro> bairros = new ArrayList<>();

    public void Create(Bairro bairro) {
        bairros.add(bairro);
    }

    public Bairro ReadById(int id) {
        return bairros.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public List<Bairro> ReadAll() {
        return new ArrayList<>(bairros);
    }

    public void UpdateById(Bairro bairro, int id) {
        Bairro existingBairro = ReadById(id);
        if (existingBairro != null) {
            bairros.remove(existingBairro);
            bairros.add(bairro);
        }
    }

    public void DeleteById(int id) {
        Bairro bairro = ReadById(id);
        if (bairro != null) {
            bairros.remove(bairro);
        }
    }
}
