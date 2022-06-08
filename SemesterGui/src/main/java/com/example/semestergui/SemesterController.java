package com.example.semestergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SemesterController {

    @FXML
    private SemesterApplication semesterApplication;

    @FXML
    private Label welcomeText;

    @FXML
    private Button quit;
    @FXML
    private Button GenerateInvoice;
    @FXML
    private Button print;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }

    public void generateInvoice() {

    }

    @FXML
    public void printInvoice() {

    }


}