package sample;

import Noyau.*;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Biensfiltres implements Initializable {

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


    private  ArrayList <Bien> listeFiltree = new ArrayList<Bien>();

    public  void setListeFiltree(ArrayList<Bien> listeFil) {
        listeFiltree = listeFil;
    }

    public  ArrayList<Bien> getListeFiltree() {
        return listeFiltree;
    }

    @FXML
    private ListView<Text> listView2 = new ListView<Text>();
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
        listView2.getItems().addAll(array);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    private TextField supmin;

    @FXML
    private TextField wilayaid;

    @FXML
    private TextField prixmax;

    @FXML
    private TextField supmax;

    @FXML
    private TextField prixmin;

    @FXML
    private TextField typebien;

    @FXML
    private TextField typetransaction;
    @FXML
    private TextField nbminpieces;


    public void filtrer(ActionEvent event) throws IOException {


        HashMap<Critere,String> criteres = new HashMap<Critere,String>();
        if (!supmin.getText().isEmpty()) {criteres.put(Critere.SUPERFICIEMIN,supmin.getText());}
        if (!supmax.getText().isEmpty())  {criteres.put(Critere.SUPERFICIEMAX,supmax.getText());}
        if (!prixmin.getText().isEmpty()) {criteres.put(Critere.PRIXMIN,prixmin.getText());}
        if (!prixmax.getText().isEmpty()) {criteres.put(Critere.PRIXMIN,prixmax.getText());}
        if (!wilayaid.getText().isEmpty()) {criteres.put(Critere.WILAYA,wilayaid.getText());}
        if (!typebien.getText().isEmpty()) {criteres.put(Critere.TYPEBIEN,typebien.getText());}
        if (!typetransaction.getText().isEmpty()) {criteres.put(Critere.TYPETRANSACTION,typetransaction.getText());}
        if (!nbminpieces.getText().isEmpty()) {criteres.put(Critere.NBPIECESMIN,nbminpieces.getText());}
        listeFiltree = Main.admin.filtre(criteres);
        if (!listeFiltree.isEmpty()) {
            Stage primaryStage;
            primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Resultad.fxml"));
            primaryStage.setTitle("Liste des biens filtrés ");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }


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
    @FXML
    public void biens(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Administrateur.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Liste des Biens");
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
}
