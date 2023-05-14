package com.example.szkolenietechniczne1projekt.controllers;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        if(user != null && user.getPassword().equals(password)){
            changeSceneToAdminUsersListRead(event);
        }


    }

}
