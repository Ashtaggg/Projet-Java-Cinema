package M.DAO.DAO_MYSQL_WAMP.Films;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Film;
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
//Imports Java
import java.util.List;
import java.sql.*;

public class FilmsDAO_IMPL implements FilmsDAO{

    public void ajouterFilm(Film film) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();//J'ai un doute sur ca 
            preparedStatement = connexion.prepareStatement("INSERT INTO film (Nom, Prix, DateSortie, Photo, Durée, Description, Note, 4DX, Realisateur, Acteur, Synopsis) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, film.getNom());
            preparedStatement.setDouble(2, film.getPrix());
            java.sql.Date dateSql = new java.sql.Date(film.getDateSortie().getTime());
            preparedStatement.setDate(3, dateSql);
            preparedStatement.setString(4, film.getPhoto());
            preparedStatement.setString(5, film.getDuree());
            preparedStatement.setString(6, film.getDescription());
            preparedStatement.setDouble(7, film.getNote());
            preparedStatement.setInt(8, film.getQuatreDX());
            preparedStatement.setString(9, film.getRealisateur());
            preparedStatement.setString(10, film.getActeur());
            preparedStatement.setString(11, film.getSynopsis());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierFilm(Film film) {
        // A faire
    }

    public void modifierFilmByID(int ID) {
        // A faire
    }

    public void supprimerFilm(Film film) {
        // A faire
    }

    public void supprimerFilmByID(int ID) {
        // A faire
    }

    public Film recupererFilmByID(int ID) {
        // A faire
        return null;
    }

    public Film recupererFilmByTitre(String titre) {
        // A faire
        return null;
    }

    public Film recupererFilmByDate(String dateS) {
        // A faire
        return null;
    }

    public Film recupererFilmByRealisateur(String realisateur) {
        // A faire
        return null;
    }

    public List<Film> recupererTousLesFilms() {
        // A faire
        return null;
    }

}
