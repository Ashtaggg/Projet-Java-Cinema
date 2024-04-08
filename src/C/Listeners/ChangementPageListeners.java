package C.Listeners;

// Importation des fichiers
import V.TestEnfFrameBase;
import V.FrameBase;
import V.PageConnexion;
import V.PageInscription;

// Importation des librairies



public class ChangementPageListeners{

    public void ChanhementPage(String boutonName, FrameBase frame) {


        // Effectuer une action en fonction du nom du bouton
        switch (boutonName) {
            case "compte":
                frame.PageActuelle = "compte";
                System.out.println("Compte et" + frame.PageActuelle);
                break;
            case "panier":
                System.out.println("Panier");
                break;
            case "accueil_films":
                frame.PageActuelle = "accueil_films";
                TestEnfFrameBase.affichertestEnfFrameBase(frame);
                System.out.println("Accueil");
                break;
            case "connexion":
                frame.PageActuelle = "connexion";
                PageConnexion.affichagePageConnexion(frame);
                System.out.println("Connexion");
                break;
            case "inscription":
                frame.PageActuelle = "inscription";
                PageInscription.affichagePageInscription(frame);
                System.out.println("Inscription");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
