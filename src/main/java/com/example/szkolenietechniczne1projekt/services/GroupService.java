package com.example.szkolenietechniczne1projekt.services;


import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.main.MainService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GroupService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");

    public void addGroup(Group group) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
        em.close();
    }

    public void updateGroup(Group group) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Group existingGroup = em.find(Group.class, group.getId());
        if (existingGroup != null) {
            existingGroup.setName(group.getName());
            existingGroup.setDifficulty(group.getDifficulty());
            existingGroup.setHallId(group.getHallId());
            existingGroup.setTrainerId(group.getTrainerId());
            em.merge(existingGroup);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteGroup(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        Group group = em.find(Group.class, id);
        if (group != null) {
            em.remove(group);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void setGroupChoiceBoxValue(GroupService groupService, ChoiceBox<Hall> choiceHall, ChoiceBox<Trainer> choiceTrainer) {
        List<Hall> halls = groupService.getAllHalls();
        ObservableList<Hall> hallIdsObservableList = FXCollections.observableArrayList(halls);
        choiceHall.setItems(hallIdsObservableList);

        List<Trainer> trainers = groupService.getAllTrainers();
        ObservableList<Trainer> trainersObservableList = FXCollections.observableArrayList(trainers);
        choiceTrainer.setItems(trainersObservableList);
    }
}