package C.Listeners;

// Importation des fichiers
import C.MainMathis;
import V.TestEnfFrameBase;
import jdk.incubator.vector.VectorOperators.Test;
import V.FrameBase;

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
                TestEnfFrameBase.affichertestEnfFrameBase(frame);
                System.out.println("Accueil");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
