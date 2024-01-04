package com.example.javafxbasics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class EventHandle extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox pane = new HBox(15);
        pane.setAlignment(Pos.CENTER);
        Button btOk = new Button("OK");
        Button btCancel = new Button("Cancel");
        Button btQuit = new Button("Quit");
        OkHandlerClass handler1 = new OkHandlerClass();
        btOk.setOnAction(handler1);
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);
        QuitHandlerClass handler3 = new QuitHandlerClass();
        btQuit.setOnAction(handler3);
        pane.getChildren().addAll(btOk,btCancel,btQuit);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowEventHandle");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class OkHandlerClass implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Ok button clicked.");
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Cancel button is clicked.");
    }
}

class QuitHandlerClass implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Quit button is clicked.");
    }
}
