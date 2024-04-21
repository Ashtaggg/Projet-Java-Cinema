package M.DAO.DAO_MYSQL_WAMP.Seances;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Seance;
//Imports Java
import java.util.List;
import java.util.Date;

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
    //Récupérer toutes les seances à partir d'un ID Film
    List<Seance> recupererToutesLesSeancesByIDFilm(int ID);
    //Récupérer toutes les seances à partir d'un ID Film et d'une date
    List<Seance> recupererToutesLesSeancesByIDFilmAndDate(int ID, Date date);
    //Récupérer toutes les seances à partir d'un ID Salle et d'une date
    List<Seance> recupererToutesLesSeancesByIDSalleAndDate(int ID, Date date);
    //Affciher une seance
    void afficherSeance(Seance seance);
    //Afficher toutes les seances d'une liste
    void afficherToutesLesSeances(List<Seance> seances);
    //Récupérer toutes les seances d'un film
    List<Seance> recupererSeancesByFilm(int IDFilm);
    //Réduire nombre de places dispo d'une une seance
    void reduirePlaces(int IDSeance, int nbPlaces);
}
