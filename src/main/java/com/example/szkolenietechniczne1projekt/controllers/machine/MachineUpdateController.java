package com.example.szkolenietechniczne1projekt.controllers.machine;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.MachineService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MachineUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Machine> machineTable;
    @FXML
    private ChoiceBox<Machine> choiceMachine;
    @FXML
    private TextField nameMachineField;
    @FXML
    private ChoiceBox<String> choiceCondition;
    @FXML
    private ChoiceBox<Integer> choiceQuantity;
    @FXML
    private ChoiceBox<Hall> choiceHall;

    MachineService machineService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        machineService = new MachineService();
        List<Machine> machines = machineService.getAllMachines();
        ObservableList<Machine> observableList = javafx.collections.FXCollections.observableArrayList(machines);
        machineTable.setItems(observableList);

        choiceCondition.getItems().addAll("Nowy", "Działa", "Zepsuty");
        choiceQuantity.getItems().addAll(1, 2, 3, 4, 5);
        choiceMachine.setItems(observableList);

        List<Hall> halls = machineService.getAllHalls();
        ObservableList<Hall> observableListHalls = javafx.collections.FXCollections.observableArrayList(halls);
        choiceHall.setItems(observableListHalls);
    }

    public void updateMachine() {
        Machine selectedMachine = choiceMachine.getValue();

        selectedMachine.setName(nameMachineField.getText());
        selectedMachine.setCondition(choiceCondition.getValue());
        selectedMachine.setQuantity(choiceQuantity.getValue());
        selectedMachine.setHallId(choiceHall.getValue().getId());

        machineService.updateMachine(selectedMachine);

        List<Machine> machines = machineService.getAllMachines();
        ObservableList<Machine> observableList = javafx.collections.FXCollections.observableArrayList(machines);
        machineTable.setItems(observableList);
    }
}
