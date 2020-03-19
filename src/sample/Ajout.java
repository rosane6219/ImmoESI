package sample;
import Noyau.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Ajout {
    public void boitedereception(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        // primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Message.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Boite de réception");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void AjouterBien  (ActionEvent event) throws IOException {
        Stage primaryStage;// = (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Ajout.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Ajout d'un bien");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void deconnexion (ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        // primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Accueil");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
