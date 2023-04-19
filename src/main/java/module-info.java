module com.example.szkolenietechniczne1projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;


    opens com.example.szkolenietechniczne1projekt to javafx.fxml, org.hibernate.orm.core;
    exports com.example.szkolenietechniczne1projekt;
}