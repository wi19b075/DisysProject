module com.example.semestergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semestergui to javafx.fxml;
    exports com.example.semestergui;
}