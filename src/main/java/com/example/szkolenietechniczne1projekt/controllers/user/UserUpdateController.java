package com.example.szkolenietechniczne1projekt.controllers.user;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.*;
import com.example.szkolenietechniczne1projekt.services.UserService;
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

public class UserUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<User> userTable;
    @FXML
    private ChoiceBox<User> choiceUser;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private ChoiceBox<Hall> choiceHall;
    @FXML
    private ChoiceBox<Group> choiceGroup;
    @FXML
    private ChoiceBox<Trainer> choiceTrainer;
    @FXML
    private ChoiceBox<String> choiceRole;

    UserService userService;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();

        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        choiceUser.setItems(observableList);
        userTable.setItems(observableList);

        choiceRole.getItems().add(Role.USER.toString());
        choiceRole.getItems().add(Role.ADMIN.toString());

        setChoiceBoxValue(userService, choiceHall, choiceGroup, choiceTrainer);

    }

    public void updateUser() {
        User selectedUser = choiceUser.getValue();

        selectedUser.setUsername(usernameField.getText());
        selectedUser.setPassword(passwordField.getText());
        selectedUser.setHallId(choiceHall.getValue().getId());
        selectedUser.setGroupId(choiceGroup.getValue().getId());
        selectedUser.setTrainerId(choiceTrainer.getValue().getId());
        selectedUser.setRole(Role.valueOf(choiceRole.getValue()));

        userService.updateUser(selectedUser);

        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);
    }
}
