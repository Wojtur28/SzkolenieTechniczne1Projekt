package com.example.szkolenietechniczne1projekt.controllers.group;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Difficulty;
import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.GroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.szkolenietechniczne1projekt.services.GroupService.setGroupChoiceBoxValue;

public class GroupAddController extends MainController implements Initializable {

    @FXML
    private TableView<Group> groupTable;
    @FXML
    private TextField nameGroupField;
    @FXML
    private ChoiceBox<Difficulty> choiceDifficulty;
    @FXML
    private ChoiceBox<Hall> choiceHall;
    @FXML
    private ChoiceBox<Trainer> choiceTrainer;
    GroupService groupService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupService = new GroupService();
        List<Group> groups = groupService.getAllGroups();
        ObservableList<Group> observableList = FXCollections.observableArrayList(groups);
        groupTable.setItems(observableList);

        choiceDifficulty.setItems(FXCollections.observableArrayList(Difficulty.values()));

        setGroupChoiceBoxValue(groupService, choiceHall, choiceTrainer);
    }

    public void addGroup() {
        String name = nameGroupField.getText();
        Difficulty difficulty = choiceDifficulty.getValue();
        Hall hall = choiceHall.getValue();
        Trainer trainer = choiceTrainer.getValue();

        Group group = new Group();
        group.setName(name);
        group.setDifficulty(difficulty);
        group.setHallId(hall.getId());
        group.setTrainerId(trainer.getId());

        groupService.addGroup(group);

        List<Group> groups = groupService.getAllGroups();
        ObservableList<Group> observableList = FXCollections.observableArrayList(groups);
        groupTable.setItems(observableList);
    }
}
