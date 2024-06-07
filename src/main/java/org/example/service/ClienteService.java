package org.example.service;

import org.example.entities.Cliente;
import org.example.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public void create(Cliente cliente) {
        clienteRepository.create(cliente);
    }

    public Cliente readById(int id) {
        return clienteRepository.readById(id);
    }

    public List<Cliente> readAll() {
        return clienteRepository.readAll();
    }

    public void updateById(Cliente cliente, int id) {
        clienteRepository.updateById(cliente, id);
    }

    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}
