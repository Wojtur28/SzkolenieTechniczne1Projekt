package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.main.MainService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TrainerService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public void addTrainer(Trainer trainer) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(trainer);
        em.getTransaction().commit();
        em.close();
    }

    public void updateTrainer(Trainer trainer) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Trainer existingTrainer = em.find(Trainer.class, trainer.getId());
        if (existingTrainer != null) {
            existingTrainer.setFirstName(trainer.getFirstName());
            existingTrainer.setLastName(trainer.getLastName());
            existingTrainer.setEmail(trainer.getEmail());
            existingTrainer.setPhoneNumber(trainer.getPhoneNumber());
            em.merge(existingTrainer);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteTrainer(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Trainer trainer = em.find(Trainer.class, id);
        if (trainer != null) {
            em.remove(trainer);
        }
        em.getTransaction().commit();
        em.close();
    }
}
