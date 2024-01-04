package com.example.javafxbasics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button buttonOK = new Button("OK");
        Scene scene = new Scene(buttonOK,200,250);
        primaryStage.setTitle("Welcome to JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("Java");
        stage.setScene(new Scene(new Button("Exit"),200,250));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}