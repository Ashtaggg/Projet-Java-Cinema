package C.Listeners;

// Importation des fichiers
import V.TestEnfFrameBase;
import V.EspaceUtilisateur.PageConnexion;
import V.EspaceUtilisateur.PageInscription;
import V.EspaceUtilisateur.PageCompte;
import V.FrameBase;
import V.Reservation.Reservation_Seance;
import V.Reservation.Reservation_Seance_Place;
import V.Reservation.Recap_Reservation;
import V.Panier.Panier;

// Importation des librairies



public class ChangementPageListeners{

    public static void ChangementPage(String boutonName, FrameBase frame) {
        // Effectuer une action en fonction du nom du bouton
        switch (boutonName) {
            case "compte":
                if(frame.userActuel != null){
                    frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                    frame.PageActuelle = "compte";
                    frame.RefreshPage();
                    PageCompte.affichagePageCompte(frame);
                    System.out.println("Compte");
                }
                else if(frame.userActuel == null){
                    frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                    frame.PageActuelle = "connexion";
                    frame.RefreshPage();
                    PageConnexion.affichagePageConnexion(frame);
                    System.out.println("Connexion");
                }
                break;
            case "accueil_films":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "accueil_films";
                frame.RefreshPage();
                TestEnfFrameBase.affichertestEnfFrameBase(frame);
                System.out.println("Accueil");
                break;
            case "connexion":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "connexion";
                frame.RefreshPage();
                PageConnexion.affichagePageConnexion(frame);
                System.out.println("Connexion");
                break;
            case "inscription":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "inscription";
                frame.RefreshPage();
                PageInscription.affichagePageInscription(frame);
                System.out.println("Inscription");
                break;
            case "reservation_seance":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "reservation_seance";
                frame.RefreshPage();
                Reservation_Seance.affichageReservation_Seance(frame);
                System.out.println("Reservation Seance");
                break;
            case "reservation_seance_place":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "reservation_seance";
                frame.RefreshPage();
                Reservation_Seance_Place.affichageReservation_Seance_Place(frame);
                System.out.println("Reservation Seance Placement");
                break;
            case "recap_reservation":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "recap_reservation";
                frame.RefreshPage();
                Recap_Reservation.afficherRecapreservation(frame);
                System.out.println("Recap Reservation");
                break;
            case "panier":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "panier";
                frame.RefreshPage();
                Panier.affichagePanier(frame);
                System.out.println("Panier");
                break;
            case "payer":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "payer";
                frame.RefreshPage();
                Panier.affichagePanier(frame);
                System.out.println("Payment");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
