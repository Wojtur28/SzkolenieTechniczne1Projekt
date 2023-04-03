module com.example.szkolenietechniczne1projekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.szkolenietechniczne1projekt to javafx.fxml;
    exports com.example.szkolenietechniczne1projekt;
}