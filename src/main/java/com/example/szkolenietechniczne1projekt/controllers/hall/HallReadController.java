package com.example.szkolenietechniczne1projekt.controllers.hall;

import com.example.szkolenietechniczne1projekt.controllers.mainController.MainController;
import com.example.szkolenietechniczne1projekt.models.Hall;
import com.example.szkolenietechniczne1projekt.services.HallService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class HallReadController extends MainController implements Initializable {

    @FXML
    private TableView<Hall> hallTable;

    HallService hallService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hallService = new HallService();
        setItemsToTableView(hallTable, hallService.getAllHalls());
    }
}
