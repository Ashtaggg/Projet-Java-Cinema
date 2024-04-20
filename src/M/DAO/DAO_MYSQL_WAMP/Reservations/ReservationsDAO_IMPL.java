package M.DAO.DAO_MYSQL_WAMP.Reservations;

// Imports fichiers
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
import M.JAVA_MODEL.Global_CLASS.Reservation;

// Imports librairies
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationsDAO_IMPL implements ReservationsDAO {

    public void ajouterReservation(Reservation reservation) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "INSERT INTO reservation (ID_Compte, ID_Seance, NombrePlace, PrixTotal) VALUES (?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, reservation.getIdCompte());
            preparedStatement.setInt(2, reservation.getIdSeance());
            preparedStatement.setInt(3, reservation.getNombrePlace());
            preparedStatement.setDouble(4, reservation.getPrixTotal());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void modifierReservation(Reservation reservation) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "UPDATE reservation SET ID_Compte=?, ID_Seance=?, NombrePlace=?, PrixTotal=? WHERE ID_Reservation=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, reservation.getIdCompte());
            preparedStatement.setInt(2, reservation.getIdSeance());
            preparedStatement.setInt(3, reservation.getNombrePlace());
            preparedStatement.setDouble(4, reservation.getPrixTotal());
            preparedStatement.setInt(5, reservation.getIdReservation());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerReservation(Reservation reservation) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM reservation WHERE ID_Reservation=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, reservation.getIdReservation());

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public void supprimerReservationByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "DELETE FROM reservation WHERE ID_Reservation=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }
    }

    public Reservation recupererReservationByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reservation reservation = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM reservation WHERE ID_Reservation=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("ID_Reservation"),
                        resultSet.getInt("ID_Compte"),
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("PrixTotal")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return reservation;
    }

    public List<Reservation> recupererToutesLesReservations() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM reservation";
            preparedStatement = connexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("ID_Reservation"),
                        resultSet.getInt("ID_Compte"),
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("PrixTotal")
                );
                reservations.add(reservation);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return reservations;
    }

    public List<Reservation> recupererToutesLesReservationsByIDSeance(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM reservation WHERE ID_Seance = ?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("ID_Reservation"),
                        resultSet.getInt("ID_Compte"),
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("PrixTotal")
                );
                reservations.add(reservation);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return reservations;
    }

    public Reservation recupererReservationBySeance(int SeanceID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reservation reservation = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM reservation WHERE ID_Seance=?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, SeanceID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("ID_Reservation"),
                        resultSet.getInt("ID_Compte"),
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("PrixTotal")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return reservation;
    }

    public List<Reservation> recupererReservationByUtilisateur(int UtilisateurID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        List<Reservation> reservation = new ArrayList<>();

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM reservation WHERE ID_Compte=?");
            preparedStatement.setInt(1, UtilisateurID);

            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                reservation.add(new Reservation(resultat.getInt("ID_Reservation"), resultat.getInt("ID_Compte"), resultat.getInt("ID_Seance"), resultat.getInt("NombrePlace"), resultat.getDouble("PrixTotal")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return reservation;
    }

    public void afficherReservation(Reservation reservation) {
        System.out.println("\n-->Reservation:");
        System.out.println("ID_Reservation: " + reservation.getIdReservation());
        System.out.println("ID_Compte: " + reservation.getIdCompte());
        System.out.println("ID_Seance: " + reservation.getIdSeance());
        System.out.println("NombrePlace: " + reservation.getNombrePlace());
        System.out.println("PrixTotal: " + reservation.getPrixTotal() + "\n");
    }

    public void afficherToutesLesReservations(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            afficherReservation(reservation);
        }
    }

    public Reservation recupererDerniereReservation() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Reservation reservation = null;

        try {
            connexion = DAOFactory.getConnection();
            String query = "SELECT * FROM reservation ORDER BY ID_Reservation DESC LIMIT 1";
            preparedStatement = connexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("ID_Reservation"),
                        resultSet.getInt("ID_Compte"),
                        resultSet.getInt("ID_Seance"),
                        resultSet.getInt("NombrePlace"),
                        resultSet.getInt("PrixTotal")
                );
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            DAOFactory.close(connexion);
        }

        return reservation;
    }

}

