package com.jose.gui;

import javafx.scene.layout.BorderPane;

public class mainview extends BorderPane {
    
    ScrollView scroll;
    SearchPane search;
    LeftView left;

    public mainview(){
        search = new SearchPane();
        scroll = new ScrollView();
        left = new LeftView();
        this.setLeft(left);
        this.setTop(search);
        this.setCenter(scroll);
    }

}
