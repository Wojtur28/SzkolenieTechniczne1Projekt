package com.example.szkolenietechniczne1projekt.controllers.group;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.services.GroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GroupDeleteController extends MainController implements Initializable {

    @FXML
    private TableView<Group> groupTable;
    @FXML
    private ChoiceBox<Group> choiceGroup;

    GroupService groupService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupService = new GroupService();
        List<Group> groups = groupService.getAllGroups();
        ObservableList<Group> observableList = FXCollections.observableArrayList(groups);
        groupTable.setItems(observableList);

        choiceGroup.setItems(observableList);
    }

    public void deleteGroup() {
        Group selectedGroup = choiceGroup.getValue();
        groupService.deleteGroup(selectedGroup.getId());

        List<Group> updatedGroups = groupService.getAllGroups();
        ObservableList<Group> observableList = FXCollections.observableArrayList(updatedGroups);
        groupTable.setItems(observableList);
    }
}
