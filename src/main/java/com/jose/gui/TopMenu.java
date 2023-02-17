package com.jose.gui;

import javafx.scene.control.*;

public class TopMenu extends MenuBar {
    
    Menu config;
    MenuItem servidor;

    public TopMenu(){
        config = new Menu("Configurações");
        servidor = new MenuItem("Configurar ligação");
        config.getItems().add(servidor);
        this.getMenus().add(config);
    }
}
