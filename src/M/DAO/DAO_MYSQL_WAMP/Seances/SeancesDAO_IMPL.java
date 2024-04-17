package M.DAO.DAO_MYSQL_WAMP.Seances;

//Imports Fichiers
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
import M.JAVA_MODEL.Global_CLASS.Seance;

//Imports Java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeancesDAO_IMPL implements SeancesDAO {

    public void ajouterSeance(Seance seance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "INSERT INTO seance (ID_Film, ID_Salle, Date, Heure, PlaceDisponible) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, seance.getIdFilm());
            preparedStatement.setInt(2, seance.getIdSalle());
            preparedStatement.setDate(3, new java.sql.Date(seance.getDate().getTime()));
            preparedStatement.setTime(4, java.sql.Time.valueOf(seance.getHeure()));
            preparedStatement.setInt(5, seance.getPlaceDisponible());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void modifierSeance(Seance seance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "UPDATE seance SET ID_Film=?, ID_Salle=?, Date=?, Heure=?, PlaceDisponible=? WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, seance.getIdFilm());
            preparedStatement.setInt(2, seance.getIdSalle());
            preparedStatement.setDate(3, new java.sql.Date(seance.getDate().getTime()));
            preparedStatement.setTime(4, java.sql.Time.valueOf(seance.getHeure()));
            preparedStatement.setInt(5, seance.getPlaceDisponible());
            preparedStatement.setInt(6, seance.getIdSeance());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerSeance(Seance seance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM seance WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, seance.getIdSeance());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerSeanceByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM seance WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public Seance recupererSeanceByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Seance seance = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM seance WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                seance = new Seance(
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("ID_Film"),
                        resultSet.getInt("ID_Salle"),
                        resultSet.getDate("Date"),
                        resultSet.getTime("Heure").toString(),
                        resultSet.getInt("PlaceDisponible")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return seance;
    }

    public Seance recupererSeanceByFilm(int FilmID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Seance seance = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM seance WHERE ID_Film=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, FilmID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                seance = new Seance(
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("ID_Film"),
                        resultSet.getInt("ID_Salle"),
                        resultSet.getDate("Date"),
                        resultSet.getTime("Heure").toString(),
                        resultSet.getInt("PlaceDisponible")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return seance;
    }

    public Seance recupererSeanceBySalle(int SalleID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Seance seance = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM seance WHERE ID_Salle=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, SalleID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                seance = new Seance(
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("ID_Film"),
                        resultSet.getInt("ID_Salle"),
                        resultSet.getDate("Date"),
                        resultSet.getTime("Heure").toString(),
                        resultSet.getInt("PlaceDisponible")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return seance;
    }

    public List<Seance> recupererToutesLesSeances() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seance> seances = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM seance";
            preparedStatement = connexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Seance seance = new Seance(
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("ID_Film"),
                        resultSet.getInt("ID_Salle"),
                        resultSet.getDate("Date"),
                        resultSet.getTime("Heure").toString(),
                        resultSet.getInt("PlaceDisponible")
                );
                seances.add(seance);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return seances;
    }

    public void afficherSeance(Seance seance) {
        System.out.println("\n--> Seance: ");
        System.out.println("ID Seance: " + seance.getIdSeance());
        System.out.println("ID Film: " + seance.getIdFilm());
        System.out.println("ID Salle: " + seance.getIdSalle());
        System.out.println("Date: " + seance.getDate());
        System.out.println("Heure: " + seance.getHeure());
        System.out.println("Place Disponible: " + seance.getPlaceDisponible()+ "\n");
    }

    public void afficherToutesLesSeances(List<Seance> seances) {
        for (Seance seance : seances) {
            afficherSeance(seance);
        }
    }

    public void reduirePlaces(int IDSeance, int nbPlaces) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        //Récupérer les places dispo de la séance 
        Seance seance = recupererSeanceByID(IDSeance);
        int placesDispo = seance.getPlaceDisponible();
        try {
            connexion = DAOFactory.getConnection();
            String query = "UPDATE seance SET PlaceDisponible=? WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, placesDispo - nbPlaces);
            preparedStatement.setInt(2, IDSeance);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public List<Seance> recupererSeancesByFilm(int IDFilm) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        List<Seance> seances = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM seance WHERE ID_Film = ?;");
            preparedStatement.setInt(1, IDFilm);

            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                seances.add(new Seance(resultat.getInt("ID_Seance"), resultat.getInt("ID_Film"), resultat.getInt("ID_Salle"), resultat.getDate("Date"), resultat.getTime("Heure").toString(), resultat.getInt("PlaceDisponible")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }
}

