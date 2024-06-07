package org.example.service;

import org.example.entities.Login;
import org.example.repository.LoginRepository;

import java.util.List;

public class LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    public void create(Login login) {
        loginRepository.create(login);
    }

    public Login readById(int id) {return loginRepository.readById(id);
    }

    public List<Login> readAll() {
        return loginRepository.readAll();
    }

    public void updateById(Login login, int id) {
        loginRepository.updateById(login, id);
    }

    public void deleteById(int id) {
        loginRepository.deleteById(id);
    }
}
