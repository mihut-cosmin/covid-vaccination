package com.covid.vaccination.service;

import com.covid.vaccination.model.User;
import com.covid.vaccination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
