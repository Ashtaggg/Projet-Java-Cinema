package C;

import V.testAffichageAlexis;
import M.Utilisateur.Connexion;

public class MainAlexis {
    public static void main(String[] ags)
    {
        testAffichageAlexis test = new testAffichageAlexis();
        test.affichage();
    }

    public void boutonConnexion(String mail, String password){
        Connexion connexion = new Connexion();
        connexion.connexionToUser(mail, password);
    }

    public void boutonAppuye(){
        System.out.println("Dans le main");
    }
}
