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
        comboBoxNintendo.getItems().addAll("Personatges", "Jocs", "Consoles");

        comboBoxNintendo.getSelectionModel().selectFirst();

        cargarContenido(comboBoxNintendo.getSelectionModel().getSelectedItem());

        comboBoxNintendo.setOnAction(event -> {
            String selectedOption = comboBoxNintendo.getSelectionModel().getSelectedItem();
            cargarContenido(selectedOption);
        });
    }

    private void cargarContenido(String opcionSeleccionada) {
        vBoxContent.getChildren().clear();

        if (opcionSeleccionada.equals("Personatges")) {
            cargarPersonatges();
        } else if (opcionSeleccionada.equals("Jocs")) {
            cargarJocs();
        } else if (opcionSeleccionada.equals("Consoles")) {
            cargarConsoles();
        }
    }

    private void cargarPersonatges() {
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
        if (!Main.llistaJocs.isEmpty()) {
            Joc primerJoc = Main.llistaJocs.get(0);
            titleText.setText(primerJoc.getNom());
            imageRender.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + primerJoc.getImagen())));
            colorPane.setVisible(false);
            colorText.setText(primerJoc.getTipo());
            titleText2.setText(primerJoc.getDescripcion());
            
        }

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

    private void crearPanel(String nombre, String rutaImagen, EventHandler<ActionEvent> eventHandler) {
        Pane panel = new Pane();
        panel.setPrefHeight(80);
        panel.setMinHeight(80);
        panel.setStyle("-fx-background-color: white; -fx-padding: 10;");

        String path = "/assets/images/" + rutaImagen;
        Image image = new Image(getClass().getResourceAsStream(path));

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        imageView.setPreserveRatio(true);

        Text text = new Text(nombre);

        HBox hbox = new HBox(imageView, text);
        hbox.setSpacing(10);
        
        panel.setOnMouseClicked(event -> {
            eventHandler.handle(new ActionEvent());
        });

        panel.getChildren().add(hbox);

        vBoxContent.getChildren().add(panel);
    }
}
