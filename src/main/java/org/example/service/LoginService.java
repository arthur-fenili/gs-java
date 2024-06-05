package org.example.service;

import org.example.entities.Login;
import org.example.repository.LoginRepository;

import java.util.List;

public class LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    public void create(Login login) {
        loginRepository.Create(login);
    }

    public Login readById(int id) {
        return loginRepository.ReadById(id);
    }

    public List<Login> readAll() {
        return loginRepository.ReadAll();
    }

    public void updateById(Login login, int id) {
        loginRepository.UpdateById(login, id);
    }

    public void deleteById(int id) {
        loginRepository.DeleteById(id);
    }
}
