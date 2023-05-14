package com.example.szkolenietechniczne1projekt.controllers.machine;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.MachineService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.net.URL;
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

        setItemsToTableView(machineTable, machineService.getAllMachines());

        setItemsToChoiceBox(choiceMachine, machineService.getAllMachines());
    }

    public void deleteMachine() {
        Machine selectedMachine = choiceMachine.getValue();
        machineService.deleteMachine(selectedMachine.getId());

        setItemsToTableView(machineTable, machineService.getAllMachines());
    }
}
