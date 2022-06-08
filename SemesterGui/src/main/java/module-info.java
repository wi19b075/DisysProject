module com.example.semestergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;



    opens com.example.semestergui to javafx.fxml;
    exports com.example.semestergui;
}