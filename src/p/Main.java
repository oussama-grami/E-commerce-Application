package p;
import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
public class Main{
    public static void main(String[]args){
        HashMap<String ,String > utilisateurs=new HashMap<>();
        HashMap<String ,String > administrateur=new HashMap<>();
        //voici les noms d'utilisateur et les mots de passe correctes a utiliser et vous pouvez ajouter d'autres
        utilisateurs.put("oussama_grami","31032003");
        utilisateurs.put("oussama_grami03","31032003");
        administrateur.put("oussama","1234567890");
        Scanner sc = new Scanner(System.in);
        System.out.println("donner le nom d'utilisateur");
        String username=sc.nextLine();
        System.out.println("donner le password");
        String password=sc.nextLine();

        App app=new App();//elle cree une classe qui va gerer presque toutes les autres classes
        if((utilisateurs.containsKey(username))&&(utilisateurs.get(username).equals(password))){//on va tester si l'utilisateur un un administrateur ou un client
            Produit produit1=new Produit("pc","informatique",1500);//j'ai mis 3 articles au debut et vous pouvez ajouter au cours de traitement
            Produit produit2=new Produit("smartphone","informatique",900);
            Produit produit3=new Produit("table","fourniture",550);
            app.ajoutProduit(produit1,5);//ajout produit dans le stock
            app.ajoutProduit(produit2,12);//ajout produit dans le stock
            app.ajoutProduit(produit3,7);//ajout produit dans le stock
            System.out.println("bonjour,vous etes un client ");//une fois le client est accédé il va donner des informations de son profil
            System.out.println("donner votre nom");//necessaire à l'instanciation des objets
            String clientName=sc.nextLine();
            System.out.println("donner votre email");
            String clientEmail=sc.nextLine();
            System.out.println("donner votre adresse");
            String clientAdresse=sc.nextLine();
            System.out.println("donner le numero de votre carte");
            int clientNumeroCarte=sc.nextInt();
            System.out.println("donner votre solde");
            int clientsolde=sc.nextInt();
            Client client =new Client(username,password,clientName,clientEmail,clientAdresse,clientNumeroCarte,clientsolde);//creation de l'instance du client
            client.connexion();//la connexion de client
            //celle-ci est l'ensemble des operations que le client peut faire
            System.out.println("voici le menu ,veuillez choisir votre demande");
            System.out.println("-1-Ajouter un produit dans le panier");
            System.out.println("-2-supprimer un produit de panier");
            System.out.println("-3-afficher mon panier");
            System.out.println("-4-modifier profil ");
            System.out.println("-5-voir catalogue par categorie et appliquer un filtre de prix");
            System.out.println("-6-voir solde");
            System.out.println("-7-commander ");
            System.out.println("-8-voir historique achat");
            System.out.println("-9-suivre la livraison");
            System.out.println("-10-donner feedback");
            System.out.println("-11-voir feedback sur un produit");
            System.out.println("-12-choisir la methode de livraison");
            System.out.println("-13-deconnexion");
            int  choix=0;
            do{
                System.out.println("donner votre demande");
                choix=sc.nextInt();
                switch(choix){//selon le choix effectué le client va être redirigé vers sa demande
                    case 1:
                        System.out.println("donner le nom de produit");
                        sc.nextLine();
                        String nomProduit=sc.nextLine();
                        System.out.println("donner la quantite desire");
                        int quantite=sc.nextInt();
                        if(app.existeProduit(nomProduit)<quantite){
                            System.out.println("la quantite valable  de produit recherche est : "+app.existeProduit(nomProduit));
                        }else{
                            client.panier.ajoutProduit(app.getProduit(nomProduit),quantite);
                        }

                        break;
                    case 2:
                        System.out.println("donner le nom de produit a supprimer");
                        sc.nextLine();
                        String nom=sc.nextLine();
                        client.panier.supprimerProduit(nom);
                        break;
                    case 3:
                        client.panier.afficherPanier();
                        break;
                    case 4:
                        System.out.println("si vous voulez changer le nom tapez 1,si vous voulez changer l'adresse tapez 2,si vous voulez changer l'email tapez 3");
                        int operation=sc.nextInt();
                        switch(operation){
                            case 1:
                                System.out.println("donner le nouveau nom");
                                sc.nextLine();
                                String nouveauNom=sc.nextLine();
                                client.modifierNom(nouveauNom);
                                break;
                            case 2:
                                System.out.println("donner la nouvelle adresse");
                                sc.nextLine();
                                String nouvelleAdresse=sc.nextLine();
                                client.modifierAdresse(nouvelleAdresse);
                                break;
                            case 3:
                                System.out.println("donner le nouveau email");
                                sc.nextLine();
                                String nouveauEmail=sc.nextLine();
                                client.modifierEmail(nouveauEmail);
                                break;
                        }
                         break;
                    case 5:
                        System.out.println("donner la categorie");
                        sc.nextLine();
                        String categorie=sc.nextLine();
                        System.out.println("donner le prix minimal");
                        int minPrix=sc.nextInt();
                        System.out.println("donner le prix maximal");
                        int maxPrix=sc.nextInt();
                        app.filtrer(categorie,minPrix,maxPrix);
                        break;
                    case 6:
                        System.out.println("votre solde est "+client.carte.getSolde());
                        break;
                    case 7:
                        Panier panierCommande=client.panier;
                        for(Produit produit:panierCommande.listeProduits.keySet()){
                            app.stock.put(produit,app.stock.get(produit)-panierCommande.listeProduits.get(produit));
                        }
                        client.commander();
                        break;
                    case 8:
                        for(Commande commande :client.historiqueCommande){
                            commande.afficherCommande();
                        }
                        break;
                    case 9:
                        System.out.println("donner le numero de commande a suivre");
                        int numeroCommande=sc.nextInt();
                        boolean test=false;
                        for(Commande commande :client.historiqueCommande){
                            if(commande.numeroCommande==numeroCommande){
                                commande.infoLivraison.afficherLivraison();
                                test=true;
                            }
                        }if(!test)
                            System.out.println("livraison inexistante");
                        break;
                    case 10:
                        System.out.println("donner le nom de produit a evaluer");
                        sc.nextLine();
                        nom=sc.nextLine();
                        System.out.println("donner votre evaluation sur 5");
                        double rate=sc.nextDouble();
                        app.evaluerProduit(nom,rate);
                        break;
                    case 11:
                        System.out.println("donner le nom de produit");
                        sc.nextLine();
                        nom=sc.nextLine();
                        System.out.println("la moyenne des feedback de ce produit est "+app.getProduit(nom).feedbackRate);
                        break;
                    case 12:
                        System.out.println("donner le numero de commande");
                        numeroCommande=sc.nextInt();
                        System.out.println("donner la methode desiree");
                        sc.nextLine();
                        String methodeLivraison=sc.nextLine();
                        test=false;
                        for(Commande commande :client.historiqueCommande){
                            if(commande.numeroCommande==numeroCommande){
                                commande.infoLivraison.setMethodeLivraison(methodeLivraison);
                                test=true;
                            }
                        }if(!test)
                        System.out.println("livraison inexistante");

                        break;
                    case 13:
                        client.deconnexion();
                        System.out.println("vous avez déconnecté");
                        break;
                    default:
                        System.out.println("vous devez verifier le choix");
                }

            }while(choix!=13);


        }else if((administrateur.containsKey(username))&&(administrateur.get(username).equals(password))){//c'est le cas ou l'utilisateur est un administrateur
            System.out.println(" bonjour ,vous etes un administrateur ");
            System.out.println("donner votre nom");
            String AdminName=sc.nextLine();
            System.out.println("donner votre email");
            String AdminEmail=sc.nextLine();
            Administrateur Admin=new Administrateur(username,password,AdminName,AdminEmail);
            Admin.connexion();
            System.out.println("voici le menu ,veuillez choisir votre demande");
            System.out.println("-1-Ajouter client");
            System.out.println("-2-Bannir un client ");
            System.out.println("-3-affciher la liste des clients ");
            System.out.println("-4-modifier  le prix d'un produit");
            System.out.println("-5-ajouter un produit au stock");
            System.out.println("-6-supprimer un produit du stock");
            System.out.println("-7-afficher les produits du stock");
            System.out.println("-8-deconnexion");
            int choix=0;
            do{
                System.out.println("donner votre demande");
                choix=sc.nextInt();
                switch(choix){
                    case 1:
                        System.out.println("donner le nom Utilisateur");
                        sc.nextLine();
                        String nomUtilisateur=sc.nextLine();
                        System.out.println("donner le mot de passe");
                        String motDePasse=sc.nextLine();
                        System.out.println("donner le nom ");
                        String nom=sc.nextLine();
                        System.out.println("donner l'email");
                        String email=sc.nextLine();
                        System.out.println("donner l'adresse'");
                        String adresse=sc.nextLine();
                        System.out.println("donner le numero de la carte bancairer");
                        int numeroCarte=sc.nextInt();
                        System.out.println("donner son solde");
                        int  solde=sc.nextInt();
                        Client client1=new Client(nomUtilisateur,motDePasse,nomUtilisateur,email,adresse,numeroCarte,solde);
                        app.ajoutClient(client1);
                        break;
                    case 2:
                        System.out.println("donner le nom Utilisateur a bannir");
                        sc.nextLine();
                        nomUtilisateur=sc.nextLine();
                        app.supprimerClient(nomUtilisateur);
                        break;
                    case 3:
                        app.afficherClients();
                        break;

                    case 4:
                        System.out.println("donner le nom du produit a modifier");
                        sc.nextLine();
                        String nomProduit=sc.nextLine();
                        System.out.println("donner le nouveau prix");
                        int nouvelPrix=sc.nextInt();
                        app.modifierPrix(nomProduit,nouvelPrix);
                        break;
                    case 5:
                        System.out.println("donner le nom");
                        sc.nextLine();
                        nomProduit=sc.nextLine();
                        System.out.println("donner la categorie");
                        String categorie=sc.nextLine();
                        System.out.println("donner le prix");
                        int prix=sc.nextInt();
                        System.out.println("donner la quantite");
                        int quantite=sc.nextInt();
                        app.ajoutProduit(new Produit(nomProduit,categorie,prix),quantite);
                        break;
                    case 6:
                        System.out.println("donner le nom de produit a supprimer");
                        sc.nextLine();
                        nomProduit=sc.nextLine();
                        app.supprimerProduit(nomProduit);
                        break;
                    case 7:
                        app.afficherProduits();
                        break;
                    case 8:
                        Admin.deconnexion();
                        System.out.println("vous avez deconnecté");
                        break;
                    default:
                        System.out.println("vous devez entrer un numero entre 1 et 6");

                }


            }while(choix!=8);
        }

        else {
            if ((utilisateurs.containsKey(username)) || (administrateur.containsKey(username))) {//dans le cas ou le nom d'utilisateur est correcte mais le mot de passe est faux
                System.out.println("vous devez verifier le mot de passe");
            } else {
                System.out.println("vous devez verifier le nom d'utilisateur et le mot de passe");//dans le cas ou les deux sont faux
            }
        }
    }
}