package M.DAO.DAO_MYSQL_WAMP.Reservations;

//Imports Fichies
import M.JAVA_MODEL.Global_CLASS.Reservation;
//Imports Java
import java.util.List;


//Interface ReservationsDAO pour définir les méthodes liées à la table Reservations
public interface ReservationsDAO {
    //Methodes

    //Ajouter une reservation
    void ajouterReservation(Reservation reservation);
    //Modifier une reservation
    void modifierReservation(Reservation reservation);
    //Supprimer une reservation
    void supprimerReservation(Reservation reservation);
    //Supprimer une reservation par ID
    void supprimerReservationByID(int ID);
    //Récupérer une reservation avec son id
    Reservation recupererReservationByID(int ID);
    //Récupérer une reservation avec son id de seance
    Reservation recupererReservationBySeance(int SeanceID);
    //Récupérer une reservation avec son id d'utilisateur
    List<Reservation> recupererReservationByUtilisateur(int UtilisateurID);
    //Récupérer toutes les reservations
    List<Reservation> recupererToutesLesReservations();
    //Affciher une reservation
    void afficherReservation(Reservation reservation);
    //Afficher toutes les reservations d'une liste
    void afficherToutesLesReservations(List<Reservation> reservations);
}
