package com.example.semestergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class SemesterController {

    @FXML
    private SemesterApplication semesterApplication;

    private static final String API = "http://localhost:8080/chargings";


    @FXML
    private TextField idNumber;

    @FXML
    private ListView<String> chargings;


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

       public void generateInvoice() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API + "/customers/" + idNumber.getText() ))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        
           //HttpResponse
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        idNumber.setText("");
        
  
    }

    /*
    Um von FX auf das http zuzugreifen - das ist die connection zum Springboot
    privat void doSomething() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API + "/food/" + foodInput.getText()))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        input.setText("");
    }
     */



    @FXML
    public void printInvoice() {

    }


}
