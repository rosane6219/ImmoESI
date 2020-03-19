package Noyau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Noyau.TypeTransaction.*;

public class NonHabitable extends Bien implements Transaction {
    protected String Statutjurid;
    protected int nbfacade;

    public NonHabitable(String statutjurid, int nbfacade, Proprietaire p, String adresse_exacte,
                        String descriptif, LocalDate date_ajout, ArrayList<String> photoURL, int wilaya,
                        double superficie, double prix, boolean disponible, TypeTransaction trans) {
        Statutjurid = statutjurid;
        this.nbfacade = nbfacade;
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
    }

    public int getNbfacade() {
        return nbfacade;
    }

    public double calculerPrixVente() {
        double prix = vente(this);
        if (nbfacade > 1) return prix + prix * 0.5 * nbfacade;
        else return prix;
    }

    public void afficher() {
        int nbPhotos=1;
        System.out.println("***** Propriétaire: *****\n"+
                "Nom:"+this.getProp().getNom()+"\nPrenom:"+this.getProp().getPrenom()+"\nNumero:"+this.getProp().getTel()+
                "\nMail:"+this.getProp().getEmail()+"\nAdresse:"+this.getProp().getAdresse()+
                "\nDate d'ajout :"+this.getDate_ajout()+
                "\n-------------------\nInformation sur la propriété:");
        if(this.isDisponible()) System.out.println("Disponible");
        else System.out.println("Non disponible");
        System.out.println("Photos:");
        for(String s : this.getPhotoURL()){
            System.out.println("Chemin "+nbPhotos+": "+s);
            nbPhotos++;
        }
        System.out.println("Adresse: "+this.getAdresse_exacte()+
                "\nWilaya: "+this.getWilaya()+
                "\nSuperficie :"+this.getSuperficie()+" m2");
        System.out.println("Type de Trasaction: "+this.getTrans());
        if(this.getTrans()==TypeTransaction.VENTE || this.getTrans()== TypeTransaction.LOCATION)
            System.out.println("Prix: "+this.getPrix()+" DZD");
        System.out.println("Statut juridique: "+this.Statutjurid+"\nNombre de fascades: "+this.nbfacade);
        System.out.println("Descriptif: "+this.getDescriptif());
    }

    @Override
    public double calculerPrix(TypeTransaction t) {
        double prix=0.0;
        switch (t){
            case VENTE:
                prix=vente(this);
                if (nbfacade > 1) prix=prix+prix * 0.05 * nbfacade;
                break;
            case LOCATION:
                prix=location(this);
                break;
        }
        return prix;
    }

    @Override
    public double calculerPrix(Bien b1, Bien b2){
        double prix=echange(b1,b2);
        return prix;
    }

    @Override
    public Bien modifierBien(Bien b) {
        Scanner s = new Scanner(System.in);
        int ch = 0;
        NonHabitable m = (NonHabitable) b;
        do {
            System.out.println("Modification de:\n1-Valider la modification\n2-Description\n3-Wilaya\n4-Superficie\n5-Prix\n" +
                    "6-Disponibilité\n7-Transaction\n8-Nombres d'étage\n9-Superficie des suplémentaires" +
                    "\n10-Jardin\n11-Piscine\n12-Garage\nVotre choix:");
            ch=Integer.parseInt(s.nextLine());
            switch (ch) {
                case 1:
                    break;
                case 2:
                    System.out.println("Veuillez introduire votre description:");
                    String desc = s.nextLine();
                    m.descriptif = desc;
                    break;
                case 3:
                    System.out.println("Veuillez introduire votre wilaya:");
                    int wilaya = Integer.parseInt(s.nextLine());
                    m.wilaya = wilaya;
                    break;
                case 4:
                    System.out.println("Veuillez introduire votre  superficie:");
                    double superficie = Double.parseDouble(s.nextLine());
                    m.superficie = superficie;
                    break;
                case 5:
                    System.out.println("Veuillez introduire votre  prix:");
                    double prix = Double.parseDouble(s.nextLine());
                    m.prix = prix;
                    break;
                case 6:
                    System.out.println("Le produit est-il toujours disponible ?\n1-Oui\n2-Non");
                    int disp = Integer.parseInt(s.nextLine());
                    if (disp == 1) m.disponible = true;
                    else m.disponible = false;
                    break;
                case 7:
                    System.out.println("Veuillez introduire la nouvelle transaction:\n1-Vente\n2-Location\n3-Echange");
                    int trans = Integer.parseInt(s.nextLine());
                    if (trans == 1) m.trans = VENTE;
                    if (trans == 2) m.trans = LOCATION;
                    if (trans == 3) m.trans = ECHANGE;
                    break;
                case 8:
                    System.out.println("Veuillez introduire le nouveau status juridique");
                    String jury = s.nextLine();
                    m.Statutjurid=jury;
                    break;
                case 9:
                    System.out.println("Quel est le nombre de fascades ?");
                    int nb = Integer.parseInt(s.nextLine());
                    m.nbfacade=nb;
                    break;
                default:
                    break;
            }
        } while (ch != 1);
        return m;
    }
}

