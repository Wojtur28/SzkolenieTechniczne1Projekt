package com.example.szkolenietechniczne1projekt.controllers;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Role;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends MainController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    UserService userService = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void register() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User existingUser = userService.getUserByUsername(username);
        if (existingUser != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username already exists");
            alert.setContentText("Please choose a different username");
            alert.showAndWait();
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(Role.USER);

        userService.addUser(newUser);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("User registered successfully");
        alert.showAndWait();

        usernameField.clear();
        passwordField.clear();
    }

}
