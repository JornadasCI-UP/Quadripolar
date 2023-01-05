package com.jose.gui;

import javafx.scene.layout.BorderPane;

public class mainview extends BorderPane {
    
    ScrollView scroll;
    SearchPane search;

    public mainview(){
        search = new SearchPane();
        scroll = new ScrollView();
        this.setTop(search);
        this.setCenter(scroll);
    }

}
