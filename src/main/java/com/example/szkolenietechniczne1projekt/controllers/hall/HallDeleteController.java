package com.example.szkolenietechniczne1projekt.controllers.hall;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.HallService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HallDeleteController extends MainController implements Initializable {

    @FXML
    private TableView<Hall> hallTable;
    @FXML
    private ChoiceBox<Hall> choiceHall;

    HallService hallService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hallService = new HallService();
        List<Hall> halls = hallService.getAllHalls();
        ObservableList<Hall> observableList = javafx.collections.FXCollections.observableArrayList(halls);
        hallTable.setItems(observableList);
        choiceHall.setItems(observableList);
    }

    public void deleteHall() {
        Hall selectedHall = choiceHall.getValue();
        hallService.deleteHall(selectedHall.getId());

        List<Hall> halls = hallService.getAllHalls();
        ObservableList<Hall> observableList = javafx.collections.FXCollections.observableArrayList(halls);
        hallTable.setItems(observableList);
    }

}