package com.example.szkolenietechniczne1projekt.controllers.machine;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.MachineService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MachineAddController extends MainController implements Initializable {

    @FXML
    private TableView<Machine> machineTable;
    @FXML
    private TextField nameMachineField;
    @FXML
    private ChoiceBox<String> choiceCondition;
    @FXML
    private ChoiceBox<Integer> choiceQuantity;
    @FXML
    private ChoiceBox<Hall> choiceHall;

    MachineService machineService = new MachineService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        machineService = new MachineService();
        setItemsToTableView(machineTable, machineService.getAllMachines());

        choiceCondition.getItems().addAll("Nowy", "Działa", "Zepsuty");
        choiceCondition.setValue("Nowy");
        choiceQuantity.getItems().addAll(1, 2, 3, 4, 5);
        choiceQuantity.setValue(1);

        setItemsToChoiceBox(choiceHall, machineService.getAllHalls());
    }

    public void addMachine() {
        Machine machine = new Machine();
        machine.setName(nameMachineField.getText());
        machine.setCondition(choiceCondition.getValue());
        machine.setQuantity(choiceQuantity.getValue());
        machine.setHallId(choiceHall.getValue().getId());

        if(isTextFieldEmpty(nameMachineField)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie podano nazwy maszyny");
            alert.showAndWait();
            return;
        }

        machineService.addMachine(machine);

        setItemsToTableView(machineTable, machineService.getAllMachines());
    }
}
