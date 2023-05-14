package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.main.MainService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");


    public void addUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        User existingUser = em.find(User.class, user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setHallId(user.getHallId());
            existingUser.setGroupId(user.getGroupId());
            existingUser.setTrainerId(user.getTrainerId());
            existingUser.setRole(user.getRole());
            em.merge(existingUser);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }


}
