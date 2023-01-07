package com.jose.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LeftView extends VBox {
    
    private TitledPane connection, attendance;
    private TextField presencial, online;
    private int numPres, numOnline = 0;

    public LeftView(){
        buildConnection();
        buildAttendance();
        this.getChildren().addAll(connection, attendance);
    }

    private void buildConnection(){

        VBox connectionBox = new VBox();
        TextArea username;
        PasswordField password;
        Button connect;

        connect = new Button("Ligar");
        username = new TextArea();
        password = new PasswordField();
        connectionBox.getChildren().addAll(username, password, connect);
        connection = new TitledPane("Ligação",connectionBox);
        connection.setCollapsible(false);

    }

    private void buildAttendance(){
        
        VBox attendanceBox = new VBox();

        presencial = new TextField(String.format("Numero de participantes presenciais %d", numPres)); 
        online = new TextField(String.format("Numero de participantes online %d", numOnline));
        attendanceBox.getChildren().addAll(presencial, online);

        attendance = new TitledPane("Participantes", attendanceBox);
        attendance.setCollapsible(false);

    }

    public void setNumPres(int num){
        numPres = num;
    }

    public void setNumRemote(int num){
        numOnline = num;
    }
}
