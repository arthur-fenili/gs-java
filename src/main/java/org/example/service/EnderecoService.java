package org.example.service;

import org.example.entities.Endereco;
import org.example.repository.EnderecoRepository;

import java.util.List;

public class EnderecoService {
    private EnderecoRepository enderecoRepository = new EnderecoRepository();

    public void create(Endereco endereco) {
        enderecoRepository.create(endereco);
    }

    public Endereco readById(int id) {
        return enderecoRepository.readById(id);
    }

    public List<Endereco> readAll() {
        return enderecoRepository.readAll();
    }

    public void updateById(Endereco endereco, int id) {
        enderecoRepository.updateById(endereco, id);
    }

    public void deleteById(int id) {
        enderecoRepository.deleteById(id);
    }
}
