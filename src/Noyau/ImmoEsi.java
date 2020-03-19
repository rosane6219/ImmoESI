package Noyau;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ImmoEsi {
    private static ArrayList<Bien> liste = new ArrayList<Bien>();
    private static ArrayList<Bien> archive = new ArrayList<Bien>();
    private static ArrayList<Proprietaire> proprio = new ArrayList<Proprietaire>();
    private  static ArrayList<String> messages= new ArrayList<String>();



    public void afficherTout(){
        Collections.sort(liste, Collections.reverseOrder());
        int i=1;
        for (Bien b : liste){
            System.out.println("****** Bien "+i+" ******");
            b.afficher();
            i++;
        }
    }

    public void setBien(Bien b) { liste.add(b); }
    public void setMessages(String m) { messages.add(m); }
    public void setArchive(Bien b) { archive.add(b); }
    public ArrayList<Proprietaire> getProprio() { return proprio; }

    public ArrayList<String> getMessages() { return messages; }

    public ArrayList<Bien> getArchive() { return archive; }

    public void afficherTout(ArrayList<Bien> biens){
        Collections.sort(biens, Collections.reverseOrder());
        int i=1;
        for (Bien b : biens){
            System.out.println("****** Bien "+i+" ******");
            b.afficher();
            i++;
        }
    }

    public boolean afficherTout(ArrayList<Bien> biens, TypeTransaction t){
        Collections.sort(biens, Collections.reverseOrder());
        int i=1;
        boolean exist=false;
        for (Bien b : biens){
            if(b.trans.equals(t)){
                System.out.println("****** Bien "+i+" ******");
                b.afficher();
                i++;
                exist=true;
            }
        }
        return exist;
    }

    public void visualier(Bien b) {b.afficher();}

    public Proprietaire recherche(Proprietaire p,int i){
        i=proprio.indexOf(p);
        return (proprio.get(i));
    }

    public void echangerBiens(Bien b1, Bien b2){
        b1.prop.supprimerBienDuProprietaire(b1);
        b1.prop.setBiensDuProprietaire(b2);
        b2.prop.supprimerBienDuProprietaire(b2);
        b2.prop.setBiensDuProprietaire(b1);
        Proprietaire p=b1.prop;
        b1.prop=b2.prop;
        b2.prop=p;
        liste.set(liste.indexOf(b1),b1);
        liste.set(liste.indexOf(b2),b2);
    }

    public Proprietaire recherche(Proprietaire p){
        return proprio.get(proprio.indexOf(p));
    }

    public Proprietaire recherche(String nom, String prenom){
        for(Proprietaire p : proprio){
            if(p.getNom().equals(nom) && p.getPrenom().equals(prenom)) return p;
        }
        return null;
    }

    public void ajouterBien (Bien b){
        int i=0;
        liste.add(b);
        Proprietaire pro=recherche(b.getProp(),i);
        pro.setBiensDuProprietaire(b);
        proprio.set(proprio.indexOf(pro),pro);
        System.out.println("Ajout avec succès !");
    }

    public void archiverBien (Bien b) {archive.add(b);}
    public void supprimerBien (Bien b) {
        archiverBien(b);
        Proprietaire p=recherche(b.getProp());
        proprio.set(proprio.indexOf(p),p);
        //if //recherche du bien dans la liste de bien du proprietaire
        liste.remove(b);
        System.out.println("Suppression effectuée");
    }//idem
    public void modifierBien (Bien b) {
        b.modifierBien(b);
    }//faire des set

    public void ajouterProprietaire(Proprietaire p){
        proprio.add(p);
    }

    public void setBienIndispo(Bien b) {
        b.disponible=false;
        liste.set(liste.indexOf(b),b);
    }


    public ArrayList<Bien> filtre (HashMap<Critere,String> c) {
        int i;
        ArrayList<Bien> filtered_list=new ArrayList<>(liste);
        for (Critere e : c.keySet()) {
            switch (e){
                case TYPEBIEN:
                    for(Bien b : liste)
                        if(!b.getClass().getSimpleName().equals(c.get(e))) filtered_list.remove(b);
                    break;
                case WILAYA:
                    for(Bien b : liste)
                        if(b.getWilaya()!=Integer.parseInt(c.get(e))) filtered_list.remove(b);
                    break;
                case PRIXMAX:
                    for(Bien b : liste)
                        if(b.getPrix()>Double.parseDouble(c.get(e))) filtered_list.remove(b);
                    break;
                case PRIXMIN:
                    for(Bien b : liste)
                        if(b.getPrix()<Double.parseDouble(c.get(e))) filtered_list.remove(b);
                    break;
                case NBPIECESMIN:
                    for(Bien b : liste){
                        Maison m=(Maison)b;
                        if(m.nbpiece<Integer.parseInt(c.get(e))) filtered_list.remove(b);
                    }
                    break;
                case SUPERFICIEMAX:
                    for(Bien b : liste)
                        if(b.getSuperficie()>Double.parseDouble(c.get(e))) filtered_list.remove(b);
                    break;
                case SUPERFICIEMIN:
                    for(Bien b : liste)
                        if(b.getSuperficie()<Double.parseDouble(c.get(e))) filtered_list.remove(b);
                    break;
                case TYPETRANSACTION:
                    for(Bien b : liste)
                        if(!b.getTrans().equals(c.get(e))) filtered_list.remove(b);
                    break;
            }
        }
        return filtered_list;
    }

    public ArrayList<Bien> getListe() {
        return liste;
    }
}