package com.example.szkolenietechniczne1projekt.controllers.trainer;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.TrainerService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TrainerUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Trainer> trainerTable;
    @FXML
    private ChoiceBox<Trainer> choiceTrainer;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;

    TrainerService trainerService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerService = new TrainerService();

        List<Trainer> trainers = trainerService.getAllTrainers();
        ObservableList<Trainer> observableList = javafx.collections.FXCollections.observableArrayList(trainers);
        trainerTable.setItems(observableList);

        choiceTrainer.setItems(observableList);
    }

    public void updateTrainer() {
        Trainer selectedTrainer = choiceTrainer.getValue();

        selectedTrainer.setFirstName(firstNameField.getText());
        selectedTrainer.setLastName(lastNameField.getText());
        selectedTrainer.setEmail(emailField.getText());
        selectedTrainer.setPhoneNumber(phoneNumberField.getText());

        trainerService.updateTrainer(selectedTrainer);

        List<Trainer> trainers = trainerService.getAllTrainers();
        ObservableList<Trainer> observableList = javafx.collections.FXCollections.observableArrayList(trainers);
        trainerTable.setItems(observableList);
    }
}
