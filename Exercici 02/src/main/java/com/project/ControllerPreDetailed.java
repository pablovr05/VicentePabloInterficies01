package com.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerPreDetailed {

    @FXML
    private Text textTitle;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button backButton;

    @FXML
    private VBox vBoxContainer;

    @FXML
    public void initialize() {
        textTitle.setText(ControllerLayoutPequeño.typeMode);
        if (ControllerLayoutPequeño.typeMode.equals("Personatges")) {
            cargarPersonatges();
        } else if (ControllerLayoutPequeño.typeMode.equals("Jocs")) {
            cargarJocs();
        } else if (ControllerLayoutPequeño.typeMode.equals("Consoles")) {
            cargarConsoles();
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

   private void cargarPersonatges() {
    for (Personatge personatge : Main.llistaPersonatges ) {
        crearPanel(personatge.getNom(), event -> {
            System.out.println("Clicked on: " + personatge.getNom());
        });    
    }
   }

   private void cargarJocs() {
    for (Joc joc : Main.llistaJocs ) {
        crearPanel(joc.getNom(), event -> {
            System.out.println("Clicked on: " + joc.getNom());
        });
    }
   }

   private void cargarConsoles() {
    for (Consola consola : Main.listaConsoles ) {
        crearPanel(consola.getNom(), event -> {
            System.out.println("Clicked on: " + consola.getNom());
        });
    }
   }

   private void crearPanel(String nombre, EventHandler<ActionEvent> eventHandler) {
        Pane panel = new Pane(); // Cambia a un tipo de contenedor que prefieras, como HBox o VBox
        panel.setPrefHeight(50); // Ajusta la altura del panel según sea necesario
        panel.setStyle("-fx-background-color: lightgrey; -fx-padding: 10;");

        Text text = new Text(nombre);
        text.setFill(Color.BLACK);

        Button button = new Button("Ver Detalles");
        button.setOnAction(eventHandler);

        HBox hbox = new HBox(text, button);
        hbox.setSpacing(10);
        panel.getChildren().add(hbox);

        vBoxContainer.getChildren().add(panel); // Añade el panel al VBox
    }
}
