package M.DAO.DAO_MYSQL_WAMP.Salles;

// Imports fichiers
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
import M.JAVA_MODEL.Global_CLASS.Salle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SallesDAO_IMPL implements SallesDAO {

    public void ajouterSalle(Salle salle) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "INSERT INTO salle (NombrePlace, Etage, 4DX) VALUES (?, ?, ?)";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, salle.getNombrePlace());
            preparedStatement.setInt(2, salle.getEtage());
            preparedStatement.setInt(3, salle.getQuatreDX() ? 1 : 0);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void modifierSalle(Salle salle) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "UPDATE salle SET NombrePlace=?, Etage=?, 4DX=? WHERE ID_Salle=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, salle.getNombrePlace());
            preparedStatement.setInt(2, salle.getEtage());
            preparedStatement.setInt(3, salle.getQuatreDX() ? 1 : 0);
            preparedStatement.setInt(4, salle.getIdSalle());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerSalle(Salle salle) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM salle WHERE ID_Salle=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, salle.getIdSalle());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerSalleByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM salle WHERE ID_Salle=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public Salle recupererSalleByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Salle salle = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM salle WHERE ID_Salle=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                salle = new Salle(resultSet.getInt("ID_Salle"), resultSet.getInt("NombrePlace"), resultSet.getInt("Etage"), resultSet.getInt("4DX") == 1);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return salle;
    }

    public List<Salle> recupererToutesLesSalles() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Salle> salles = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM salle";
            preparedStatement = connexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Salle salle = new Salle(
                        resultSet.getInt("ID_Salle"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("Etage"),
                        resultSet.getInt("4DX") == 1
                );
                salles.add(salle);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return salles;
    }

    //Afficher une Salle
    public void afficherSalle(Salle salle) {
        System.out.println("\n--> Salle:");
        System.out.println("ID_Salle: " + salle.getIdSalle());
        System.out.println("Nombre de places: " + salle.getNombrePlace());
        System.out.println("Etage: " + salle.getEtage());
        System.out.println("4DX: " + (salle.getQuatreDX() ? "Oui" : "Non") + "\n");
    }

    //Afficher toutes les Salles
    public void afficherToutesLesSalles(List<Salle> salles) {

        for (Salle salle : salles) {
            afficherSalle(salle);
        }
    }



}
