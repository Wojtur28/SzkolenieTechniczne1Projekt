package com.example.szkolenietechniczne1projekt.controllers.trainer;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Trainer;
import com.example.szkolenietechniczne1projekt.services.TrainerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TrainerReadController extends MainController implements Initializable {

    @FXML
    private TableView<Trainer> trainerTable;

    TrainerService trainerService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerService = new TrainerService();
        setItemsToTableView(trainerTable, trainerService.getAllTrainers());
    }
}
