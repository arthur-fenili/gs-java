package org.example.service;

import org.example.entities.ClienteNewsletter;
import org.example.repository.ClienteNewsletterRepository;

import java.util.List;

public class ClienteNewsletterService {
    private ClienteNewsletterRepository clienteNewsletterRepository = new ClienteNewsletterRepository();

    public void create(ClienteNewsletter clienteNewsletter) {
        clienteNewsletterRepository.create(clienteNewsletter);
    }

    public ClienteNewsletter readById(int id) {
        return clienteNewsletterRepository.readById(id);
    }

    public List<ClienteNewsletter> readAll() {
        return clienteNewsletterRepository.readAll();
    }

    public void updateById(ClienteNewsletter clienteNewsletter, int id) {
        clienteNewsletterRepository.updateById(clienteNewsletter, id);
    }

    public void deleteById(int id) {
        clienteNewsletterRepository.deleteById(id);
    }
}
