package sample;

import Noyau.Bien;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class VisiteurContacter implements Initializable {

    @FXML
    private Button listedesbiens;

    @FXML
    private Button recherche;

    @FXML
    void annuler(ActionEvent event) throws IOException {
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Visiteur.fxml"));
        primaryStage.setTitle("retour");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void contacter(ActionEvent event) throws IOException {
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VisiteurContacter.fxml"));
        primaryStage.setTitle("envoyer message");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @FXML
    private TextArea message;
    @FXML
    void envoyer(ActionEvent event) throws IOException {
       Main.admin.setMessages(message.getText());
        Stage primaryStage;
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Visiteur.fxml"));
        primaryStage.setTitle("VISITEUR");
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
    @FXML
    private ListView<Text> listView1 = new ListView<Text>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        laod();
    }

    public void laod() {


        Iterator<Bien> it2 = Main.admin.getListe().iterator();
        ObservableList<Text> array = FXCollections.observableArrayList();
        array.removeAll();


        Bien tmp = null;
        int i=1;
        while (it2.hasNext()) {

            tmp = it2.next();
            Text text=new Text();
            //text.setFill(Color.BROWN);
            text.setText("               Bien"+i+"\nAdresse : "+tmp.getAdresse_exacte()+" \nWilaya : "+tmp.getWilaya()+"\nSuperficie : "+tmp.getSuperficie()+"\nTransaction : "+tmp.getTransac()+"\nPrix : "
                    +tmp.calculerPrix(tmp.getTrans())+ "\nDescriptif : " +tmp.getDescriptif()+"");
            array.add(text);
            i++;

        }
        listView1.getItems().addAll(array);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

}
