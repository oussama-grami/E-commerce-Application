package p;
//c'est une autre classe derive de classe utilisateur
public class Administrateur extends Utilisateur{
    public Administrateur(String username,String password,String AdminName,String AdminEmail){//constructeur
        super(username,password,AdminName,AdminEmail);
    }

}
