package p;

import java.util.HashMap;

public class Panier{
    HashMap<Produit , Integer> listeProduits ;//liste des produits dans le panier
    public Panier(){//constructeur

        listeProduits=new HashMap <Produit ,Integer >();
    }
    public void ajoutProduit(Produit produit,int quantite){
        if (listeProduits.containsKey(produit)) {
            int valeurActuelle = listeProduits.get(produit);
            listeProduits.put(produit, valeurActuelle + quantite);
        } else {
            listeProduits.put(produit, quantite);
        }
    }
    public void supprimerProduit(String nomProduit){
        boolean test=false;
        Produit produit_a_supprimer=null;
        for(Produit produit :this.listeProduits.keySet()){
            if(produit.nom.equals(nomProduit)){
                test=true;
                produit_a_supprimer=produit ;
            }
        }if(test){
            listeProduits.remove(produit_a_supprimer);
        }
        else
            System.out.println("produit inexistant");
    }
    public void afficherPanier(){//afficher le contenue du panier
        if(listeProduits.isEmpty()){
            System.out.println("le panier est vide");
        }
        for (Produit i : listeProduits.keySet()) {
            System.out.println("produit "+i.nom+" : "+listeProduits.get(i));
        }

    }

}