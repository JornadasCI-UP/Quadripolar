package com.jose.gui;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LeftView extends VBox {
    
    private TitledPane connection, attendance, registration;
    private TextField presencial, online, name, ocupação;
    private int numPres, numOnline = 0;
    private Button register;

    public void setNumPres(int num){
        numPres = num;
    }

    public void setNumRemote(int num){
        numOnline = num;
    }

    public void setName(String name){
        this.name.setText(name);
    }

    public String getSQLUser(){
        
        return username.getText();
    }

    public String getSQLPassword(){
        
        return password.getText();
    }
    public LeftView(){
        buildConnection();
        buildAttendance();
        buildRegistration();
        this.getChildren().addAll(connection, attendance, registration);
    }

    PasswordField password,username;

    private void buildConnection(){

        VBox connectionBox = new VBox();
        Button connect;

        connect = new Button("Ligar");
        username = new PasswordField();
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

    private void buildRegistration(){

        VBox registrationBox = new VBox();

        
        register = new Button("Registar");
        name = new TextField();
        ocupação = new TextField();
        name.setMaxWidth(200.0f);
        name.setMinWidth(80.0f);
        ocupação.setMaxWidth(200.0f);
        ocupação.setMinWidth(80.0f);

        registrationBox.getChildren().addAll(name, ocupação, register);

        registration = new TitledPane("Registo", registrationBox);
        registration.setCollapsible(false);
    }


}
