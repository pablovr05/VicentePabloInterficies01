package com.project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ControllerDetailed {

    @FXML
    private Text textTitle;

    @FXML
    private ImageView imagePixel;

    @FXML
    private Text textTitle2;

    @FXML
    private Text colorText;

    @FXML
    private Pane colorPane;

    @FXML Text gameTitle;

    @FXML
    private Button backButton;

    
    @FXML
    public void initialize() {
        textTitle.setText(ControllerPreDetailed.nom);
        textTitle2.setText(ControllerPreDetailed.nom);
        imagePixel.setImage(new Image(getClass().getResourceAsStream("/assets/images/" + ControllerPreDetailed.imatge)));
        if (ControllerLayoutPequeño.typeMode.equals("Personatges")) {
            colorPane.setBackground(new Background(new BackgroundFill(Color.web(ControllerPreDetailed.color), CornerRadii.EMPTY, Insets.EMPTY)));
            colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            colorText.setText(ControllerPreDetailed.color);
            gameTitle.setText(ControllerPreDetailed.nomVideojoc);
        } else if (ControllerLayoutPequeño.typeMode.equals("Jocs")) {
            colorText.setText(ControllerPreDetailed.tipus);
            gameTitle.setText(ControllerPreDetailed.descripció);
        } else if (ControllerLayoutPequeño.typeMode.equals("Consoles")) {
            colorPane.setBackground(new Background(new BackgroundFill(Color.web(ControllerPreDetailed.color), CornerRadii.EMPTY, Insets.EMPTY)));
            colorPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            colorText.setText(ControllerPreDetailed.color);
            gameTitle.setText("Data de sortida: " + ControllerPreDetailed.data);

        }
    }

    @FXML
    private void backAction(ActionEvent event) {
        System.out.println("back");
        cambiarPantallaPreDetailed();
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
