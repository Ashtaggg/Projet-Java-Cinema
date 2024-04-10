package M.DAO.DAO_MYSQL_WAMP.Billets;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Billet;

//Imports Java
import java.util.List;


public interface BilletDAO{
    //Methodes

    //Ajouter un billet
    void ajouterBillet(Billet billet);
    //Modifier un billet
    void modifierBillet(Billet billet);
    //Supprimer un billet
    void supprimerBillet(Billet billet);
    //Récupérer un billet avec son id
    Billet recupererBilletByID(int ID);
    //Récupérer tous les billets
    List<Billet> recupererTousLesBillets();
    //Récupérer tous les billets d'une réservation
    List<Billet> recupererBilletsByReservation(int IDReservation);
    //Récupérer tous les billets d'une seance
    List<Billet> recupererBilletsBySeance(int IDSeance);
}