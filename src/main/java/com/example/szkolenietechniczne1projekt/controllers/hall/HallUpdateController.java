package com.example.szkolenietechniczne1projekt.controllers.hall;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.HallService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HallUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Hall> hallTable;
    @FXML
    private ChoiceBox<Hall> choiceHall;
    @FXML
    private TextField hallNameField;
    @FXML
    private TextField sizeField;
    @FXML
    private ChoiceBox<Boolean> choiceIsCleaned;
    HallService hallService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hallService = new HallService();
        choiceIsCleaned.getItems().addAll(true, false);

        setItemsToTableView(hallTable, hallService.getAllHalls());
        setItemsToChoiceBox(choiceHall, hallService.getAllHalls());
    }

    public void updateHall() {
        Hall selectedHall = choiceHall.getValue();

        selectedHall.setName(hallNameField.getText());
        selectedHall.setSize(Integer.parseInt(sizeField.getText()));
        selectedHall.setCleaned(choiceIsCleaned.getValue());

        hallService.updateHall(selectedHall);

        setItemsToTableView(hallTable, hallService.getAllHalls());
    }

}
