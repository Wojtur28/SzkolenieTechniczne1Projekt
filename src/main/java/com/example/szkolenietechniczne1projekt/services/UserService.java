package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<User> getAllUsers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public boolean addUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        System.out.println("User added");
        return true;
    }
}
