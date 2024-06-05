package org.example.repository;

import org.example.entities.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsletterRepository {
    private List<Newsletter> newsletters = new ArrayList<>();

    public void Create(Newsletter newsletter) {
        newsletters.add(newsletter);
    }

    public Newsletter ReadById(int id) {
        return newsletters.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
    }

    public List<Newsletter> ReadAll() {
        return new ArrayList<>(newsletters);
    }

    public void UpdateById(Newsletter newsletter, int id) {
        Newsletter existingNewsletter = ReadById(id);
        if (existingNewsletter != null) {
            newsletters.remove(existingNewsletter);
            newsletters.add(newsletter);
        }
    }

    public void DeleteById(int id) {
        Newsletter newsletter = ReadById(id);
        if (newsletter != null) {
            newsletters.remove(newsletter);
        }
    }
}
