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
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//import javafx.scene.control.;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Administrateur implements Initializable {



    Proprietaire proprietaire;


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

    public void initialize(URL url, ResourceBundle resourceBundle) {laodbien();}
    private void laodbien() {

        Iterator<Bien> it2 = Main.admin.getListe().iterator();
        ObservableList<Text> array= FXCollections.observableArrayList();
        array.removeAll();
        Bien tmp =null;
        int i=1;
        while (it2.hasNext())
        {
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


    @FXML
    private ListView<Text> listView1=new ListView<Text>();
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField tel;
    @FXML
    private TextField Email;
    @FXML
    private TextField urlphoto;
    @FXML
    private TextField superficiesup;
    @FXML
    private TextField adressebien;
    @FXML
    private TextField superficie;
    @FXML
    private TextArea descriptif;
    @FXML
    private TextField nbetages;
    @FXML
    private TextField etage;
    @FXML
    private TextField type;
    @FXML
    private TextArea statut;
    @FXML
    private TextField nbfaçades;
    @FXML
    private TextField prix;
    @FXML
    private TextField nbpieces;
    @FXML
    private CheckMenuItem appartement;
    @FXML
    private CheckMenuItem vente;
    @FXML
    private CheckMenuItem echange;
    @FXML
    private CheckMenuItem wilaya1;
    @FXML
    private CheckMenuItem wilaya2;
    @FXML
    private CheckMenuItem wilaya3;
    @FXML
    private CheckMenuItem piscine;
    @FXML
    private CheckMenuItem jardin;
    @FXML
    private CheckMenuItem garage;
    @FXML
    private CheckMenuItem terrain;
    @FXML
    private CheckMenuItem maison;
    @FXML
    private CheckBox ascenseur;
    @FXML
    private CheckBox meuble;
    @FXML
    private DatePicker date;
    /*@FXML
    private CheckMenuItem location;*/






    public void suivant  (ActionEvent event) throws IOException {

        proprietaire = new Proprietaire(nom.getText(),prenom.getText(), Email.getText(),tel.getText(),adresse.getText());
        Main.admin.ajouterProprietaire(proprietaire);
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AjoutSuite.fxml"));
        primaryStage.setScene(new Scene(root));
        //primaryStage.setTitle("Informations du bien");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public TypeTransaction trans(){
        TypeTransaction t = null;
        ArrayList<String> photos=new ArrayList<String>();
        if( vente.isSelected()) { t=TypeTransaction.VENTE;}
        //if( location.isSelected() ){ t=TypeTransaction.LOCATION;}
        if (echange.isSelected() ){ t=TypeTransaction.ECHANGE;}
        return t ;
    }
    public int wilaya(){
        int w=1;
        if( wilaya1.isSelected()) { w=1;}
        if( wilaya2.isSelected() ){ w=2;}
        if (wilaya3.isSelected() ){ w=3;}
        return w;
    }



    public void finaliser(ActionEvent event) throws IOException {
        Main.photos.add(urlphoto.getText());
        if (maison.isSelected()){
            Maison m = new Maison(Integer.parseInt(nbetages.getText()),(double)Integer.parseInt(superficiesup.getText()),jardin.isSelected(),garage.isSelected(),piscine.isSelected(), proprietaire,adressebien.getText(),descriptif.getText(),date.getValue(),Main.photos, wilaya(),(double)Integer.parseInt(superficie.getText()),(double)Integer.parseInt(prix.getText()), true,trans(),meuble.isSelected(),Integer.parseInt(nbpieces.getText()));
            Main.admin.setBien(m);
        }
        if (appartement.isSelected()){
            Appartement a = new Appartement( Integer.parseInt(etage.getText()), type.getText(), ascenseur.isSelected(), proprietaire, adressebien.getText(), descriptif.getText(), date.getValue(), Main.photos, wilaya(), (double)Integer.parseInt(superficie.getText()), (double)Integer.parseInt(prix.getText()), true,trans(), meuble.isSelected(), Integer.parseInt( nbpieces.getText()));
            Main.admin.setBien(a);
        }
        if (terrain.isSelected()){
            NonHabitable h=new NonHabitable(statut.getText(), Integer.parseInt( nbfaçades.getText()), proprietaire , adressebien.getText(), descriptif.getText(), date.getValue(), Main.photos, wilaya(), (double) Integer.parseInt(superficie.getText()), (double)Integer.parseInt(prix.getText()),true, trans());
            Main.admin.setBien(h);
        }
        System.out.println("Bien ajouté!");
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Administrateur.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Administrateur");
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
    public void recherche(ActionEvent event) throws IOException {
        Stage primaryStage ;//= (Stage)((Node)event.getSource()).getScene().getWindow();
        //primaryStage.close();
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Biensfiltres.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Liste des biens archivés");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /*public void detailsbien (){
        if listView1.getSelectionModel().getSelectedItems()
    }*/










}
