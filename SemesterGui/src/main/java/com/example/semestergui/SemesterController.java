package com.example.semestergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SemesterController {

    @FXML
    private SemesterApplication semesterApplication;

    @FXML
    private static final String API = "http://localhost:8080/chargings";


    @FXML
    private TextField idNumber;

    @FXML
    private Button quit;
    @FXML
    private Button GenerateInvoice;
    @FXML
    private Button print;


    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }

    public void generateInvoice() {
        String id = idNumber.getText();
        // id nun an Datenbank schicken
    }

    @FXML
    public void printInvoice() {

    }


}