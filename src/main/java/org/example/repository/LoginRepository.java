package org.example.repository;

import org.example.entities.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginRepository {
    private List<Login> logins = new ArrayList<>();

    public void Create(Login login) {
        logins.add(login);
    }

    public Login ReadById(int id) {
        return logins.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public List<Login> ReadAll() {
        return new ArrayList<>(logins);
    }

    public void UpdateById(Login login, int id) {
        Login existingLogin = ReadById(id);
        if (existingLogin != null) {
            logins.remove(existingLogin);
            logins.add(login);
        }
    }

    public void DeleteById(int id) {
        Login login = ReadById(id);
        if (login != null) {
            logins.remove(login);
        }
    }
}
