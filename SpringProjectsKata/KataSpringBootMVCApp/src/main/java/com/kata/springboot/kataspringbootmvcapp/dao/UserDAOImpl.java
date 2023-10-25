package com.kata.springboot.kataspringbootmvcapp.dao;

import com.kata.springboot.kataspringbootmvcapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> userQuery = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        userQuery.setParameter("id", id);
        return userQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        User userUpdate = entityManager.find(User.class, id);
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());

    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        User userRemove = entityManager.find(User.class, id);
        entityManager.remove(userRemove);
    }
}
