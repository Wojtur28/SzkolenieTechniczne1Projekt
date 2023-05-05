package com.example.szkolenietechniczne1projekt.controllers;

import com.example.szkolenietechniczne1projekt.controllers.sceneController.SceneController;
import com.example.szkolenietechniczne1projekt.models.Role;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserController extends SceneController implements Initializable{

    @FXML
    private TableView<User> userTable;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField hallField;
    @FXML
    private TextField groupField;
    @FXML
    private TextField trainerField;
    @FXML
    private TextField roleField;

    UserService userService;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();
        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);
    }

    public void addUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String hall = hallField.getText();
        String group = groupField.getText();
        String trainer = trainerField.getText();
        String role = roleField.getText();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHallId(Long.valueOf(hall));
        user.setGroupId(Long.valueOf(group));
        user.setTrainerId(Long.valueOf(trainer));
        user.setRole(Role.valueOf(role));

        userService.addUser(user);

        // zaktualizuj tabelę użytkowników
        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);
    }


}
