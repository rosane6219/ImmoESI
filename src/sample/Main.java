package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Noyau.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Accueil");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    static ImmoEsi admin = new ImmoEsi();
    static  ArrayList<String> photos=new ArrayList<String>();
    public static void main(String[] args) {


        admin.setMessages("messages test");
        admin.setMessages("messages tes2");
        Proprietaire prop1 = new Proprietaire("p", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop2 = new Proprietaire("o", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop3 = new Proprietaire("d", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop4 = new Proprietaire("s", "o", "gmail", "07", ";hsdbbc;sdh");
        Appartement bien1=new Appartement(1, "F4", false, prop2, " ", " ", LocalDate.of(2019,01,12),photos, 3, 120, 4000000, true,  TypeTransaction.VENTE, false, 3);
        Maison bien2=new Maison(1,200,true,false,false,prop1," "," ", LocalDate.of(2019,01,12),photos,3,200,10000000,true, TypeTransaction.VENTE,false,5 );
        NonHabitable bien3 =new NonHabitable("",3,prop1,"","", LocalDate.of(2019,01,12),photos,1,500,20000000,true, TypeTransaction.VENTE);
        Appartement bien4=new Appartement(1,"F3",false,prop2," "," ", LocalDate.of(2019,01,12),photos,3,100,40000,true, TypeTransaction.LOCATION,false,2);
        Maison bien5=new Maison(1,100,false,false,true,prop3," ","",LocalDate.of(2019,01,12),photos,2,160,150000,true, TypeTransaction.LOCATION,false,4);
        Appartement bien6 =new Appartement(6,"Studio",false,prop2," "," ", LocalDate.of(2019,01,12),photos,3,50,60000,true, TypeTransaction.LOCATION,false,1);
        NonHabitable bien7 = new NonHabitable(" ",1,prop1," ","",LocalDate.of(2019,01,12), photos,1,650,18000000,true,TypeTransaction.ECHANGE);
        Maison bien8=new Maison(3,40,false,true,false,prop2,"","", LocalDate.of(2019,01,12),photos,2,200,14000000,true,TypeTransaction.ECHANGE,false,6);

        admin.ajouterProprietaire(prop1);
        admin.ajouterProprietaire(prop2);
        admin.ajouterProprietaire(prop3);
        admin.ajouterProprietaire(prop4);
        admin.ajouterBien(bien1);
        admin.ajouterBien(bien2);
        admin.ajouterBien(bien3);
        admin.ajouterBien(bien4);
        admin.ajouterBien(bien5);
        admin.ajouterBien(bien6);
        admin.ajouterBien(bien7);
        admin.ajouterBien(bien8);
        System.out.println("bien1:"+bien1.calculerPrix(TypeTransaction.VENTE));
        System.out.println("bien2:"+bien2.calculerPrix(TypeTransaction.VENTE));
        System.out.println("bien3:"+bien3.calculerPrix(TypeTransaction.VENTE));
        System.out.println("bien4:"+bien4.calculerPrix(TypeTransaction.LOCATION));
        System.out.println("bien5:"+bien5.calculerPrix(TypeTransaction.LOCATION));
        System.out.println("bien6:"+bien6.calculerPrix(TypeTransaction.LOCATION));
        System.out.println("bien7:"+bien7.calculerPrix(bien4,bien7));
        System.out.println("bien8:"+bien8.calculerPrix(bien8,bien8));

        launch(args);
    }
}
