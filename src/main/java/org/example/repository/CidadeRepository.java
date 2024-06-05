package org.example.repository;

import org.example.entities.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeRepository {
    private List<Cidade> cidades = new ArrayList<>();

    public void Create(Cidade cidade) {
        cidades.add(cidade);
    }

    public Cidade ReadById(int id) {
        return cidades.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Cidade> ReadAll() {
        return new ArrayList<>(cidades);
    }

    public void UpdateById(Cidade cidade, int id) {
        Cidade existingCidade = ReadById(id);
        if (existingCidade != null) {
            cidades.remove(existingCidade);
            cidades.add(cidade);
        }
    }

    public void DeleteById(int id) {
        Cidade cidade = ReadById(id);
        if (cidade != null) {
            cidades.remove(cidade);
        }
    }
}
