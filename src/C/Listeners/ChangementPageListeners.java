package C.Listeners;

// Importation des fichiers
import V.TestEnfFrameBase;
import V.EspaceUtilisateur.PageConnexion;
import V.EspaceUtilisateur.PageInscription;
import V.EspaceUtilisateur.PageCompte;
import V.FrameBase;
import V.Reservation.Reservation_Seance;

// Importation des librairies



public class ChangementPageListeners{

    public void ChangementPage(String boutonName, FrameBase frame) {


        // Effectuer une action en fonction du nom du bouton
        switch (boutonName) {
            case "compte":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "compte";
                PageCompte.affichagePageCompte(frame);
                System.out.println("Compte");
                break;
            case "panier":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "panier";
                System.out.println("Panier");
                break;
            case "accueil_films":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "accueil_films";
                TestEnfFrameBase.affichertestEnfFrameBase(frame);
                System.out.println("Accueil");
                break;
            case "connexion":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "connexion";
                PageConnexion.affichagePageConnexion(frame);
                System.out.println("Connexion");
                break;
            case "inscription":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "inscription";
                PageInscription.affichagePageInscription(frame);
                System.out.println("Inscription");
                break;
            case "reservation_seance":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "reservation_seance";
                Reservation_Seance.affichageReservation_Seance(frame);
                System.out.println("Reservation Seance");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
