package com.jose.gui;

import javafx.scene.control.ListView;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ScrollView extends VBox{

    private ListView<GuestCard> scroll;

    public ScrollView(){
        scroll = new ListView<>();
        this.getChildren().add(scroll);
        this.getChildren().forEach(child -> VBox.setVgrow(child, Priority.ALWAYS));

    }

    public void setElementList(GuestCard gc){
        scroll.getItems().add(gc);
    }

    public GuestCard getSelectedCard(){
        GuestCard selected = scroll.getSelectionModel().getSelectedItem();
        return selected;
    }
}
