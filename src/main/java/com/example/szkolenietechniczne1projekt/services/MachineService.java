package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.main.MainService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class MachineService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");


    public  void addMachine(Machine machine) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(machine);
        em.getTransaction().commit();
        em.close();
    }

    public void updateMachine(Machine machine) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Machine existingMachine = em.find(Machine.class, machine.getId());
        if (existingMachine != null) {
            existingMachine.setName(machine.getName());
            existingMachine.setCondition(machine.getCondition());
            existingMachine.setQuantity(machine.getQuantity());
            existingMachine.setHallId(machine.getHallId());
            em.merge(existingMachine);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteMachine(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Machine machine = em.find(Machine.class, id);
        if (machine != null) {
            em.remove(machine);
        }
        em.getTransaction().commit();
        em.close();
    }



}
