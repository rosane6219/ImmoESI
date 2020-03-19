package Noyau;

public interface Transaction {
    final double prixMC[]={100000,30000,60000,60000,100000,
    80000,30000,5000,120000,80000,12000,25000,2500,25000,35100,1500,20000,70000,80000,900000,4100,2400,22000,54100,60000,14000,28000,30000,34000,80000,
    91000,94000,57000,36000,24000,15000,24000,28000,521000,3355,2158,51444,20154,17420,92000,10000,50000,17425,64920};
    //***********************vente******************************
    default double vente(Bien b) {
        double prix=b.getPrix();
        int w=b.getWilaya()-1;
        if (prix < 5000000) {
            if (prixMC[w] < 50000) prix = prix + prix * 0.03;
            else prix = prix + prix * 0.035;
        }
        if (5000000 <= prix && prix <= 15000000) {
            if (prixMC[w] < 50000) prix = prix + prix * 0.02;
            else prix = prix + prix * 0.025;
        }
        if (prix > 15000000) {
            if (prixMC[w] < 70000) prix = prix + prix * 0.01;
            else prix = prix + prix * 0.02;
        }
        return prix;
    }

    //**********************location****************************
    default double location(Bien b) {
        double prix = b.getPrix();
        int w = b.getWilaya()-1;
        double superficie = b.getSuperficie();
        if (superficie < 60) {
            if (prixMC[w] < 50000) {
                prix = prix + 0.03 * prix;
            } else {
                prix = prix + 0.015 * prix;
            }
        }
        if (superficie >= 60 && superficie <= 150) {
            if (prixMC[w] < 50000) {
                prix = prix + 0.02 * prix;
            } else {
                prix = prix + 0.025 * prix;
            }
        }
        if (superficie > 150) {
            if (prixMC[w] < 50000) {
                prix = prix + 0.03 * prix;
            } else {
                prix = prix + 0.035 * prix;
            }
        }
        return prix;
    }

    //**********************echange****************************
    default double echange(Bien b1, Bien b2 /*bien avec lequel on veut echanger */) {
        double prix = b2.getPrix();
        int w1 = b1.getWilaya()-1;
        int w2 = b2.getWilaya()-1;
        if (prix < 5000000) {
            if (prixMC[w2] < 50000) prix = prix + prix * 0.03;
            else prix = prix + prix * 0.035;
        }
        if (5000000 <= prix && prix <= 15000000) {
            if (prixMC[w2] < 50000) prix = prix + prix * 0.02;
            else prix = prix + prix * 0.025;
        }
        if (prix > 15000000) {
            if (prixMC[w2] < 70000) prix = prix + prix * 0.01;
            else prix = prix + prix * 0.02;
        }
        if (w1 != w2) {
            prix = prix + 0.0025 * prix;
        }
        return prix;
    }
}
