package com.example.szkolenietechniczne1projekt.controllers.user;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.*;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class UserAddController extends MainController implements Initializable{

    @FXML
    private TableView<User> userTable;
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();

        setItemsToTableView(userTable, userService.getAllUsers());

        choiceRole.getItems().add(Role.USER.toString());
        choiceRole.getItems().add(Role.ADMIN.toString());

        setItemsToChoiceBox(choiceHall, userService.getAllHalls());
        setItemsToChoiceBox(choiceGroup, userService.getAllGroups());
        setItemsToChoiceBox(choiceTrainer, userService.getAllTrainers());

    }



    public void addUser() {
        User user = new User();

        user.setUsername(usernameField.getText());
        user.setPassword(passwordField.getText());
        user.setHallId(choiceHall.getValue().getId());
        user.setGroupId(choiceGroup.getValue().getId());
        user.setTrainerId(choiceTrainer.getValue().getId());
        user.setRole(Role.valueOf(choiceRole.getValue()));

        userService.addUser(user);

        setItemsToTableView(userTable, userService.getAllUsers());
    }


}
