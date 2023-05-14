package com.example.szkolenietechniczne1projekt.services.main;

import com.example.szkolenietechniczne1projekt.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    private <T> List<T> getAllEntities(String query, Class<T> entityClass) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<T> entities = em.createQuery(query, entityClass).getResultList();
        em.close();
        return entities;
    }

    public List<User> getAllUsers() {
        return getAllEntities("SELECT u FROM User u", User.class);
    }

    public List<Group> getAllGroups() {
        return getAllEntities("SELECT g FROM Group g", Group.class);
    }

    public List<Trainer> getAllTrainers() {
        return getAllEntities("SELECT t FROM Trainer t", Trainer.class);
    }

    public List<Machine> getAllMachines() {
        return getAllEntities("SELECT m FROM Machine m", Machine.class);
    }

    public List<Hall> getAllHalls() {
        return getAllEntities("SELECT h FROM Hall h", Hall.class);
    }


}
