package C.Listeners;

// Importation des fichiers
import V.FrameBase;

// Importation des librairies


public class RechercheListeners{
    
    public void actionPerformed(String buttonName, FrameBase frame) {


        // Effectuer une action en fonction du nom du bouton
        switch (buttonName) {
            case "search_globale":
                System.out.println("Recherche Globale");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
