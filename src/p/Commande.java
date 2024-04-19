package p;

import java.time.LocalDateTime;
import java.util.HashMap;
//c'est la classe qui contient les informations et les methodes specifiques al commande
public class Commande{
    public static int numero=0;
    public int numeroCommande;

    public String nomClient;
    public String statut;
    public String adresse;
    public LocalDateTime dateCommande;
    public InfoLivraison infoLivraison;//un attribut de type infoLivraison qui donne contient les informations de la livraison specifique a une commande
    HashMap<Produit, Integer> listeProduitCommande;//une liste qui contient les produit a passer dans la commande
    int totalPrix;//prix total de la commande
    public Commande(String nomClient,String adresse,HashMap<Produit,Integer> listeProduits){//constructeur
        this.numeroCommande=Commande.numero+1;
        Commande.numero++;
        this.nomClient=nomClient;
        this.adresse=adresse;
        this.dateCommande = LocalDateTime.now();
        infoLivraison=new InfoLivraison(this.numeroCommande,this.adresse);
        this.listeProduitCommande=listeProduits;
        this.statut="en cours";
        for (Produit i : listeProduitCommande.keySet()) {
            this.totalPrix+=listeProduitCommande.get(i)*i.prix;
        }
    }
    public int getNumeroCommande(){
        return this.numeroCommande;
    }
    public void afficherCommande(){//afficher les informations de la commande
        System.out.println("numero Commande: "+this.numeroCommande);
        System.out.println("date Commande: "+this.dateCommande.getDayOfMonth()+"/"+this.dateCommande.getMonth()+"/"+this.dateCommande.getYear());
        System.out.println("adresse commande: "+this.adresse);
        System.out.println("statut commande: "+this.statut);
    }
}
