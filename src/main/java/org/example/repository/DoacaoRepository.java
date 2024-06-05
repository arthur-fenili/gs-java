package org.example.repository;

import org.example.entities.Doacao;

import java.util.ArrayList;
import java.util.List;

public class DoacaoRepository {
    private List<Doacao> doacoes = new ArrayList<>();

    public void Create(Doacao doacao) {
        doacoes.add(doacao);
    }

    public Doacao ReadById(int id) {
        return doacoes.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public List<Doacao> ReadAll() {
        return new ArrayList<>(doacoes);
    }

    public void UpdateById(Doacao doacao, int id) {
        Doacao existingDoacao = ReadById(id);
        if (existingDoacao != null) {
            doacoes.remove(existingDoacao);
            doacoes.add(doacao);
        }
    }

    public void DeleteById(int id) {
        Doacao doacao = ReadById(id);
        if (doacao != null) {
            doacoes.remove(doacao);
        }
    }
}
