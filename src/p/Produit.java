package p;
public class Produit{
    public String nom;
    public String categorie;
    public int prix;

    public double feedbackRate;//feedbackRate est une variable qui prend une valeur entre 0
    // et 5 qui designe le taux de satisfaction des clients sur le produit
    public Produit(String nom,String categorie,int prix){//constructeur
        this.nom=nom;
        this.categorie=categorie;
        this.prix=prix;
        this.feedbackRate=3;
    }
    public void modifierPrix(int nouvelPrix){//methode modifiant le prix de produit

        this.prix=nouvelPrix;
    }
    public void afficherProduit(){
        System.out.println("Nom produit: "+this.nom);
        System.out.println("Categorie produit: "+this.categorie);
        System.out.println("Prix produit: "+this.prix);

    }
    public void evaluerProduit(double rate){//methode qui fait la moyenne de la valeur de feedback a chaque fois qu'on evalue un produit

        this.feedbackRate=(this.feedbackRate+rate)/2;
    }
}
