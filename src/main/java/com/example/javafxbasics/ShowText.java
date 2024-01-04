package com.example.javafxbasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowText extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(5,5,5,5));
        javafx.scene.text.Text text1 = new javafx.scene.text.Text(20,20,"Programming is fun.");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC,15));
        pane.getChildren().add(text1);

        Text text2 = new Text(60,60,"Programming is fun.\nDisplay text.");
        pane.getChildren().add(text2);

        Text text3 = new Text(10,100,"Programming is fun.\nDisplay text.");
        text3.setFill(Color.RED);
        text3.setUnderline(true);
        text3.setStrikethrough(true);
        pane.getChildren().add(text3);
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowText");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
