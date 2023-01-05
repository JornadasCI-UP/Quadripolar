package com.jose.gui;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;


public class SearchPane extends FlowPane {

    TextField searchField;
    CheckBox present, missing;
    ChoiceBox<String> choice;

    public SearchPane(){
        searchField = new TextField("search here");
        present = new CheckBox("mostrar presentes");
        missing = new CheckBox("mostrar não presentes");
        this.getChildren().add(searchField);
        this.getChildren().add(missing);
        this.getChildren().add(present);
        this.setHgap(15.0);
        this.setMinHeight(50.0);
        this.setAlignment(Pos.CENTER);
        createChoiceBox();
        
    }

    private void createChoiceBox(){
        choice = new ChoiceBox<>();
        choice.getItems().add("ascendente");
        choice.getItems().add("descendente");
        this.getChildren().add(choice);
    }
    

    
}
