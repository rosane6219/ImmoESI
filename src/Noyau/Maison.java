package Noyau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Noyau.TypeTransaction.*;

public class Maison extends Habitable {
    private int nbetage;
    private double superficieSup;
    private boolean jardin,garage,piscine;

    public Maison(int nbetage, double superficieSup, boolean jardin, boolean garage, boolean piscine, Proprietaire p,
                  String adresse_exacte, String descriptif, LocalDate date_ajout, ArrayList<String> photoURL, int wilaya,
                  double superficie, double prix, boolean disponible, TypeTransaction trans, boolean meubles, int nbpieces) {
        this.nbetage = nbetage;
        this.superficieSup = superficieSup;
        this.jardin = jardin;
        this.garage = garage;
        this.piscine = piscine;
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

    public double calculerPrix(TypeTransaction t){
        double prix=super.calculerPrix(t);
        switch (t) {
            case VENTE:
                if (jardin || garage || piscine) prix+=prix * (0.5 / 100);
                break;
            case LOCATION:
                if(piscine) prix=prix+50000;
            break;
        }
        return prix;
    }

    public double calculerPrix(Bien b1, Bien b2){
        double prix = super.calculerPrix(b1,b2);
        if (jardin || garage || piscine) prix=prix + prix * (0.5 / 100);
        return prix;
    }

    public Bien modifierBien (Bien b) {
        Scanner s = new Scanner(System.in);
        int ch=0;
        Maison m= (Maison)b;
        do {
            System.out.println("Modification de:\n1-Valider la modification\n2-Description\n3-Wilaya\n4-Superficie\n5-Prix\n" +
                    "6-Disponibilité\n7-Transaction\n8-Nombres d'étage\n9-Superficie des suplémentaires" +
                    "\n10-Jardin\n11-Piscine\n12-Garage");
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
                    System.out.println("Veuillez introduire le nouveau nombre d'etages :");
                    int etages = Integer.parseInt(s.nextLine());
                    m.nbetage=etages;
                    break;
                case 9:
                    System.out.println("Y'a-til un jardin ?\n1.Oui\n2.Non");
                    int jardin = Integer.parseInt(s.nextLine());
                    if (jardin==1) m.jardin=true;
                    else if (jardin==2) m.jardin=false;
                    break;
                case 10:
                    System.out.println("Y'a-til une piscine ?\n1.Oui\n2.Non");
                    int piscine = Integer.parseInt(s.nextLine());
                    if (piscine==1) m.jardin=true;
                    else if (piscine==2) m.jardin=false;
                    break;
                case 11:
                    System.out.println("Y'a-til un garage ?\n1.Oui\n2.Non");
                    int garage = Integer.parseInt(s.nextLine());
                    if (garage==1) m.jardin=true;
                    else if (garage==2) m.jardin=false;
                    break;
                default:
                    break;
            }
        }while (ch!=1);
        return m;
    }

    public boolean getPiscine() { return piscine; }
    public boolean getGarage() { return garage; }
    public boolean getJardin() { return jardin; }
    public int getNbetage() { return nbetage; }
    public void afficher(){
        super.afficher();
        System.out.println("Nombre d'étages: "+this.nbetage);
        if (jardin || garage|| piscine) System.out.println("Superficie des supplementaires: "+this.superficieSup+" m2");
        if(jardin) System.out.println("Jardin: Oui");
        else System.out.println("Jardin: Non");
        if(garage) System.out.println("Garage: Oui");
        else System.out.println("Garage: Non");
        if(piscine) System.out.println("Piscine: Oui");
        else System.out.println("Piscine: Non");
        System.out.println("-------------------");
    }



}