package C.Listeners;

// Importation des fichiers
import V.TestEnfFrameBase;
import V.EspaceUtilisateur.PageModifCompte;
import V.EspaceUtilisateur.PageConnexion;
import V.EspaceUtilisateur.PageInscription;
import V.EspaceUtilisateur.PageCompte;
import V.FrameBase;
import V.Reservation.Reservation_Seance;
import V.Reservation.Reservation_Seance_Place;
import V.Reservation.Recap_Reservation;
import V.Panier.Panier;
import V.Paiement.Paiement;
import V.Accueil.Accueil_News;
import V.Accueil.Accueil_Films;
import V.Accueil.Accueil_Cinema;
import V.Admin.EspaceAdmin;
import V.Paiement.MerciAchat;

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
            case "admin":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "admin";
                frame.RefreshPage();
                EspaceAdmin.affichageEspaceAdmin(frame);
                System.out.println("Espace Admin");
                break;
            case "accueil_films":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "accueil_films";
                frame.RefreshPage();
                Accueil_Films.affichageAccueil_Films(frame);
                System.out.println("Accueil Films");
                break;
            case "accueil_news":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "accueil_news";
                frame.RefreshPage();
                Accueil_News.affichageAccueil_News(frame);
                System.out.println("Accueil News ");
                break;
            case "accueil_cinema":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "accueil_cinema";
                frame.RefreshPage();
                Accueil_Cinema.affichageAccueil_Cinema(frame);
                System.out.println("Accueil Cinema");
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
                Paiement.afficherPaiement(frame);
                System.out.println("Payment");
                break;
            case "Merci":
                frame.PagePrecedente.add(String.valueOf(frame.PageActuelle));
                frame.PageActuelle = "Merci";
                frame.RefreshPage();
                MerciAchat.afficherMerciAchat(frame);
                System.out.println("Merci Payment");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
