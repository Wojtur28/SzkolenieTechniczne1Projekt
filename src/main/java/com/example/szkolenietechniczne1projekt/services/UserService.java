package com.example.szkolenietechniczne1projekt.services;

import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.main.MainService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");


    public void addUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(User user) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        User existingUser = em.find(User.class, user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setHallId(user.getHallId());
            existingUser.setGroupId(user.getGroupId());
            existingUser.setTrainerId(user.getTrainerId());
            existingUser.setRole(user.getRole());
            em.merge(existingUser);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void setUserChoiceBoxValue(UserService userService, ChoiceBox<Hall> choiceHall, ChoiceBox<Group> choiceGroup, ChoiceBox<Trainer> choiceTrainer) {
        List<Hall> halls = userService.getAllHalls();
        ObservableList<Hall> hallIdsObservableList = FXCollections.observableArrayList(halls);
        choiceHall.setItems(hallIdsObservableList);

        List<Group> groups = userService.getAllGroups();
        ObservableList<Group> groupsObservableList = FXCollections.observableArrayList(groups);
        choiceGroup.setItems(groupsObservableList);

        List<Trainer> trainers = userService.getAllTrainers();
        ObservableList<Trainer> trainersObservableList = FXCollections.observableArrayList(trainers);
        choiceTrainer.setItems(trainersObservableList);
    }
}
