package com.example.szkolenietechniczne1projekt.controllers.trainer;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.TrainerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerDeleteController extends MainController implements Initializable {

    @FXML
    private TableView<Trainer> trainerTable;
    @FXML
    private ChoiceBox<Trainer> choiceTrainer;
    TrainerService trainerService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerService = new TrainerService();

        setItemsToTableView(trainerTable, trainerService.getAllTrainers());

        setItemsToChoiceBox(choiceTrainer, trainerService.getAllTrainers());
    }

    public void deleteTrainer() {
        Trainer selectedTrainer = choiceTrainer.getValue();
        trainerService.deleteTrainer(selectedTrainer.getId());

        setItemsToTableView(trainerTable, trainerService.getAllTrainers());
    }
}
