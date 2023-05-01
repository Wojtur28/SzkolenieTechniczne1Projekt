package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Trainer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TrainerService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<Trainer> getAllTrainers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Trainer> trainers = em.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
        em.close();
        return trainers;
    }
}
