package org.example.repository;

import org.example.entities.ClienteNewsletter;

import java.util.ArrayList;
import java.util.List;

public class ClienteNewsletterRepository {
    private List<ClienteNewsletter> clienteNewsletters = new ArrayList<>();

    public void Create(ClienteNewsletter clienteNewsletter) {
        clienteNewsletters.add(clienteNewsletter);
    }

    public ClienteNewsletter ReadById(int id) {
        return clienteNewsletters.stream().filter(cn -> cn.getId() == id).findFirst().orElse(null);
    }

    public List<ClienteNewsletter> ReadAll() {
        return new ArrayList<>(clienteNewsletters);
    }

    public void UpdateById(ClienteNewsletter clienteNewsletter, int id) {
        ClienteNewsletter existingClienteNewsletter = ReadById(id);
        if (existingClienteNewsletter != null) {
            clienteNewsletters.remove(existingClienteNewsletter);
            clienteNewsletters.add(clienteNewsletter);
        }
    }

    public void DeleteById(int id) {
        ClienteNewsletter clienteNewsletter = ReadById(id);
        if (clienteNewsletter != null) {
            clienteNewsletters.remove(clienteNewsletter);
        }
    }
}
