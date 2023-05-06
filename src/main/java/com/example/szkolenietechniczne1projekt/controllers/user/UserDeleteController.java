package com.example.szkolenietechniczne1projekt.controllers.user;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserDeleteController  extends MainController implements Initializable {

    @FXML
    private TableView<User> userTable;
    @FXML
    private ChoiceBox<User> choiceUser;

    UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();

        List<User> users = userService.getAllUsers();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        choiceUser.setItems(observableList);
        userTable.setItems(observableList);
    }

    public void deleteUser() {
        User selectedUser = choiceUser.getValue();
        userService.deleteUser(selectedUser.getId());

        List<User> updatedUsers = userService.getAllUsers();
        ObservableList<User> updatedObservableList = FXCollections.observableArrayList(updatedUsers);
        choiceUser.setItems(updatedObservableList);
    }
}
