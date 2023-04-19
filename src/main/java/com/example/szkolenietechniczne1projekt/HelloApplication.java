package com.example.szkolenietechniczne1projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setPassword("test");
        UserService userService = new UserService();
        /*userService.addUser(user);*/
        userService.getAllUsers();

        launch();

    }
}