package p;
public class CarteBancaire{
    private int numero;
    private long solde;
    CarteBancaire(int numero,int solde){//constructeur

        this.numero=numero;
        this.solde=solde;
    }

    public long getSolde(){
        return this.solde;
    }
    public void setSolde(int solde){
        this.solde=solde;
    }
    public void retraitArgent(int somme){//methode qui permet de payer les commandes

        this.solde-=somme;
    }
}
