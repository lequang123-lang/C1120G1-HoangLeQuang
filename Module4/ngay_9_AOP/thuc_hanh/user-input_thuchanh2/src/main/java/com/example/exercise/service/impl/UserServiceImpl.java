package com.example.exercise.service.impl;

import com.example.exercise.model.User;
import com.example.exercise.repository.UserRepository;
import com.example.exercise.service.DuplicateEmailException;
import com.example.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) throws DuplicateEmailException {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }

    }
}
