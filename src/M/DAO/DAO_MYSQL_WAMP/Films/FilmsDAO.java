package M.DAO.DAO_MYSQL_WAMP.Films;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Film;
//Imports Java
import java.util.List;

//Interface FilmsDAO pour definir les methodes liees a la table Films
public interface FilmsDAO {
    //Methodes

    //Ajouter un film
    void ajouterFilm(Film film);
    //Modifier un film
    void modifierFilm(Film film);
    //Supprimer un film
    void supprimerFilm(Film film);
    //Supprimer un film par son Id
    void supprimerFilmByID(int ID);
    //Récupérer un film avec son id
    Film recupererFilmByID(int ID);
    //Récupérer un film avec son titre
    Film recupererFilmByTitre(String titre);
    //Récupérer un film avec sa date de sortie
    Film recupererFilmByDate(String dateS);
    //Récupérer un film avec son realisateur
    Film recupererFilmByRealisateur(String realisateur);
    //Récupérer tous les films
    List<Film> recupererTousLesFilms();
    //Récupérer les 10 films les plus récents
    List<Film> recupererFilmsRecents();
    //Compter le nombre de film
    int compterTousLesFilms();
    //Afficcher un film
    void afficherFilm(Film film);
    //Afficher tous les films d'une liste   
    void afficherTousLesFilms(List<Film> films);


}
