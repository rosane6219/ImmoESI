package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class Connect {


    public void retour(ActionEvent actionEvent) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
       // primaryStage.close();
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Accueil");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    @FXML
    private PasswordField m;

    public void Connexion(ActionEvent actionEvent) throws IOException {

        String mp = m.getText();
        String mdp = "admin";
        if(!mp.equals(mdp)){
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ErrMdp.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Mot de passe érroné");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        else {
            Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
            primaryStage.setTitle("Connecter en tant qu'administrateur");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }


}
