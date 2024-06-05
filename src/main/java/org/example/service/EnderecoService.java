package org.example.service;

import org.example.entities.Endereco;
import org.example.repository.EnderecoRepository;

import java.util.List;

public class EnderecoService {
    private EnderecoRepository enderecoRepository = new EnderecoRepository();

    public void create(Endereco endereco) {
        enderecoRepository.Create(endereco);
    }

    public Endereco readById(int id) {
        return enderecoRepository.ReadById(id);
    }

    public List<Endereco> readAll() {
        return enderecoRepository.ReadAll();
    }

    public void updateById(Endereco endereco, int id) {
        enderecoRepository.UpdateById(endereco, id);
    }

    public void deleteById(int id) {
        enderecoRepository.DeleteById(id);
    }
}
