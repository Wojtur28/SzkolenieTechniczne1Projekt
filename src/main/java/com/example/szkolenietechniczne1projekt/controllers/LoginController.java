package com.example.szkolenietechniczne1projekt.controllers;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Role;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends MainController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    UserService userService = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void login(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = userService.getUserByUsername(username);

        if(user != null && user.getPassword().equals(password) && user.getRole() == Role.ADMIN){
            changeSceneToAdminUsersListRead(event);
        } else if(user != null && user.getPassword().equals(password) && user.getRole() == Role.USER){
            changeSceneToGroupsListRead(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong username or password");
            alert.showAndWait();
        }


    }

}
