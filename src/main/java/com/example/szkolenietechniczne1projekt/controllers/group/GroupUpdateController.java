package com.example.szkolenietechniczne1projekt.controllers.group;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Difficulty;
import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.GroupService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Group> groupTable;
    @FXML
    private ChoiceBox<Group> choiceGroup;
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

        setItemsToTableView(groupTable, groupService.getAllGroups());

        choiceDifficulty.setItems(FXCollections.observableArrayList(Difficulty.values()));
        choiceDifficulty.setValue(Difficulty.EASY);

        setItemsToChoiceBox(choiceHall, groupService.getAllHalls());
        setItemsToChoiceBox(choiceTrainer, groupService.getAllTrainers());
        setItemsToChoiceBox(choiceGroup, groupService.getAllGroups());
    }

    public void updateGroup() {
        Group selectedGroup = choiceGroup.getValue();

        selectedGroup.setName(nameGroupField.getText());
        selectedGroup.setDifficulty(choiceDifficulty.getValue());
        selectedGroup.setHallId(choiceHall.getValue().getId());
        selectedGroup.setTrainerId(choiceTrainer.getValue().getId());

        groupService.updateGroup(selectedGroup);

        setItemsToTableView(groupTable, groupService.getAllGroups());
    }


}
