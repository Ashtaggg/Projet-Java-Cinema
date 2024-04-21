package C.Listeners.Panier;

//Imports Fichiers
import V.FrameBase;
//import V.Panier.Panier;
import C.Listeners.ChangementPageListeners;

//Imports Librairies

public class PanierListeners {
    public static void ValiderPanier(FrameBase frame){
        System.out.println("Panier validé");
    }

    public static void ViderPanier(FrameBase frame){
        frame.reservationActuelle.clear();
        frame.filmActuel.clear();
        frame.seanceActuelle.clear();
        ChangementPageListeners.ChangementPage("accueil_films", frame);
    }
}
