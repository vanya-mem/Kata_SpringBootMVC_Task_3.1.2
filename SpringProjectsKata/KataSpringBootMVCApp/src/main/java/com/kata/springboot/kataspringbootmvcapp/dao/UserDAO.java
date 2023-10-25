package com.kata.springboot.kataspringbootmvcapp.dao;

import com.kata.springboot.kataspringbootmvcapp.model.User;

import java.util.List;

public interface UserDAO {
    
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(int id, User user);

    void deleteUserById(int id);
}
