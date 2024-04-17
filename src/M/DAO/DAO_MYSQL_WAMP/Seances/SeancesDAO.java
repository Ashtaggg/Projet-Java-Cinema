package M.DAO.DAO_MYSQL_WAMP.Seances;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Seance;
//Imports Java
import java.util.List;

//Interface SeancesDAO pour définir les méthodes pour les Seances
public interface SeancesDAO {
    //Methodes

    //Ajouter une seance
    void ajouterSeance(Seance seance);
    //Modifier une seance
    void modifierSeance(Seance seance);
    //Supprimer une seance
    void supprimerSeance(Seance seance);
    //Supprimer une seance par ID
    void supprimerSeanceByID(int ID);
    //Récupérer une seance avec son id
    Seance recupererSeanceByID(int ID);
    //Récupérer une seance avec son id de film
    Seance recupererSeanceByFilm(int FilmID);
    //Récupérer une seance avec son id de salle
    Seance recupererSeanceBySalle(int SalleID);
    //Récupérer toutes les seances
    List<Seance> recupererToutesLesSeances();
    //Affciher une seance
    void afficherSeance(Seance seance);
    //Afficher toutes les seances d'une liste
    void afficherToutesLesSeances(List<Seance> seances);
    //Récupérer toutes les seances d'un film
    List<Seance> recupererSeancesByFilm(int IDFilm);
    //Réduire nombre de places dispo d'une une seance
    void reduirePlaces(int IDSeance, int nbPlaces);
}
