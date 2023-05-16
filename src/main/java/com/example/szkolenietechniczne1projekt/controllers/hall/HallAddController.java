package com.example.szkolenietechniczne1projekt.controllers.hall;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.HallService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HallAddController extends MainController implements Initializable {

    @FXML
    private TableView<Hall> hallTable;
    @FXML
    private TextField hallNameField;
    @FXML
    private ChoiceBox<Integer> choiceSize;
    @FXML
    private ChoiceBox<Boolean> choiceIsCleaned;

    HallService hallService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hallService = new HallService();
        setItemsToTableView(hallTable, hallService.getAllHalls());

        choiceSize.getItems().addAll(5, 10, 15, 20, 25, 30);
        choiceSize.setValue(5);

        choiceIsCleaned.getItems().addAll(true, false);
        choiceIsCleaned.setValue(true);
    }

    public void addHall() {
        Hall hall = new Hall();
        hall.setName(hallNameField.getText());
        hall.setSize(choiceSize.getValue());
        hall.setCleaned(choiceIsCleaned.getValue());

        if (isTextFieldEmpty(hallNameField)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nazwa hali nie może być pusta");
            alert.showAndWait();
            return;
        }

        hallService.addHall(hall);

        setItemsToTableView(hallTable, hallService.getAllHalls());
    }
}
