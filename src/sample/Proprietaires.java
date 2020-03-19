package sample;

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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Proprietaires implements Initializable {
    @FXML
    private ListView<Text> listView1=new ListView<Text>();
    public void initialize(URL url, ResourceBundle resourceBundle) {laodbien();}
    private void laodbien() {
        Iterator<Proprietaire> it2 = Main.admin.getProprio().iterator();
        ObservableList<Text> array= FXCollections.observableArrayList();
        array.removeAll();
        Proprietaire tmp =null;
        int i=1;
        while (it2.hasNext())
        {

            tmp = it2.next();
            Text text=new Text();
            //text.setFill(Color.BROWN);
            text.setText("               Propriétaire"+i+"\n Nom : "+tmp.getNom()+"\n Prénom : "+tmp.getPrenom()+"\n Email : "+tmp.getEmail()+"\n Tel : "+tmp.getTel()+"\n Adresses : "+tmp.getAdresse());
            array.add(text);
            i++;
        }
        listView1.getItems().addAll(array);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
    public void bien (ActionEvent event ) throws IOException {
        Stage primaryStage;// = (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Administrateur.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("ADMINISTRATEUR");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
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
    public void archive(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Archive.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Liste des biens archivés");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
