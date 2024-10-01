package com.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ControllerLayoutGrande {

    @FXML
    private ComboBox<String> comboBoxNintendo;

    @FXML
    private VBox vBoxContent;

    @FXML
    private ScrollPane scrollPaneContent;

    @FXML
    private Text titleText;

    @FXML
    private Text titleText2;

    @FXML
    private Pane colorPane;

    @FXML
    private Text colorText;

    @FXML
    private ImageView imageRender;

    public void initialize() {
        // Agregar opciones al ComboBox
        comboBoxNintendo.getItems().addAll("Personatges", "Jocs", "Consoles");

        // Seleccionar el primer valor por defecto
        comboBoxNintendo.getSelectionModel().selectFirst();

        // Cargar el contenido por defecto
        cargarContenido(comboBoxNintendo.getSelectionModel().getSelectedItem());

        // Agregar un listener al ComboBox para cambiar el contenido cuando se seleccione una opción
        comboBoxNintendo.setOnAction(event -> {
            String selectedOption = comboBoxNintendo.getSelectionModel().getSelectedItem();
            cargarContenido(selectedOption);
        });
    }

    private void cargarContenido(String opcionSeleccionada) {
        // Limpiar el contenido anterior
        vBoxContent.getChildren().clear();

        // Dependiendo de la opción seleccionada, cargar Personatges, Jocs o Consoles
        if (opcionSeleccionada.equals("Personatges")) {
            cargarPersonatges();
        } else if (opcionSeleccionada.equals("Jocs")) {
            cargarJocs();
        } else if (opcionSeleccionada.equals("Consoles")) {
            cargarConsoles();
        }
    }

    private void cargarPersonatges() {
        // Cargar el primer personaje por defecto
        if (!Main.llistaPersonatges.isEmpty()) {
            Personatge primerPersonatge = Main.llistaPersonatges.get(0);
            colorPane.setVisible(true);
            titleText.setText(primerPersonatge.getNom());
            imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + primerPersonatge.getImatge())));
            colorPane.setBackground(new Background(new BackgroundFill(Color.web(primerPersonatge.getColor()), CornerRadii.EMPTY, Insets.EMPTY)));
            colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            colorText.setText(primerPersonatge.getColor());
            titleText2.setText(primerPersonatge.getNomDelVideojoc());
        }

        // Cargar todos los personajes en el VBox
        for (Personatge personatge : Main.llistaPersonatges) {
            crearPanel(personatge.getNom(), personatge.getImatge(), event -> {
                colorPane.setVisible(true);
                titleText.setText(personatge.getNom());
                imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + personatge.getImatge())));
                colorPane.setBackground(new Background(new BackgroundFill(Color.web(personatge.getColor()), CornerRadii.EMPTY, Insets.EMPTY)));
                colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
                colorText.setText(personatge.getColor());
                titleText2.setText(personatge.getNomDelVideojoc());
            });
        }
    }

    private void cargarJocs() {
        // Cargar el primer juego por defecto
        if (!Main.llistaJocs.isEmpty()) {
            Joc primerJoc = Main.llistaJocs.get(0);
            titleText.setText(primerJoc.getNom());
            imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + primerJoc.getImagen())));
            colorPane.setVisible(false);
            colorText.setText(primerJoc.getTipo());
            titleText2.setText(primerJoc.getDescripcion());
            
        }

        // Cargar todos los juegos en el VBox
        for (Joc joc : Main.llistaJocs) {
            crearPanel(joc.getNom(), joc.getImagen(), event -> {
                titleText.setText(joc.getNom());
                imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + joc.getImagen())));
                colorPane.setVisible(false);
                colorText.setText(joc.getTipo());
                titleText2.setText(joc.getDescripcion());
            });
        }
    }

    private void cargarConsoles() {
        // Cargar la primera consola por defecto
        if (!Main.listaConsoles.isEmpty()) {
            Consola primeraConsola = Main.listaConsoles.get(0);
            colorPane.setVisible(true);
            titleText.setText(primeraConsola.getNom());
            imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + primeraConsola.getImagen())));
            colorPane.setBackground(new Background(new BackgroundFill(Color.web(primeraConsola.getColor()), CornerRadii.EMPTY, Insets.EMPTY)));
            colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            colorText.setText(primeraConsola.getColor());
            titleText2.setText("Data de salida: " + primeraConsola.getFechaLanzamiento());
            
        }

        // Cargar todas las consolas en el VBox
        for (Consola consola : Main.listaConsoles) {
            crearPanel(consola.getNom(), consola.getImagen(), event -> {
                colorPane.setVisible(true);
                titleText.setText(consola.getNom());
                imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + consola.getImagen())));
                colorPane.setBackground(new Background(new BackgroundFill(Color.web(consola.getColor()), CornerRadii.EMPTY, Insets.EMPTY)));
                colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
                colorText.setText(consola.getColor());
                titleText2.setText("Data de salida: " + consola.getFechaLanzamiento());
            });
        }
    }

    // Método para crear un panel dinámico con una imagen, nombre y botón
    private void crearPanel(String nombre, String rutaImagen, EventHandler<ActionEvent> eventHandler) {
        Pane panel = new Pane();
        panel.setPrefHeight(80);
        panel.setMinHeight(80);
        panel.setStyle("-fx-background-color: white; -fx-padding: 10;");

        // Cargar la imagen
        String path = "/assets/images/" + rutaImagen;
        Image image = new Image(getClass().getResourceAsStream(path));

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        imageView.setPreserveRatio(true);

        // Texto con el nombre
        Text text = new Text(nombre);

        // Crear un HBox para contener la imagen y el texto
        HBox hbox = new HBox(imageView, text);
        hbox.setSpacing(10);
        
        // Hacer que el panel sea clicable
        panel.setOnMouseClicked(event -> {
            eventHandler.handle(new ActionEvent());
        });

        // Agregar el HBox al panel
        panel.getChildren().add(hbox);

        // Agregar el panel al VBox
        vBoxContent.getChildren().add(panel);
    }
}
