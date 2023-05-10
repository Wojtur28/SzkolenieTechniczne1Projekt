package com.example.szkolenietechniczne1projekt.controllers.group;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Group;
import com.example.szkolenietechniczne1projekt.services.GroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GroupUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Group> groupTable;

    GroupService groupService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupService = new GroupService();
        List<Group> groups = groupService.getAllGroups();
        ObservableList<Group> observableList = FXCollections.observableArrayList(groups);
        groupTable.setItems(observableList);
    }
}
