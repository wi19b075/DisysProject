package com.example.semestergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SemesterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SemesterApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("SemesterProject");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Good bye!");
    }

    public static void main(String[] args) {
        launch();
    }
}