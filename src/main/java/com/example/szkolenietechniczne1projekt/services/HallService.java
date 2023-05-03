package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Hall;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class HallService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<Hall> getAllHalls() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Hall> halls = em.createQuery("SELECT h FROM Hall h", Hall.class).getResultList();
        em.close();
        return halls;
    }

}
