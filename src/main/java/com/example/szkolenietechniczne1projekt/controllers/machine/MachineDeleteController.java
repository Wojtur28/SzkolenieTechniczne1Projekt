package com.example.szkolenietechniczne1projekt.controllers.machine;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.MachineService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MachineDeleteController extends MainController implements Initializable {

    @FXML
    private TableView<Machine> machineTable;
    @FXML
    private ChoiceBox<Machine> choiceMachine;

    MachineService machineService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        machineService = new MachineService();

        List<Machine> machines = machineService.getAllMachines();
        ObservableList<Machine> observableList = javafx.collections.FXCollections.observableArrayList(machines);
        machineTable.setItems(observableList);

        choiceMachine.setItems(observableList);
    }

    public void deleteMachine() {
        Machine selectedMachine = choiceMachine.getValue();
        machineService.deleteMachine(selectedMachine.getId());

        List<Machine> updatedMachines = machineService.getAllMachines();
        ObservableList<Machine> updatedObservableList = javafx.collections.FXCollections.observableArrayList(updatedMachines);
        choiceMachine.setItems(updatedObservableList);
    }
}
