package com.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    public static String nom;
    public static String imatge;
    public static String color;
    public static String nomVideojoc;
    public static String any;
    public static String descripció;
    public static String tipus;
    public static String procesador;
    public static String venudes;
    public static String data;

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
        crearPanel(personatge.getNom(), personatge.getImatge(), event -> {
            System.out.println("Clicked on: " + personatge.getNom());
            nom = personatge.getNom();
            imatge = personatge.getImatge();
            color = personatge.getColor();
            nomVideojoc = personatge.getNomDelVideojoc();
            cambiarPantallaDetailed();
        });    
    }
   }

   private void cargarJocs() {
    for (Joc joc : Main.llistaJocs ) {
        crearPanel(joc.getNom(), joc.getImagen(), event -> {
            System.out.println("Clicked on: " + joc.getNom());
            nom = joc.getNom();
            any = joc.getAny() + "";
            tipus = joc.getTipo();
            descripció = joc.getDescripcion();
            imatge = joc.getImagen();
            cambiarPantallaDetailed();
        });
    }
   }

   private void cargarConsoles() {
    for (Consola consola : Main.listaConsoles ) {
        crearPanel(consola.getNom(), consola.getImagen(), event -> {
            System.out.println("Clicked on: " + consola.getNom());
            nom = consola.getNom();
            data = consola.getFechaLanzamiento() + "";
            procesador = consola.getProcesador();
            color = consola.getColor();
            venudes = consola.getUnidadesVendidas() + "";
            imatge = consola.getImagen();
            cambiarPantallaDetailed();
        });
    }
   }

   private void crearPanel(String nombre, String rutaImagen, EventHandler<ActionEvent> eventHandler) {
    Pane panel = new Pane(); // Cambia a un tipo de contenedor que prefieras, como HBox o VBox
    panel.setPrefHeight(80);
    panel.setMinHeight(80);
    panel.setStyle("-fx-background-color: white; -fx-padding: 10;");

    String path = "/assets/images/" + rutaImagen;
    Image image = new Image(getClass().getResourceAsStream(path));

    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(70); // Ajusta el ancho según sea necesario
    imageView.setFitHeight(70); // Ajusta la altura según sea necesario
    imageView.setPreserveRatio(true); // Mantiene la proporción de la imagen

    Text text = new Text(nombre);
    text.setFill(Color.BLACK);

    Button button = new Button("Descripció avançada");
    button.setOnAction(eventHandler);

    HBox hbox = new HBox(imageView, text, button); // Agrega la imagen al HBox
    hbox.setSpacing(10);
    panel.getChildren().add(hbox);

    vBoxContainer.getChildren().add(panel); // Añade el panel al VBox
    }

    private void cambiarPantallaDetailed() {
        try {
           Parent ventanaDetailed = (Parent)FXMLLoader.load(this.getClass().getResource("/assets/layoutItemDesc.fxml"));
           Scene scene = Main.scene;
           scene.setRoot(ventanaDetailed);
        } catch (IOException var2) {
           var2.printStackTrace();
        }
     }
}
