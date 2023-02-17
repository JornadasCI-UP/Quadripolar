package com.jose.gui;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class GuestCard extends FlowPane {
    
    public Text nome, modalidade;
    Button registar;

    public GuestCard(String nome, String modalidade){
        this.nome = new Text(nome);
        this.modalidade = new Text(modalidade); 
        registar = new Button("Check In");
        registar.setOnAction(confirmar);
        this.setHgap(10);
        this.getChildren().addAll(this.nome, this.modalidade, registar);
    }

    EventHandler<ActionEvent> confirmar = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {
            
            Alert al = new Alert(AlertType.CONFIRMATION);
            al.setContentText("Quer fazer o check in de " + nome.getText() + "?");
            Optional<ButtonType> res = al.showAndWait();
            
            if(res.get() == ButtonType.OK){
                //enviar confirmação para o servidor
            }
            else{
                //cancelar
            }
        }
        
    };
}
