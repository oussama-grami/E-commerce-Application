package p;

import java.util.ArrayList;
//c'est la classe qui heritent de la classe utilisateur
public class Client  extends Utilisateur {
    public String adresse;
    public  CarteBancaire carte ;//c'est la carte bancaire de client avec laquelle on va faire les transactions
    public Panier panier;//c'est le panier de client
    public ArrayList<Commande> historiqueCommande;//c'est l'ensemble des commandes passees par le client
    public Client(String username, String password,String name,String email,String adresse,int numeroCarte,int soldeCarte){//constructeur
        super(username,password,name,email);
        this.adresse=adresse;
        this.panier=new Panier();
        this.historiqueCommande=new ArrayList<Commande>();
        this.carte=new CarteBancaire(numeroCarte,soldeCarte);
    }

    public void modifierAdresse(String adresse){
        this.adresse=adresse;
    }
    public void modifierNom(String nom){
        this.nom=nom;
    }
    public void modifierEmail(String email){
        this.email=email;
    }
    public void commander() {//c'est la methode principale de cette classe.elle va vider le panier et faire la transaction via la carte et creer une commande qui va etre passe dans historique des commandes
        if (this.panier.listeProduits.isEmpty()) {
            System.out.println("le panier est vide");
        } else {
            Commande commande = new Commande(this.nom, this.adresse, this.panier.listeProduits);
            if (this.carte.getSolde() >= commande.totalPrix) {
                this.carte.retraitArgent(commande.totalPrix);
                System.out.println("commande passée avec succés");
                historiqueCommande.add(commande);
                this.panier.listeProduits.clear();
            } else {
                System.out.println("le solde est insuffisant");
            }
        }
    }
}

