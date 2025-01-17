package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByUsername(String username);
    void save(User user);
    User createNewUser(String username, String password);
}
