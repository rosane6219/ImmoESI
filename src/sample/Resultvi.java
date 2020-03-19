package sample;

import Noyau.Bien;
import Noyau.Proprietaire;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Resultvi implements Initializable {
    @FXML
    private Button listedesbiens;

    private ArrayList<Bien> listeFiltree = new ArrayList<Bien>();
    Proprietaire proprietaire;
    @FXML
    private ListView<Text> listView4 = new ListView<Text>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        laod();
    }
    public void laod() {

        Iterator<Bien> it2 = listeFiltree.iterator();
        ObservableList<Text> array = FXCollections.observableArrayList();
        array.removeAll();

        Bien tmp = null;
        while (it2.hasNext()) {

            tmp = it2.next();
            Text text = new Text();
            text.setText(tmp.getTrans() + " " + tmp.getDate_ajout() + "\n" + tmp.getWilaya() + "\n" + tmp.getAdresse_exacte() + "\nPrix : "
                    +  tmp.getPrix() + "/" + tmp.getDescriptif() );
            array.add(text);

        }
        listView4.getItems().addAll(array);
        listView4.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
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
}
