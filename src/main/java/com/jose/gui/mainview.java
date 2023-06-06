package com.jose.gui;

import java.sql.ResultSet;

import com.jose.database.SQLConnection;
import com.jose.threading.DBTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
        }
        
    };

    SQLConnection connection;
    DBTask task;
    ResultSet rs;


    EventHandler<ActionEvent> buttoEventHandler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {

            if(e.getSource().equals(left))
            {
                String username, password;
                username = left.getSQLUser();
                password = left.getSQLPassword();

                connection = new SQLConnection("jdbc:mysql://localhost:53061/jornadas_ci", username, password );
                task = new DBTask(connection);

                task.valueProperty().addListener(new ChangeListener<ResultSet>() {

                    @Override
                    public void changed(ObservableValue<? extends ResultSet> observableValue, ResultSet oldSet, ResultSet newSet) {
                        rs = newSet;
                        GuestCard gc;

                        try {
                            
                            while(rs.next() != false){

                                String name = rs.getString("Nome");

                                gc = new GuestCard(name, "password");
                                scroll.setElementList(gc);

                            }

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                    
                    
                });

                Thread taskThread = new Thread(task);
                taskThread.setDaemon(true);
                taskThread.run();
                
            }

            
        }
        
    };

}
