package p;

import java.util.ArrayList;
import java.util.HashMap;

public class App{
    ArrayList<Client> listeClient;//c'est la liste des clients inscrits
    HashMap<Produit,Integer> stock;//c'est le stock disponible
    public App(){//constructeur
        this.listeClient=new ArrayList<>();
        this.stock=new HashMap<>();
    }
    public void ajoutClient(Client client)
    {
        listeClient.add(client);
    }
    public void supprimerClient(String nomUtilisateur ){
        boolean test=false;
        Client client_a_supprimer=null;
        for(Client client :this.listeClient){
            if(client.getUsername().equals(nomUtilisateur)){
                test=true;
                client_a_supprimer=client ;
            }
        }if(test){
            listeClient.remove(client_a_supprimer);
        }
        else
            System.out.println("client inexistant");
    }
    public void afficherClients(){
        if(listeClient.isEmpty()){
            System.out.println("la liste des clients inscrits est vide ");
        }
        else {
            for (Client client : listeClient) {
                System.out.println("le client "+client.nom+" d'adresse "+client.adresse+" d'email "+client.email);
            }
        }
    }
    public void ajoutProduit(Produit produit,int quantite){
        if (stock.containsKey(produit)) {
            int valeurActuelle =stock.get(produit);
            stock.put(produit, valeurActuelle + quantite);
        } else {
            stock.put(produit, quantite);
        }
    }
    public void supprimerProduit(String nom) {
        boolean test=false;
        for(Produit produit :stock.keySet()){
            if(produit.nom.equals(nom)){
                test=true;
                stock.remove(produit);
            }
        }if(!test){
            System.out.println("le produit est inexistant deja ");
        }
    }
    public void modifierPrix(String nomProduit,int nouvelPrix){//une methode qui modifie le prix d'un produit utilise par l'administrateur
        for(Produit produit :stock.keySet()){
            if(produit.nom.equals(nomProduit)){
                produit.modifierPrix(nouvelPrix);
            }
        }
    }
    public int  existeProduit(String nomProduit){//c'est la methode qui va tester si le produit existe dans le stock et donc retourner sa quantité sinon elle retourne 0
        for(Produit produit :stock.keySet()){
            if(produit.nom.equals(nomProduit)){
                return stock.get(produit);
            }
        }
        return 0;
    }
    public Produit getProduit(String nomProduit){//methode qui retourne le produit en lui fournissant son nom
        for(Produit produit :stock.keySet()){
            if(produit.nom.equals(nomProduit)){
                return produit;
            }
        }
        return null;
    }
    public void afficherProduits(){//methode qui affiche le stock pour l'administrateur
        if(stock.isEmpty()){
            System.out.println("le stock est vide");
        }else{
            for(Produit produit :stock.keySet()){
                System.out.println("le produit: "+produit.nom+" prix: "+produit.prix+",quantité: "+stock.get(produit));
            }
        }
    }
    public void filtrer(String categorie,int minPrix,int maxPrix){//methode qui afficher le catalogue de stock par filtrage avec la categorie et la marge des prix
        for(Produit produit:stock.keySet()){
            if((produit.categorie.equals((categorie)))&&(produit.prix<=maxPrix)&&(produit.prix>=minPrix)){
                produit.afficherProduit();
            }
        }
    }
    public void evaluerProduit(String nom,double rate){//methode qui agit sur le feedback de produit
        for(Produit produit:stock.keySet()){
            if(produit.nom.equals(nom)){
                produit.evaluerProduit(rate);
            }
        }
    }
}
