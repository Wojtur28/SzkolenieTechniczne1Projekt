package com.example.szkolenietechniczne1projekt.services.main;

import com.example.szkolenietechniczne1projekt.models.*;

import javax.persistence.*;
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

    public User getUserByUsername(String username) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        User user = null;

        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
            query.setParameter("username", username);
            user = (User) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("User not found");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return user;
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
