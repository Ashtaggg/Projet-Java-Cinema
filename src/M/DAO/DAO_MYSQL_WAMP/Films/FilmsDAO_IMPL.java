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
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO film (Nom, Prix, DateSortie, Photo, Duree, Description, Note, 4DX, Realisateur, Acteur, Synopsis) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, film.getNom());
            preparedStatement.setDouble(2, film.getPrix());
            java.sql.Date dateSql = new java.sql.Date(film.getDateSortie().getTime());
            preparedStatement.setDate(3, dateSql);
            preparedStatement.setString(4, film.getPhoto());
            preparedStatement.setString(5, film.getDuree());
            preparedStatement.setString(6, film.getDescription());
            preparedStatement.setDouble(7, film.getNote());
            preparedStatement.setBoolean(8, film.getQuatreDX());
            preparedStatement.setString(9, film.getRealisateur());
            preparedStatement.setString(10, film.getActeur());
            preparedStatement.setString(11, film.getSynopsis());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierFilm(Film film) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE film SET Nom = ?, Prix = ?, DateSortie = ?, Photo = ?, Duree = ?, Description = ?, Note = ?, 4DX = ?, Realisateur = ?, Acteur = ?, Synopsis = ? WHERE ID_Film = ?;");
            preparedStatement.setString(1, film.getNom());
            preparedStatement.setDouble(2, film.getPrix());
            java.sql.Date dateSql = new java.sql.Date(film.getDateSortie().getTime());
            preparedStatement.setDate(3, dateSql);
            preparedStatement.setString(4, film.getPhoto());
            preparedStatement.setString(5, film.getDuree());
            preparedStatement.setString(6, film.getDescription());
            preparedStatement.setDouble(7, film.getNote());
            preparedStatement.setBoolean(8, film.getQuatreDX());
            preparedStatement.setString(9, film.getRealisateur());
            preparedStatement.setString(10, film.getActeur());
            preparedStatement.setString(11, film.getSynopsis());
            preparedStatement.setInt(12, film.getIdFilm());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerFilm(Film film) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM film WHERE ID_Film = ?");
            preparedStatement.setInt(1, film.getIdFilm());

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void supprimerFilmByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM film WHERE ID_Film = ?");
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public Film recupererFilmByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM film WHERE ID_Film = ?");
            preparedStatement.setInt(1, ID);

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                int idFilm = result.getInt("ID_Film");
                String nom = result.getString("Nom");
                float prix = result.getFloat("Prix");
                Date dateSortie = result.getDate("DateSortie");
                String photo = result.getString("Photo");
                String duree = result.getString("Duree");
                String description = result.getString("Description");
                double note = result.getDouble("Note");
                Boolean quatreDX = result.getBoolean("4DX");
                String realisateur = result.getString("Realisateur");
                String acteur = result.getString("Acteur");
                String synopsis = result.getString("Synopsis");

                Film film = new Film(idFilm, nom, prix, dateSortie, photo, duree, description, note, quatreDX, realisateur, acteur, synopsis);

                return film;
            }

        } catch (SQLException error) {
            System.out.println(error);
        }

        return null;
    }

    public Film recupererFilmByTitre(String titre) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM film WHERE Nom = ?");
            preparedStatement.setString(1, titre);

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                int idFilm = result.getInt("ID_Film");
                String nom = result.getString("Nom");
                float prix = result.getFloat("Prix");
                Date dateSortie = result.getDate("DateSortie");
                String photo = result.getString("Photo");
                String duree = result.getString("Duree");
                String description = result.getString("Description");
                double note = result.getDouble("Note");
                Boolean quatreDX = result.getBoolean("4DX");
                String realisateur = result.getString("Realisateur");
                String acteur = result.getString("Acteur");
                String synopsis = result.getString("Synopsis");

                Film film = new Film(idFilm, nom, prix, dateSortie, photo, duree, description, note, quatreDX, realisateur, acteur, synopsis);

                return film;
            }

        } catch (SQLException error) {
            System.out.println(error);
        }

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

    public void afficherFilm(Film film) {
        System.out.println("\n--> Film: ");
        System.out.println("ID_Film: " + film.getIdFilm());
        System.out.println("Nom: " + film.getNom());
        System.out.println("Prix: " + film.getPrix());
        System.out.println("DateSortie: " + film.getDateSortie());
        //System.out.println("Photo: " + film.getPhoto());
        System.out.println("Duree: " + film.getDuree());
        System.out.println("Description: " + film.getDescription());
        System.out.println("Note: " + film.getNote());
        System.out.println("4DX: " + film.getQuatreDX());
        System.out.println("Realisateur: " + film.getRealisateur());
        System.out.println("Acteur: " + film.getActeur());
        System.out.println("Synopsis: " + film.getSynopsis() + "\n");
    }

    public void afficherTousLesFilms(List<Film> films) {
        for (Film film : films) {
            afficherFilm(film);
        }
    }

}
