package com.example.szkolenietechniczne1projekt.controllers.mainController;

import com.example.szkolenietechniczne1projekt.HelloApplication;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public abstract class MainController {


    @FXML
    public void closeApp() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void changeScene(ActionEvent actionEvent, String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void changeSceneToRegister(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "firstScene/RegisterScene.fxml");
    }

    @FXML
    public void changeSceneToLogin(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "firstScene/LoginScene.fxml");
    }

    @FXML
    public void changeSceneToAdminUsersListAdd(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/usersList/AdminSceneUsersListAdd.fxml");
    }

    @FXML
    public void changeSceneToAdminUsersListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/usersList/AdminSceneUsersListRead.fxml");
    }

    @FXML
    public void changeSceneToAdminUsersListUpdate(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/usersList/AdminSceneUsersListUpdate.fxml");
    }

    @FXML
    public void changeSceneToAdminUsersListDelete(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/usersList/AdminSceneUsersListDelete.fxml");
    }

    @FXML
    public void changeSceneToAdminGroupsListAdd(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/groupsList/AdminSceneGroupsListAdd.fxml");
    }

    @FXML
    public void changeSceneToAdminGroupsListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/groupsList/AdminSceneGroupsListRead.fxml");
    }

    @FXML
    public void changeSceneToAdminGroupsListUpdate(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/groupsList/AdminSceneGroupsListUpdate.fxml");
    }

    @FXML
    public void changeSceneToAdminGroupsListDelete(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/groupsList/AdminSceneGroupsListDelete.fxml");
    }

    @FXML
    public void changeSceneToAdminTrainersListAdd(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/trainersList/AdminSceneTrainersListAdd.fxml");
    }

    @FXML
    public void changeSceneToAdminTrainersListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/trainersList/AdminSceneTrainersListRead.fxml");
    }

    @FXML
    public void changeSceneToAdminTrainersListUpdate(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/trainersList/AdminSceneTrainersListUpdate.fxml");
    }

    @FXML
    public void changeSceneToAdminTrainersListDelete(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/trainersList/AdminSceneTrainersListDelete.fxml");
    }

    @FXML
    public void changeSceneToAdminHallsListAdd(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/hallsList/AdminSceneHallsListAdd.fxml");
    }

    @FXML
    public void changeSceneToAdminHallsListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/hallsList/AdminSceneHallsListRead.fxml");
    }

    @FXML
    public void changeSceneToAdminHallsListUpdate(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/hallsList/AdminSceneHallsListUpdate.fxml");
    }

    @FXML
    public void changeSceneToAdminHallsListDelete(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/hallsList/AdminSceneHallsListDelete.fxml");
    }

    @FXML
    public void changeSceneToAdminMachinesListAdd(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/machinesList/AdminSceneMachinesListAdd.fxml");
    }

    @FXML
    public void changeSceneToAdminMachinesListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/machinesList/AdminSceneMachinesListRead.fxml");
    }

    @FXML
    public void changeSceneToAdminMachinesListUpdate(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/machinesList/AdminSceneMachinesListUpdate.fxml");
    }

    @FXML
    public void changeSceneToAdminMachinesListDelete(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "admin/machinesList/AdminSceneMachinesListDelete.fxml");
    }

    @FXML
    public void changeSceneToUsersListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "user/UserSceneUsersListRead.fxml");
    }
    @FXML
    public void changeSceneToGroupsListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "user/UserSceneGroupsListRead.fxml");
    }
    @FXML
    public void changeSceneToHallsListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "user/UserSceneHallsListRead.fxml");
    }
    @FXML
    public void changeSceneToMachinesListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "user/UserSceneMachinesListRead.fxml");
    }
    @FXML
    public void changeSceneToTrainersListRead(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "user/UserSceneTrainersListRead.fxml");
    }

    public <T> void setItemsToChoiceBox(ChoiceBox<T> comboBox, List<T> items) {
        ObservableList<T> observableList = FXCollections.observableArrayList(items);
        comboBox.setItems(observableList);
    }

    public <T> void setItemsToTableView(TableView<T> tableView, List<T> items) {
        ObservableList<T> observableList = FXCollections.observableArrayList(items);
        tableView.setItems(observableList);
    }

    protected boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return !email.matches(emailRegex);
    }

    protected boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "\\d{9}";
        return !phoneNumber.matches(phoneRegex);
    }

    protected boolean isTextFieldEmpty(TextField textField) {
        return textField.getText().isEmpty();
    }
}
