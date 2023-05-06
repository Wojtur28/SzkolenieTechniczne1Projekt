package com.example.szkolenietechniczne1projekt.services.main;

import com.example.szkolenietechniczne1projekt.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<User> getAllUsers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public List<Group> getAllGroups() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Group> groups = em.createQuery("SELECT g FROM Group g", Group.class).getResultList();
        em.close();
        return groups;
    }

    public List<Trainer> getAllTrainers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Trainer> trainers = em.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
        em.close();
        return trainers;
    }

    public List<Machine> getAllMachines() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Machine> machines = em.createQuery("SELECT m FROM Machine m", Machine.class).getResultList();
        em.close();
        return machines;
    }

    public List<Hall> getAllHalls() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Hall> halls = em.createQuery("SELECT h FROM Hall h", Hall.class).getResultList();
        em.close();
        return halls;
    }
}
