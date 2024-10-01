package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ControllerLayoutGrande {

    @FXML
    private ComboBox<String> comboBoxNintendo;

    @FXML
    public void initialize() {
        comboBoxNintendo.getItems().addAll("Personatges", "Jocs", "Consoles");
        
        comboBoxNintendo.getSelectionModel().selectFirst(); 
    }
}
