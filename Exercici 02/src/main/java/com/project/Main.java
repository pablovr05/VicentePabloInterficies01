package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class Main extends Application {

    final int WINDOW_WIDTH = 900;
    final int WINDOW_HEIGHT = 600;
    public static Scene scene;

    public static List<Personatge> llistaPersonatges = JsonReaderPersonatges.crearPersonajesDesdeJSON("C:/Users/pablo/Desktop/VicentePabloInterficies01/Exercici 02/src/main/resources/assets/data/personatges.json");
    public static List<Joc> llistaJocs = JsonReaderJocs.crearJocsDesdeJSON("C:/Users/pablo/Desktop/VicentePabloInterficies01/Exercici 02/src/main/resources/assets/data/jocs.json");
    public static List<Consola> listaConsoles = JsonReaderConsoles.crearConsolesDesdeJSON("C:/Users/pablo/Desktop/VicentePabloInterficies01/Exercici 02/src/main/resources/assets/data/consoles.json");

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/assets/layoutGrande.fxml"));
        scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("NintendoDB");
        stage.getIcons().add(new Image("/assets/images/nintendo.png"));
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setMinWidth(350);
        stage.setMinHeight(600);
        stage.setMaxWidth(900);
        stage.setMaxHeight(600);

        stage.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            if (newWidth.doubleValue() <= 351) {
                cambiarPantallaPequeña();
            } else {
                cambiarPantallaGrande();
            }
        });

        stage.show();

        if (!System.getProperty("os.name").contains("Mac")) {
            Image icon = new Image("file:icons/icon.png");
            stage.getIcons().add(icon);
        }

    }

    private void cambiarPantallaPequeña() {
        try {
            Parent ventanaPequeña = FXMLLoader.load(getClass().getResource("/assets/layoutPequeño.fxml"));
            scene.setRoot(ventanaPequeña);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cambiarPantallaGrande() {
        try {
            Parent ventanaGrande = FXMLLoader.load(getClass().getResource("/assets/layoutGrande.fxml"));
            scene.setRoot(ventanaGrande);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
