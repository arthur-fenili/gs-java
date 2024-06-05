package org.example.repository;

import org.example.entities.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {
    private List<Endereco> enderecos = new ArrayList<>();

    public void Create(Endereco endereco) {
        enderecos.add(endereco);
    }

    public Endereco ReadById(int id) {
        return enderecos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Endereco> ReadAll() {
        return new ArrayList<>(enderecos);
    }

    public void UpdateById(Endereco endereco, int id) {
        Endereco existingEndereco = ReadById(id);
        if (existingEndereco != null) {
            enderecos.remove(existingEndereco);
            enderecos.add(endereco);
        }
    }

    public void DeleteById(int id) {
        Endereco endereco = ReadById(id);
        if (endereco != null) {
            enderecos.remove(endereco);
        }
    }
}
