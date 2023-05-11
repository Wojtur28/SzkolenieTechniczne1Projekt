package com.example.szkolenietechniczne1projekt.controllers.machine;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Machine;
import com.example.szkolenietechniczne1projekt.services.MachineService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MachineUpdateController extends MainController implements Initializable {

    @FXML
    private TableView<Machine> machineTable;

    MachineService machineService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        machineService = new MachineService();
        List<Machine> machines = machineService.getAllMachines();
        ObservableList<Machine> observableList = javafx.collections.FXCollections.observableArrayList(machines);
        machineTable.setItems(observableList);

    }
}
