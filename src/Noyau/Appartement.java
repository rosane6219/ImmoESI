package Noyau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Noyau.TypeTransaction.*;

public class Appartement extends Habitable {
    private int etage;
    private String type;
    private boolean ascenceur;


    public Appartement(int etage, String type, boolean ascenceur, Proprietaire p, String adresse_exacte,
                       String descriptif, LocalDate date_ajout, ArrayList<String> photoURL, int wilaya,
                       double superficie, double prix, boolean disponible, TypeTransaction trans, boolean meubles, int nbpieces) {
        this.etage = etage;
        this.type = type;
        this.ascenceur = ascenceur;
        this.adresse_exacte = adresse_exacte;
        this.descriptif = descriptif;
        this.date_ajout = date_ajout;
        this.photoURL = photoURL;
        this.wilaya = wilaya;
        this.superficie = superficie;
        this.prix = prix;
        this.disponible = disponible;
        this.trans = trans;
        this.prop = p;
        this.nbpiece=nbpieces;
        this.meulbé=meubles;
    }

    public int getEtage() { return etage; }
    public boolean Ascenceur() { return ascenceur; }

    public double calculerPrix(TypeTransaction t){
        double prix=super.calculerPrix(t);
        switch (t) {
            case VENTE:
                if (0<=etage && etage<=2) prix+=50000;
                break;
            case LOCATION:
                if (0<=etage && etage<=2) prix+=5000;
                else if (etage>6 && !ascenceur) prix-=500*superficie;
                break;
        }
        return prix;
    }

    public double calculerPrix(Bien b1, Bien b2){
        double prix=super.calculerPrix(b1,b2);
        if (0<=etage && etage<=2) prix+=50000;
        return prix;
    }

    public void afficher(){
        super.afficher();
        System.out.println("Etage: "+this.etage+"\nType :"+this.type);
        if(ascenceur) System.out.println("Ascenceur: Oui");
        else System.out.println("Ascenceur: Non");
        System.out.println("---------------------");
    }

    public Bien modifierBien (Bien b) {
        Scanner s = new Scanner(System.in);
        int ch=0;
        Appartement m= (Appartement) b;
        do {
            System.out.println("Modification de:\n1-Valider la modification\n2-Description\n3-Wilaya\n4-Superficie\n5-Prix\n" +
                    "6-Disponibilité\n7-Transaction\n8-Numéro d'étages\n9-Type\n10-Ascenseur\nVotre choix:");
            ch=Integer.parseInt(s.nextLine());
            switch (ch){
                case 1:
                    break;
                case 2:
                    System.out.println("Veuillez introduire votre description:");
                    String desc = s.nextLine();
                    m.descriptif=desc;
                    break;
                case 3:
                    System.out.println("Veuillez introduire votre wilaya:");
                    int wilaya = Integer.parseInt(s.nextLine());
                    m.wilaya=wilaya;
                    break;
                case 4:
                    System.out.println("Veuillez introduire votre  superficie:");
                    double superficie=Double.parseDouble(s.nextLine());
                    m.superficie=superficie;
                    break;
                case 5:
                    System.out.println("Veuillez introduire votre  prix:");
                    double prix =Double.parseDouble(s.nextLine());
                    m.prix=prix;
                    break;
                case 6:
                    System.out.println("Le produit est-il toujours disponible ?\n1-Oui\n2-Non");
                    int disp = Integer.parseInt(s.nextLine());
                    if (disp==1) m.disponible=true;
                    else m.disponible=false;
                    break;
                case 7:
                    System.out.println("Veuillez introduire la nouvelle transaction:\n1-Vente\n2-Location\n3-Echange");
                    int trans = Integer.parseInt(s.nextLine());
                    if (trans==1)  m.trans= VENTE;
                    if (trans==2) m.trans= LOCATION;
                    if (trans==3) m.trans= ECHANGE;
                    break;
                case 8:
                    System.out.println("Veuillez introduire Le nouvel étage ou est situé votre appartement:");
                    int etages = Integer.parseInt(s.nextLine());
                    m.etage=etages;
                    break;
                case 9:
                    System.out.println("Quel est le type de l'appartement ?");
                    String type = s.nextLine();
                    break;
                case 10:
                    System.out.println("Y'a-til un ascenceur ?\n1.Oui\n2.Non");
                    int ascenceur = Integer.parseInt(s.nextLine());
                    if (ascenceur==1) m.ascenceur=true;
                    else if (ascenceur==2) m.ascenceur=false;
                    break;
                default:
                    break;
            }
        }while (ch!=1);
        return m;
    }
}