package org.example.repository;

import org.example.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void Create(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente ReadById(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Cliente> ReadAll() {
        return new ArrayList<>(clientes);
    }

    public void UpdateById(Cliente cliente, int id) {
        Cliente existingCliente = ReadById(id);
        if (existingCliente != null) {
            clientes.remove(existingCliente);
            clientes.add(cliente);
        }
    }

    public void DeleteById(int id) {
        Cliente cliente = ReadById(id);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }
}
