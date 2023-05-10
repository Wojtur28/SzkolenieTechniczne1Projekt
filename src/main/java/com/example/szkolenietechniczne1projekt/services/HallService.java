package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.main.MainService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class HallService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public void addHall(Hall hall) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(hall);
        em.getTransaction().commit();
        em.close();
    }

    public void updateHall(Hall hall) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Hall existingHall = em.find(Hall.class, hall.getId());
        if (existingHall != null) {
            existingHall.setName(hall.getName());
            existingHall.setSize(hall.getSize());
            existingHall.setCleaned(hall.getIsCleaned());
            em.merge(existingHall);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteHall(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Hall hall = em.find(Hall.class, id);
        if (hall != null) {
            em.remove(hall);
        }
        em.getTransaction().commit();
        em.close();
    }
}
