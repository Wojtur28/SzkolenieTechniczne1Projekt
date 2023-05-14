package com.example.szkolenietechniczne1projekt.controllers.user;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.User;
import com.example.szkolenietechniczne1projekt.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class UserReadController extends MainController implements Initializable {

    @FXML
    private TableView<User> userTable;

    UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userService = new UserService();
        setItemsToTableView(userTable, userService.getAllUsers());
    }
}
