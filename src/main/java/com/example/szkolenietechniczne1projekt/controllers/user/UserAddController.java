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

import static com.example.szkolenietechniczne1projekt.services.UserService.setUserChoiceBoxValue;

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

        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);

        choiceRole.getItems().add(Role.USER.toString());
        choiceRole.getItems().add(Role.ADMIN.toString());

        setUserChoiceBoxValue(userService, choiceHall, choiceGroup, choiceTrainer);

    }

    public void addUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String hall = choiceHall.getValue().toString();
        String group = choiceGroup.getValue().toString();
        String trainer = choiceTrainer.getValue().toString();
        String role = choiceRole.getValue();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHallId(Long.valueOf(hall));
        user.setGroupId(Long.valueOf(group));
        user.setTrainerId(Long.valueOf(trainer));
        user.setRole(Role.valueOf(role));

        userService.addUser(user);

        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        userTable.setItems(observableList);
    }


}
