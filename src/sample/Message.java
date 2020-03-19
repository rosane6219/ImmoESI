package sample;


import Noyau.*;
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
import java.time.LocalDate;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Message implements Initializable {
    @FXML
    private ListView<Text> listView1=new ListView<Text>();
    public void initialize(URL url, ResourceBundle resourceBundle) {laodbien();}
    private void laodbien() {
        Iterator<String> it2 = Main.admin.getMessages().iterator();
        ObservableList<Text> array= FXCollections.observableArrayList();
        array.removeAll();
        String tmp =null;
        int i=1;
        while (it2.hasNext())
        {

            tmp = it2.next();
            Text text=new Text();
            //text.setFill(Color.BROWN);
            text.setText("               Messages"+i+"\n "+tmp+" .....");
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
    public void propio(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Proprietaires.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Liste des propriétaires");
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
