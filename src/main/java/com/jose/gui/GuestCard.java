package com.jose.gui;

import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class GuestCard extends FlowPane {
    
    public Text nome, modalidade;

    public GuestCard(String nome, String modalidade){
        this.nome = new Text(nome);
        this.modalidade = new Text(modalidade); 

        this.setHgap(10);
        this.getChildren().addAll(this.nome, this.modalidade);
    }


}
