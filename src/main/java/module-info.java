module k.zadanie6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens k.zadanie6 to javafx.fxml;
    exports k.zadanie6;
}