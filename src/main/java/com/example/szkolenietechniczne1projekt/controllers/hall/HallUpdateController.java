package com.example.szkolenietechniczne1projekt.controllers.hall;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.HallService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
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
        List<Hall> halls = hallService.getAllHalls();
        ObservableList<Hall> observableList = javafx.collections.FXCollections.observableArrayList(halls);
        hallTable.setItems(observableList);

        choiceHall.setItems(observableList);
        choiceIsCleaned.getItems().addAll(true, false);
    }

    public void updateHall() {
        Hall selectedHall = choiceHall.getValue();

        selectedHall.setName(hallNameField.getText());
        selectedHall.setSize(Integer.parseInt(sizeField.getText()));
        selectedHall.setCleaned(choiceIsCleaned.getValue());

        hallService.updateHall(selectedHall);

        List<Hall> halls = hallService.getAllHalls();
        ObservableList<Hall> observableList = javafx.collections.FXCollections.observableArrayList(halls);
        hallTable.setItems(observableList);
    }

}
