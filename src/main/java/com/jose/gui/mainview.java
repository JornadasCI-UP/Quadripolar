package com.jose.gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class mainview extends BorderPane {
    
    ScrollView scroll;
    SearchPane search;
    LeftView left;
    TopMenu menu;

    public mainview(){
        search = new SearchPane();
        scroll = new ScrollView();
        left = new LeftView();
        menu = new TopMenu();
        scroll.addEventFilter(MouseEvent.MOUSE_CLICKED, scrollEventHandler);
        //this.getChildren().add(menu);
        this.setLeft(left);
        this.setTop(search);
        this.setCenter(scroll);
    }

    EventHandler<MouseEvent> scrollEventHandler = new EventHandler<>() {

        @Override
        public void handle(MouseEvent arg0) {
            
            GuestCard gc = scroll.getSelectedCard();
            System.out.println(gc.nome.toString());
        }
        
    };


}
