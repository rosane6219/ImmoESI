package Noyau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choix,saveChoix,nb,nbpieces;
        boolean err=true,menu=true,addCrit=true,addPic=true,jardin=false,garage=false,piscine=false,ascenceur=false,meubles=false;
        String mdp="admin",pass,crit,msg,num,nom,prenom,mail,adresse, descriptif,wilaya,type,status;
        LocalDate date_ajout;
        double superficie,prix,superficieSup;
        TypeTransaction trans=null;
        ArrayList<String> photos=new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        Proprietaire p=null;
        HashMap<Critere,String> criteres = new HashMap<Critere,String>();
        HashMap<String,ArrayList<String>> messagerie = new HashMap<String, ArrayList<String>>();
        ArrayList<String> messages;
        ImmoEsi admin = new ImmoEsi();

        Proprietaire prop1 = new Proprietaire("p", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop2 = new Proprietaire("o", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop3 = new Proprietaire("d", "o", "gmail", "07", ";hsdbbc;sdh");
        Proprietaire prop4 = new Proprietaire("s", "o", "gmail", "07", ";hsdbbc;sdh");

        Appartement bien1=new Appartement(1, "F4", false, prop2, " ",
                " ", LocalDate.of(2019,01,12),photos, 3,
                120, 4000000, true,  TypeTransaction.VENTE, false, 3);

        Maison bien2=new Maison(1,200,true,false,false,prop1," "," ",
                LocalDate.of(2019,01,12),photos,3,200,10000000,true,
                TypeTransaction.VENTE,false,5 );

        NonHabitable bien3 =new NonHabitable("",3,prop1,"","",
                LocalDate.of(2019,01,12),photos,1,500,20000000,true,
                TypeTransaction.VENTE);

        Appartement bien4=new Appartement(1,"F3",false,prop2," "," ",
                LocalDate.of(2019,01,12),photos,3,100,40000,true,
                TypeTransaction.LOCATION,false,2);

        Maison bien5=new Maison(1,100,false,false,true,prop3," "
                ,"",LocalDate.of(2019,01,12),photos,2,160,150000,true,
                TypeTransaction.LOCATION,false,4);

        Appartement bien6 =new Appartement(6,"Studio",false,prop2," "," ",
                LocalDate.of(2019,01,12),photos,3,50,60000,true,
                TypeTransaction.LOCATION,false,1);

        NonHabitable bien7 = new NonHabitable(" ",1,prop1," ","",LocalDate.of(2019,01,12),
                photos,1,650,18000000,true,TypeTransaction.ECHANGE);

        Maison bien8=new Maison(3,40,false,true,false,prop2,"","",
                LocalDate.of(2019,01,12),photos,2,200,14000000,true,TypeTransaction.ECHANGE
                ,false,6);

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
        /*do{
            System.out.println("Bienvenu(e) dans ImmoESI. Choisissez votre option de connexion:" +
                    "\n1.Administrateur" +
                    "\n2.Visiteur" +
                    "\n3.Quitter");
            choix=Integer.parseInt(sc.nextLine());
            saveChoix=choix;
            switch(choix){
                case 1:
                    err=false;
                    menu=true;
                    System.out.println("Veuillez entrer le mot de passe:");
                    pass=sc.nextLine();
                   902
                    }
                    while(menu){
                        System.out.println("Menu:" +
                                "\n1.Afficher la liste des biens" +
                                "\n2.Ajouter un bien" +
                                "\n3.Modifier un bien" +
                                "\n4.Supprimer un bien" +
                                "\n5.Afficher les messages" +
                                "\n6.Se déconnecter");
                        choix=Integer.parseInt(sc.nextLine());
                        switch(choix){
                            case 1:
                                System.out.println("Sélectionner une option d'affichage:" +
                                        "\n1.Afficher tout" +
                                        "\n2.Appliquer un filtre");
                                choix=Integer.parseInt(sc.nextLine());
                                switch (choix){
                                    case 1:
                                        admin.afficherTout();
                                        break;
                                    case 2:
                                        addCrit=true;
                                        do{
                                            System.out.println("Choisissez un critère:" +
                                                    "\n1.Par Superficie minimale" +
                                                    "\n2.Par Superficie maximale" +
                                                    "\n3.Par Prix minimum" +
                                                    "\n4.Par Prix maximum" +
                                                    "\n5.Par Wilaya" +
                                                    "\n6.Par Type de bien" +
                                                    "\n7.Par Type de transaction" +
                                                    "\n8.Par Nombre de pieces minimum" +
                                                    "\n9.Valider");
                                            choix=Integer.parseInt(sc.nextLine());
                                            switch(choix){
                                                case 1:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.SUPERFICIEMIN,crit);
                                                    break;
                                                case 2:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.SUPERFICIEMAX,crit);
                                                    break;
                                                case 3:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.PRIXMIN,crit);
                                                    break;
                                                case 4:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.PRIXMAX,crit);
                                                    break;
                                                case 5:
                                                    System.out.println("Entrez le numero de la wilaya:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.WILAYA,crit);
                                                    break;
                                                case 6:
                                                    System.out.println("Choisissez le type de bien:" +
                                                            "\n1.Maison" +
                                                            "\n2.Appartement" +
                                                            "\n3.Terrain");
                                                    crit=sc.nextLine();
                                                    if (crit.equals("1")) criteres.put(Critere.TYPEBIEN,"Maison");
                                                    else if (crit.equals("2")) criteres.put(Critere.TYPEBIEN,"Appartement");
                                                    else if(crit.equals("3")) criteres.put(Critere.TYPEBIEN,"NonHabitable");
                                                    break;
                                                case 7:
                                                    System.out.println("Choisissez le type de la transaction:" +
                                                            "\n1.Vente" +
                                                            "\n2.Location" +
                                                            "\n3.Echange");
                                                    crit=sc.nextLine();
                                                    if (crit.equals("1")) criteres.put(Critere.TYPEBIEN,"VENTE");
                                                    else if (crit.equals("2")) criteres.put(Critere.TYPEBIEN,"LOCATION");
                                                    else if (crit.equals("3")) criteres.put(Critere.TYPEBIEN,"ECHANGE");
                                                    break;
                                                case 8:
                                                    System.out.println("Entrez le nombre de pieces minimum:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.NBPIECESMIN,crit);
                                                    break;
                                                case 9:
                                                    addCrit=false;
                                                    admin.afficherTout(admin.filtre(criteres));
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }while(addCrit);
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Propriétaire:");
                                System.out.println("Entrez le nom:");
                                nom=sc.nextLine();
                                System.out.println("Entrez le prenom:");
                                prenom=sc.nextLine();
                                System.out.println("Entrez l'email:");
                                mail=sc.nextLine();
                                System.out.println("Entrez le numéro de téléphone:");
                                num=sc.nextLine();
                                System.out.println("Entrez l'adresse:");
                                adresse=sc.nextLine();
                                System.out.println("Le propritaire est existant ?" +
                                        "\n1.Oui" +
                                        "\n2.Non");
                                choix=Integer.parseInt(sc.nextLine());
                                if(choix==1){
                                    p=new Proprietaire(nom,prenom,mail,num,adresse);
                                } else if(choix==2){
                                    System.out.println("Ajout du propriétaire effectué.");
                                    p=new Proprietaire(nom,prenom,mail,num,adresse);
                                    admin.ajouterProprietaire(p);
                                }
                                System.out.println("Informations relatives au bien:\nEntrez l'adresse :");
                                adresse=sc.nextLine();
                                System.out.println("Entrez le numero de la wilaya :");
                                wilaya=sc.nextLine();
                                System.out.println("Entrez un descriptif:");
                                descriptif=sc.nextLine();
                                photos=new ArrayList<String>();
                                do{
                                    System.out.println("Ajouter le chemin vers la photo:");
                                    photos.add(sc.nextLine());
                                    System.out.println("Ajouter une autre photo ?" +
                                            "\n1.Oui" +
                                            "\n2.Non");
                                    choix=Integer.parseInt(sc.nextLine());
                                    if(choix==2) addPic=false;
                                }while(addPic);
                                System.out.println("Entrez la superficie:");
                                superficie=Double.parseDouble(sc.nextLine());
                                System.out.println("Entrez le nombre de pieces:");
                                nbpieces=Integer.parseInt(sc.nextLine());
                                System.out.println("Y-a-t'il des meubles ?" +
                                        "\n1.Oui" +
                                        "\n2.Non");
                                choix=Integer.parseInt(sc.nextLine());
                                if(choix==1) meubles=true;
                                if(choix==2) meubles=false;
                                System.out.println("Entrez le prix:");
                                prix=Double.parseDouble(sc.nextLine());
                                System.out.println("Ce est bien est:" +
                                        "\n1.A vendre" +
                                        "\n2.A louer" +
                                        "\n3.A echanger");
                                choix=Integer.parseInt(sc.nextLine());
                                if(choix==1) trans=TypeTransaction.VENTE;
                                if(choix==2) trans=TypeTransaction.LOCATION;
                                if(choix==3) trans=TypeTransaction.ECHANGE;
                                System.out.println("Quel est le type du bien ?" +
                                        "\n1.Maison" +
                                        "\n2.Appartement" +
                                        "\n3.Terrain");
                                choix=Integer.parseInt(sc.nextLine());
                                date_ajout=LocalDate.now();
                                if(choix==1){
                                    System.out.println("Entrez le nombre d'étages:");
                                    nb=Integer.parseInt(sc.nextLine());
                                    System.out.println("Entrez la superficie sup");
                                    superficieSup=Integer.parseInt(sc.nextLine());
                                    System.out.println("Y'a-t-il un jardin ?" +
                                            "\n1.Oui" +
                                            "\n2.Non");
                                    choix=Integer.parseInt(sc.nextLine());
                                    if(choix==1) jardin=true;
                                    if(choix==2) jardin=false;
                                    System.out.println("Y'a-t-il un garage ?" +
                                            "\n1.Oui" +
                                            "\n2.Non");
                                    choix=Integer.parseInt(sc.nextLine());
                                    if(choix==1) garage=true;
                                    if(choix==2) garage=false;
                                    System.out.println("Y'a-t-il une piscine ?" +
                                            "\n1.Oui" +
                                            "\n2.Non");
                                    choix=Integer.parseInt(sc.nextLine());
                                    if(choix==1) piscine=true;
                                    if(choix==2) piscine=false;
                                    Maison m = new Maison(nb,superficieSup,jardin,garage,piscine,p,adresse,descriptif,
                                            date_ajout,photos,Integer.parseInt(wilaya),superficie,prix,true,trans,meubles,nbpieces);
                                    admin.ajouterBien(m);
                                }else if(choix==2){
                                    System.out.println("L'appartement se situe dans quel étage ?");
                                    nb=Integer.parseInt(sc.nextLine());
                                    System.out.println("Entrez le type de l'appartement:");
                                    type=sc.nextLine();
                                    System.out.println("Y'a-t-il un ascenceur ?" +
                                            "\n1.Oui" +
                                            "\n2.Non");
                                    choix=Integer.parseInt(sc.nextLine());
                                    if(choix==1) ascenceur=true;
                                    if(choix==2) ascenceur=false;
                                    Appartement a = new Appartement(nb,type,ascenceur,p,adresse,descriptif,date_ajout,photos,Integer.parseInt(wilaya),
                                            superficie,prix,true,trans,meubles,nbpieces);
                                    admin.ajouterBien(a);
                                }else if(choix==3){
                                    System.out.println("Quel est le status juridique du bien ?");
                                    status=sc.nextLine();
                                    System.out.println("Entrez le nombre de fascades:");
                                    nb=Integer.parseInt(sc.nextLine());
                                    NonHabitable h = new NonHabitable(status,nb,p,adresse,descriptif,date_ajout,photos,
                                            Integer.parseInt(wilaya),superficie,prix,true,trans);
                                    admin.ajouterBien(h);
                                }
                                break;
                            case 3:
                                admin.afficherTout();
                                System.out.println("Entrez le numéro du bien à modifier:");
                                choix=Integer.parseInt(sc.nextLine());
                                Bien b=admin.getListe().get(choix-1);
                                b.modifierBien(b);
                                break;
                            case 4:
                                admin.afficherTout();
                                System.out.println("Entrez le numéro du bien à supprimer:");
                                choix=Integer.parseInt(sc.nextLine());
                                admin.supprimerBien(admin.getListe().get(choix-1));
                                break;
                            case 5:
                                int nbMsg=1;
                                for(String s : messagerie.keySet()){
                                    System.out.println("****** Message "+nbMsg+" ******");
                                    System.out.println("Status: "+messagerie.get(s).get(1)+"\nNumero: "+s+"\nMessage:\n"+messagerie.get(s).get(0));
                                    System.out.println("-------------------------------");
                                    messagerie.get(s).set(1,"Lu");
                                    nbMsg++;
                                }
                                break;
                            default:
                                menu=false;
                                choix=saveChoix;
                                break;
                        }
                    }
                    break;
                case 2:
                    err=false;
                    menu=true;
                    while(menu){
                        System.out.println("Menu:" +
                                "\n1.Afficher la liste des biens" +
                                "\n2.S'informer sur un bien(Nous contacter)" +
                                "\n3.Demander une transaction" +
                                "\n4.Se déconnecter");
                        choix=Integer.parseInt(sc.nextLine());
                        switch(choix){
                            case 1:
                                System.out.println("Sélectionner une option d'affichage:" +
                                        "\n1.Afficher tout" +
                                        "\n2.Appliquer un filtre");
                                choix=Integer.parseInt(sc.nextLine());
                                switch (choix){
                                    case 1:
                                        admin.afficherTout();
                                        break;
                                    case 2:
                                        addCrit=true;
                                        do{
                                            System.out.println("Choisissez un critère:" +
                                                    "\n1.Par Superficie minimale" +
                                                    "\n2.Par Superficie maximale" +
                                                    "\n3.Par Prix minimum" +
                                                    "\n4.Par Prix maximum" +
                                                    "\n5.Par Wilaya" +
                                                    "\n6.Par Type de bien" +
                                                    "\n7.Par Type de transaction" +
                                                    "\n8.Par Nombre de pieces minimum" +
                                                    "\n9.Valider");
                                            choix=Integer.parseInt(sc.nextLine());
                                            switch(choix){
                                                case 1:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.SUPERFICIEMIN,crit);
                                                    break;
                                                case 2:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.SUPERFICIEMAX,crit);
                                                    break;
                                                case 3:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.PRIXMIN,crit);
                                                    break;
                                                case 4:
                                                    System.out.println("Entrez la valeur:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.PRIXMAX,crit);
                                                    break;
                                                case 5:
                                                    System.out.println("Entrez le numero de la wilaya:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.WILAYA,crit);
                                                    break;
                                                case 6:
                                                    System.out.println("Choisissez le type de bien:" +
                                                            "\n1.Maison" +
                                                            "\n2.Appartement");
                                                    crit=sc.nextLine();
                                                    if (crit.equals("1")) criteres.put(Critere.TYPEBIEN,"MAISON");
                                                    else if (crit.equals("2")) criteres.put(Critere.TYPEBIEN,"APPARTEMENT");
                                                    break;
                                                case 7:
                                                    System.out.println("Choisissez le type de la transaction:" +
                                                            "\n1.Vente" +
                                                            "\n2.Location" +
                                                            "\n3.Echange");
                                                    crit=sc.nextLine();
                                                    if (crit.equals("1")) criteres.put(Critere.TYPEBIEN,"VENTE");
                                                    else if (crit.equals("2")) criteres.put(Critere.TYPEBIEN,"LOCATION");
                                                    else if (crit.equals("3")) criteres.put(Critere.TYPEBIEN,"ECHANGE");
                                                    break;
                                                case 8:
                                                    System.out.println("Entrez le nombre de pieces minimum:");
                                                    crit=sc.nextLine();
                                                    criteres.put(Critere.NBPIECESMIN,crit);
                                                    break;
                                                case 9:
                                                    addCrit=false;
                                                    admin.afficherTout(admin.filtre(criteres));
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }while(addCrit);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Entrez votre numéro de téléphone:");
                                num=sc.nextLine();
                                System.out.println("Entrez votre message:");
                                msg=sc.nextLine();
                                messages=new ArrayList<String>();
                                messages.add(msg);
                                messages.add("Non lu");
                                messagerie.put(num,messages);
                                System.out.println("Votre message a été envoyé avec succès, nous vous recontacterons très bientot !");
                                break;
                            case 3:
                                saveChoix=choix;
                                System.out.println("Entrez le nom du vendeur:");
                                nom=sc.nextLine();
                                System.out.println("Entrez le prénom du vendeur:");
                                prenom=sc.nextLine();
                                p=admin.recherche(nom,prenom);
                                if(p==null) System.out.println("Le propriétaire n'existe pas.");
                                else{
                                    System.out.println("Choisissez le type de transaction:" +
                                            "\n1.Achat" +
                                            "\n2.Location" +
                                            "\n3.Echange");
                                    choix=Integer.parseInt(sc.nextLine());
                                    switch (choix){
                                        case 1:
                                            System.out.println("Liste des biens du propriétaire:");
                                            if(admin.afficherTout(p.getBiensDuProprietaire(), TypeTransaction.VENTE)){
                                                System.out.println("Quel bien souhaitez-vous ? (Entrez le numéro du bien)");
                                                choix=Integer.parseInt(sc.nextLine());
                                                Bien b=p.getBiensDuProprietaire().get(choix-1);
                                                System.out.println("Prix:"+b.calculerPrix(TypeTransaction.VENTE)+"\nVous confirmez ?" +
                                                        "\n1.Oui" +
                                                        "\n2.Non");
                                                choix=Integer.parseInt(sc.nextLine());
                                                if (choix == 1) {
                                                    p.supprimerBienDuProprietaire(b);
                                                    admin.setBienIndispo(b);
                                                }
                                                System.out.println("Opération réussie !");
                                            }else {
                                                System.out.println("Aucun bien n'est disponible pour ce type de transactions");
                                            }
                                        choix=saveChoix;
                                        break;
                                        case 2:
                                            System.out.println("Liste des biens du propriétaire:");
                                            if(admin.afficherTout(p.getBiensDuProprietaire(), TypeTransaction.LOCATION)){
                                                System.out.println("Quel bien souhaitez-vous ? (Entrez le numéro du bien)");
                                                choix=Integer.parseInt(sc.nextLine());
                                                Bien b=p.getBiensDuProprietaire().get(choix-1);
                                                System.out.println("Prix:"+b.calculerPrix(TypeTransaction.LOCATION)+"\nVous confirmez ?" +
                                                        "\n1.Oui" +
                                                        "\n2.Non");
                                                choix=Integer.parseInt(sc.nextLine());
                                                if (choix == 1) {
                                                    p.supprimerBienDuProprietaire(b);
                                                    admin.setBienIndispo(b);
                                                }
                                                System.out.println("Opération réussie !");
                                            }else {
                                                System.out.println("Aucun bien n'est disponible pour ce type de transactions");
                                            }
                                            choix=saveChoix;
                                            break;
                                        case 3:
                                            System.out.println("Liste des biens du propriétaire:");
                                            if(admin.afficherTout(p.getBiensDuProprietaire(), TypeTransaction.ECHANGE)){
                                                System.out.println("Quel bien souhaitez-vous ? (Entrez le numéro du bien)");
                                                choix=Integer.parseInt(sc.nextLine());
                                                Bien b2=p.getBiensDuProprietaire().get(choix-1);
                                                System.out.println("Entrez votre nom:");
                                                nom=sc.nextLine();
                                                System.out.println("Entrez votre prénom:");
                                                prenom=sc.nextLine();
                                                Proprietaire p2=admin.recherche(nom,prenom);
                                                System.out.println("Liste de vos biens:");
                                                admin.afficherTout(p2.getBiensDuProprietaire());
                                                System.out.println("Avec quel bien souhaitez-vous l'échanger? (Entrez le numéro du bien)");
                                                choix=Integer.parseInt(sc.nextLine());
                                                Bien b1=p.getBiensDuProprietaire().get(choix-1);
                                                System.out.println("Prix:"+b2.calculerPrix(b1,b2)+"\nVous confirmez ?" +
                                                        "\n1.Oui" +
                                                        "\n2.Non");
                                                choix=Integer.parseInt(sc.nextLine());
                                                if (choix == 1) {
                                                    admin.echangerBiens(b1, b2);
                                                    admin.setBienIndispo(b1);
                                                    admin.setBienIndispo(b2);
                                                }
                                                System.out.println("Opération réussie !");
                                            }else {
                                                System.out.println("Aucun bien n'est disponible pour ce type de transactions");
                                            }
                                            choix=saveChoix;
                                            break;
                                        default:
                                            choix=saveChoix;
                                            break;
                                    }
                                }
                                break;
                            default:
                                menu=false;
                                choix=saveChoix;
                                break;
                        }
                    }
                    break;
                case 3:
                    err=true;
                    break;
                default:
                    System.out.println("Veuillez entrer 1 ou 2 pour effectuer votre choix.");
                    break;
            }
        }while (!err);*/
    }
}
