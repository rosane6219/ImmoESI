package Noyau;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class  Bien implements Transaction,Comparable<Bien> {  // abstract
    protected String adresse_exacte ,descriptif;
    protected LocalDate date_ajout;
    protected ArrayList<String> photoURL;
    protected int wilaya ;
    protected double superficie, prix;
    protected boolean disponible ;
    protected TypeTransaction trans;
    protected Proprietaire prop;

    public int getWilaya() { return wilaya;  }
    public String getAdresse_exacte() { return adresse_exacte; }
    public LocalDate getDate_ajout() { return date_ajout; }
    public String getDescriptif() { return descriptif; }
    public ArrayList<String> getPhotoURL() { return photoURL; }
    public boolean isDisponible() { return disponible; }
    public TypeTransaction getTrans() { return trans; }

    public String  getTransac() { return trans.name();}
    public Proprietaire getProp() { return prop;}
    public double getSuperficie() { return superficie; }
    public double getPrix() { return prix; }
    public  abstract void afficher();
    public abstract double calculerPrix(TypeTransaction v);
    public abstract double calculerPrix(Bien b1, Bien b2);
    public abstract Bien modifierBien(Bien b);
    public int compareTo(Bien b){ return date_ajout.compareTo(b.date_ajout);}

}