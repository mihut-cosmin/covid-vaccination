package com.covid.vaccination.service;

import com.covid.vaccination.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);
}
