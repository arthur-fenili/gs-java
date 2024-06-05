package org.example.service;

import org.example.entities.ClienteNewsletter;
import org.example.repository.ClienteNewsletterRepository;

import java.util.List;

public class ClienteNewsletterService {
    private ClienteNewsletterRepository clienteNewsletterRepository = new ClienteNewsletterRepository();

    public void create(ClienteNewsletter clienteNewsletter) {
        clienteNewsletterRepository.Create(clienteNewsletter);
    }

    public ClienteNewsletter readById(int id) {
        return clienteNewsletterRepository.ReadById(id);
    }

    public List<ClienteNewsletter> readAll() {
        return clienteNewsletterRepository.ReadAll();
    }

    public void updateById(ClienteNewsletter clienteNewsletter, int id) {
        clienteNewsletterRepository.UpdateById(clienteNewsletter, id);
    }

    public void deleteById(int id) {
        clienteNewsletterRepository.DeleteById(id);
    }
}
