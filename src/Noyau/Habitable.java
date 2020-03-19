package Noyau;

import java.util.Scanner;

import static Noyau.TypeTransaction.*;

public class Habitable extends Bien implements Transaction {
    protected int nbpiece;
    protected boolean meulbé;


    public double calculerPrix(TypeTransaction t) {
        switch (t){
            case VENTE:
                return vente(this);
            case LOCATION:
                return location(this);
            default:
                return 0.0;
        }
    }

    public double calculerPrix(Bien b1, Bien b2){
        return echange(b1,b2);
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
                "\nSuperficie :"+this.getSuperficie()+" m2"+
                "\nNombre de pièces: "+this.nbpiece);
        if(this.meulbé) System.out.println("Meubles: Oui");
        else System.out.println("Meubles: Non");
        System.out.println("Type de Trasaction: "+this.getTrans());
        if(this.getTrans()==TypeTransaction.VENTE || this.getTrans()== TypeTransaction.LOCATION)
                System.out.println("Prix: "+this.getPrix()+" DZD");
        System.out.println("Descriptif: "+this.getDescriptif());
    }
    public Bien modifierBien (Bien b) {
        Scanner s = new Scanner(System.in);
        int ch=0;
        Maison m= (Maison)b;
        do {
            System.out.println("Modification de:\n1-Valider la modification\n2-Description\n3-Wilaya\n4-Superficie\n5-Prix\n" +
                    "6-Disponibilité\n7-Transaction\n8-Nombres de pièces\n9.Meubles");
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
                    System.out.println("Veuillez introduire le nouveau nombre de pieces :");
                    int pieces = Integer.parseInt(s.nextLine());
                    m.nbpiece=pieces;
                    break;
                case 9:
                    System.out.println("Y'a-til des meubles ?\n1.Oui\n2.Non");
                    int meubles = Integer.parseInt(s.nextLine());
                    if (meubles==1) m.meulbé=true;
                    else if (meubles==2) m.meulbé=false;
                    break;
                default:
                    break;
            }
        }while (ch!=1);
        return m;
    }
}
