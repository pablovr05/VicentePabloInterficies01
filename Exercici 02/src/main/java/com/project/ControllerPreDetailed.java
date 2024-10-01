package com.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.List;

public class ControllerPreDetailed {

    @FXML
    private Text textTitle;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        textTitle.setText(ControllerLayoutPequeño.typeMode);
        if (ControllerLayoutPequeño.typeMode.equals("Personatges")) {
        } else if (ControllerLayoutPequeño.typeMode.equals("Jocs")) {
        } else if (ControllerLayoutPequeño.typeMode.equals("Consoles")) {
        }
    }

    @FXML
    private void backAction(ActionEvent event) {
        System.out.println("back");
        cambiarPantallaPequeña();
    }

    private void cambiarPantallaPequeña() {
      try {
         Parent ventanaPequeña = (Parent)FXMLLoader.load(this.getClass().getResource("/assets/layoutPequeño.fxml"));
         Scene scene = Main.scene;
         scene.setRoot(ventanaPequeña);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }
}
