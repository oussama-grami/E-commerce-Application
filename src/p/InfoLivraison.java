package p;
public class InfoLivraison{
    public int numeroCommande;
    public String adresse;
    public int prix;
    public double dureeLivraison;

    public String methodeLivraison;//l'attribut methode livraison est un attribut qui peut prendre 3 valeurs
    // :standard(livraison normale) ou rapide(livraison express) ou urgent(la commande arrive le meme jour)


    public InfoLivraison(int numeroCommande,String adresse){//constructeur
        this.numeroCommande=numeroCommande;
        this.adresse=adresse;
        switch(adresse){//selon l'adresse de client le prix et la duree de livraison changent
            case "tunis":
                this.prix=7;
                this.dureeLivraison=3;
                break;
            case "ariana":
                this.prix=5;
                this.dureeLivraison=5;
                break;
            case "bizerte":
                this.prix=10;
                dureeLivraison=6;
                break;
            case "nabeul":
                this.prix=12;
                this.dureeLivraison=8;
                break;
            default:
                this.dureeLivraison=32;
                this.prix=30;
        }
        this.methodeLivraison="standard";

    }
    public void setMethodeLivraison(String methodeLivraison){//methode qui met la methode de livraison utilisé par le client
        this.methodeLivraison=methodeLivraison;
        if(methodeLivraison.equals("rapide")){
            this.prix=this.prix*2;
            this.dureeLivraison=this.dureeLivraison-2;
        }if(methodeLivraison.equals("urgent")){
            this.prix=this.prix*3;
            this.dureeLivraison=2;

        }
    }
    public void modifierPrix(int prix){//methode qui modifie le prix de la livraison

        this.prix=prix;
    }
    public void afficherLivraison(){//methode affichant les informations de la livraison
        System.out.println("duree livraison : "+this.dureeLivraison);
        System.out.println("prix livraison : "+this.prix);
        System.out.println("methode livraison : "+this.methodeLivraison);
    }



}
