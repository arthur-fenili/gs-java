package org.example.service;

import org.example.entities.Newsletter;
import org.example.repository.NewsletterRepository;

import java.util.List;

public class NewsletterService {
    private NewsletterRepository newsletterRepository = new NewsletterRepository();

    public void create(Newsletter newsletter) {
        newsletterRepository.create(newsletter);
    }

    public Newsletter readById(int id) {
        return newsletterRepository.readById(id);
    }

    public List<Newsletter> readAll() {
        return newsletterRepository.readAll();
    }

    public void updateById(Newsletter newsletter, int id) {
        newsletterRepository.updateById(newsletter, id);
    }

    public void deleteById(int id) {
        newsletterRepository.deleteById(id);
    }
}
