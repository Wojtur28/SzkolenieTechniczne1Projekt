package com.example.szkolenietechniczne1projekt.controllers;

import com.example.szkolenietechniczne1projekt.controllers.sceneController.SceneController;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserController extends SceneController implements Initializable{

    @FXML
    private TableView<User> userTable;

    UserService userService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();
        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);
    }


}
