package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ControllerLayoutPequeño {

    @FXML
    private Button botonPersonatges;

    @FXML
    private Button botonJocs;

    @FXML
    private Button botonConsoles;

    @FXML
    private void buttonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        
        if (clickedButton == botonPersonatges) {
            System.out.println("Personatges");
        } else if (clickedButton == botonJocs) {
            System.out.println("Jocs");
        } else if (clickedButton == botonConsoles) {
            System.out.println("Consoles");
        }
    }
}
