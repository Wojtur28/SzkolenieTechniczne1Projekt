package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Machine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class MachineService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public List<Machine> getAllMachines() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List<Machine> machines = em.createQuery("SELECT m FROM Machine m", Machine.class).getResultList();
        em.close();
        return machines;
    }
}
