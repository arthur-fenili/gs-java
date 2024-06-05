package org.example.service;

import org.example.entities.Newsletter;
import org.example.repository.NewsletterRepository;

import java.util.List;

public class NewsletterService {
    private NewsletterRepository newsletterRepository = new NewsletterRepository();

    public void create(Newsletter newsletter) {
        newsletterRepository.Create(newsletter);
    }

    public Newsletter readById(int id) {
        return newsletterRepository.ReadById(id);
    }

    public List<Newsletter> readAll() {
        return newsletterRepository.ReadAll();
    }

    public void updateById(Newsletter newsletter, int id) {
        newsletterRepository.UpdateById(newsletter, id);
    }

    public void deleteById(int id) {
        newsletterRepository.DeleteById(id);
    }
}
