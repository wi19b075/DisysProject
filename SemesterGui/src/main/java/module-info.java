module com.example.semestergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens com.example.semestergui to javafx.fxml;
    exports com.example.semestergui;
}