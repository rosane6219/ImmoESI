/*package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Visiteur {
    public void clic(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Visiteur.fxml"));//"sample.fxml"
        primaryStage.setTitle("VISITEUR");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("you clicked me");
        //lab1.setText("Bonjour");

    }

}*/
package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Visiteur {

    @FXML
    private Button listedesbiens;


    @FXML
    void contacter(ActionEvent event) throws IOException {
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VisiteurContacter.fxml"));
        primaryStage.setTitle("envoyer message ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void listedesbiens(ActionEvent event) throws IOException {
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VisiteurBienslisteview.fxml"));
        primaryStage.setTitle("Liste des biens ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void quitter(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        // primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Accueil");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void recherche(ActionEvent event) throws IOException {
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Recherche.fxml"));
        primaryStage.setTitle("Liste des biens ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}


