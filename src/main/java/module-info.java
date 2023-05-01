module com.example.szkolenietechniczne1projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;


    opens com.example.szkolenietechniczne1projekt to javafx.fxml, org.hibernate.orm.core;
    exports com.example.szkolenietechniczne1projekt;
    exports com.example.szkolenietechniczne1projekt.models;
    opens com.example.szkolenietechniczne1projekt.models to javafx.fxml, org.hibernate.orm.core;
    exports com.example.szkolenietechniczne1projekt.services;
    opens com.example.szkolenietechniczne1projekt.services to javafx.fxml, org.hibernate.orm.core;
    exports com.example.szkolenietechniczne1projekt.controllers;
    opens com.example.szkolenietechniczne1projekt.controllers to javafx.fxml, org.hibernate.orm.core;
    exports com.example.szkolenietechniczne1projekt.controllers.sceneController;
    opens com.example.szkolenietechniczne1projekt.controllers.sceneController to javafx.fxml, org.hibernate.orm.core;
}