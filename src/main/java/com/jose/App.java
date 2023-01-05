package com.jose;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.jose.gui.mainview;

/**
 * JavaFX App
 */
public class App extends Application{

    public void start(Stage primaryStage){
        mainview view = new mainview();
        Scene primaryScene = new Scene(view);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Quadripolar");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(800);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}