package com.example.szkolenietechniczne1projekt.controllers.trainer;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.TrainerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerAddController extends MainController implements Initializable {

    @FXML
    private TableView<Trainer> trainerTable;
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

        setItemsToTableView(trainerTable, trainerService.getAllTrainers());
    }

    public void addTrainer() {
        Trainer trainer = new Trainer();
        trainer.setFirstName(firstNameField.getText());
        trainer.setLastName(lastNameField.getText());
        trainer.setEmail(emailField.getText());
        trainer.setPhoneNumber(phoneNumberField.getText());


        if (isTextFieldEmpty(firstNameField) || isTextFieldEmpty(lastNameField)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Pola imię i nazwisko nie mogą być puste!");
            alert.showAndWait();
            return;
        }

        if(isValidEmail(trainer.getEmail()) || isValidPhoneNumber(trainer.getPhoneNumber())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Niepoprawny email lub numer telefonu!");
            alert.showAndWait();
            return;
        }

        trainerService.addTrainer(trainer);

        setItemsToTableView(trainerTable, trainerService.getAllTrainers());
    }


}
