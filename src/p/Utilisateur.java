package p;

import java.util.ArrayList;
import java.util.Scanner;
 public class Utilisateur {
     //ce sont les informations de profil de l'utilisateur
    private String NomUtilisateur;
    private String motDePasse;
    protected String email;
    protected String nom;
    protected boolean connecte;

    public Utilisateur(String username, String password,String name,String email) {//constructeur
        this.NomUtilisateur = username;
        this.motDePasse = password;
        this.email=email;
        this.nom=name;
    }

    public String getUsername() {//methode qui retourne le nom d'utilisateur
        return NomUtilisateur;
    }

    public String getPassword() {//methode qui retourne le mot de passe
        return motDePasse;
    }

    public void connexion(){//methode de connexion
        connecte=true;
    }
    public void deconnexion(){//methode de deconnexion
        connecte=false;
    }
}


