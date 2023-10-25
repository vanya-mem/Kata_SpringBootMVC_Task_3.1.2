package com.kata.springboot.kataspringbootmvcapp.service;


import com.kata.springboot.kataspringbootmvcapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(int id, User user);

    void deleteUserById(int id);
}
