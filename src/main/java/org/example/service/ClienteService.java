package org.example.service;

import org.example.entities.Cliente;
import org.example.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public void create(Cliente cliente) {
        clienteRepository.Create(cliente);
    }

    public Cliente readById(int id) {
        return clienteRepository.ReadById(id);
    }

    public List<Cliente> readAll() {
        return clienteRepository.ReadAll();
    }

    public void updateById(Cliente cliente, int id) {
        clienteRepository.UpdateById(cliente, id);
    }

    public void deleteById(int id) {
        clienteRepository.DeleteById(id);
    }
}
