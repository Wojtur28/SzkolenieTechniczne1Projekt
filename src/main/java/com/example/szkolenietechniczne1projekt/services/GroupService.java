package com.example.szkolenietechniczne1projekt.services;


import com.example.szkolenietechniczne1projekt.models.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GroupService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<Group> getAllGroups() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Group> groups = em.createQuery("SELECT g FROM Group g", Group.class).getResultList();
        em.close();
        return groups;
    }

}