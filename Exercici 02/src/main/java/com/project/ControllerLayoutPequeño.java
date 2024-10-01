package com.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ControllerLayoutPequeño {

    public static String typeMode = "null";

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
            typeMode = "Personatges";
            cambiarPantallaPreDetailed();
        } else if (clickedButton == botonJocs) {
            typeMode = "Jocs";
            cambiarPantallaPreDetailed();
        } else if (clickedButton == botonConsoles) {
            typeMode = "Consoles";
            cambiarPantallaPreDetailed();
        }
    }

    private void cambiarPantallaPreDetailed() {
      try {
         Parent ventanaPreDetailed = (Parent)FXMLLoader.load(this.getClass().getResource("/assets/layoutPreDetailed.fxml"));
         Scene scene = Main.scene;
         scene.setRoot(ventanaPreDetailed);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }
}
