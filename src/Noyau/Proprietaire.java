package Noyau;
import java.util.ArrayList;

public class Proprietaire {
    private String nom, prenom, email, tel, adresse;
    private ArrayList<Bien> biensDuProprietaire=new ArrayList<Bien>();

    public Proprietaire(String nom, String prenom, String email, String tel, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getTel() { return tel; }
    public String getAdresse() { return adresse; }
    public ArrayList<Bien> getBiensDuProprietaire() { return biensDuProprietaire; }

    public void setBiensDuProprietaire(Bien b) {
        this.biensDuProprietaire.add(b);
    }

    public void supprimerBienDuProprietaire(Bien b){ biensDuProprietaire.remove(b); };
    public void afficher(){

    }

    public void supprimer(Bien b) {

    }
    public void archiver(Bien b){}
    public void message() {

    }
}