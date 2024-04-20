package M.DAO.DAO_MYSQL_WAMP.Films;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Film;
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
//Imports Java
import java.util.List;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;



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


    public BufferedImage recupererImageAvatarLaVoieDeLEau() {
        // Déclarez une variable pour stocker l'image récupérée
        BufferedImage image = null;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
    
        // Déclarez la requête SQL pour récupérer l'image d'Avatar la voie de l'eau
        String sql = "SELECT photo FROM films WHERE titre = 'Avatar la voie de l\'eau'";
    
        // Établissez une connexion à la base de données
        try {
             connexion = DAOFactory.getConnection();;
             PreparedStatement statement = connexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
    
            // Vérifiez si un enregistrement a été trouvé
            if (resultSet.next()) {
                // Récupérez l'image à partir du résultat de la requête
                String photoBase64 = resultSet.getString("photo");
                // Convertissez l'image en BufferedImage
                image = ConvertirImageHexa.HexToImage(photoBase64);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérez les exceptions SQL ici
        }
    
        // Renvoyez l'image récupérée
        return image;
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
        List<Film> films = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM film");
            result = preparedStatement.executeQuery();

            while (result.next()) {
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
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception (par exemple, en lançant une nouvelle exception personnalisée ou en loggant l'erreur)
        } finally {
            // Fermer les ressources (ResultSet, PreparedStatement et Connection)
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return films;
    }

    public void afficherFilm(Film film) {
        System.out.println("\n--> Film: ");
        System.out.println("ID_Film: " + film.getIdFilm());
        System.out.println("Nom: " + film.getNom());
        System.out.println("Prix: " + film.getPrix());
        System.out.println("DateSortie: " + film.getDateSortie());
        System.out.println("Photo: " + film.getPhoto());
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
