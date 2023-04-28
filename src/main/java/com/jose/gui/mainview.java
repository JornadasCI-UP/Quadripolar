package com.jose.gui;

import com.jose.database.SQLConnection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class mainview extends BorderPane {
    
    ScrollView scroll;
    SearchPane search;
    LeftView left;
    TopMenu menu;

    SQLConnection connection;

    public mainview(){
        search = new SearchPane();
        scroll = new ScrollView();
        left = new LeftView();
        menu = new TopMenu();
        scroll.addEventFilter(MouseEvent.MOUSE_CLICKED, scrollEventHandler);
        left.addEventFilter(ActionEvent.ACTION, buttoEventHandler);
        //this.getChildren().add(menu);
        this.setLeft(left);
        this.setTop(search);
        this.setCenter(scroll);
    }

    EventHandler<MouseEvent> scrollEventHandler = new EventHandler<>() {

        @Override
        public void handle(MouseEvent arg0) {
            
            GuestCard gc = scroll.getSelectedCard();
            left.setName(gc.nome.getText());
            System.out.println(gc.nome.toString());
        }
        
    };


    EventHandler<ActionEvent> buttoEventHandler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {

            if(e.getSource().equals(left))
            {
                String username, password;
                username = left.getSQLUser();
                password = left.getSQLPassword();

                connection = new SQLConnection("127.0.0.1:53061", username, password );
            }

            
        }
        
    };
    


}
