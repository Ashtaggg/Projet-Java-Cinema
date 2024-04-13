package M.DAO.DAO_MYSQL_WAMP.Billets;

//Imports Fichiers
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
import M.DAO.DAO_MYSQL_WAMP.Reservations.ReservationsDAO;
import M.DAO.DAO_MYSQL_WAMP.Reservations.ReservationsDAO_IMPL;
import M.JAVA_MODEL.Global_CLASS.Reservation;

//Imports Java
import java.util.List;
import java.sql.*;


public class BilletDAO_IMPL implements BilletDAO{
    
    public void ajouterBillet(Billet billet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO billet (ID_Reservation, NumeroPlace, TypeBillet) VALUES(?, ?, ?)");
            preparedStatement.setInt(1, billet.getIdReservation());
            preparedStatement.setInt(2, billet.getNumeroPlace());
            preparedStatement.setString(3, billet.getTypeBillet());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierBillet(Billet billet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE billet SET ID_Reservation = ?, NumeroPlace = ?, TypeBillet = ? WHERE ID_Billet = ?;");
            preparedStatement.setInt(1, billet.getIdReservation());
            preparedStatement.setInt(2, billet.getNumeroPlace());
            preparedStatement.setString(3, billet.getTypeBillet());
            preparedStatement.setInt(4, billet.getIdBillet());

            preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();}
    }

    public void supprimerBillet(Billet billet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM billet WHERE ID_Billet = ?;");
            preparedStatement.setInt(1, billet.getIdBillet());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public void supprimerBilletByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM billet WHERE ID_Billet = ?;");
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();}
    }

    public Billet recupererBilletByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        Billet billet = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM billet WHERE ID_Billet = ?;");
            preparedStatement.setInt(1, ID);

            resultat = preparedStatement.executeQuery();

            if (resultat.next()) {
                billet = new Billet(resultat.getInt("ID_Billet"), resultat.getInt("ID_Reservation"), resultat.getInt("NumeroPlace"), resultat.getString("TypeBillet"));
            }

        } catch (SQLException e) {
            e.printStackTrace();}
        return billet;
    }

    public List<Billet> recupererTousLesBillets() {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        List<Billet> billets = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM billet;");
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                billets.add(new Billet(resultat.getInt("ID_Billet"), resultat.getInt("ID_Reservation"), resultat.getInt("NumeroPlace"), resultat.getString("TypeBillet")));
            }

        } catch (SQLException e) {
            e.printStackTrace();}
        return billets;
    }

    public List<Billet> recupererBilletsByReservation(int IDReservation) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        List<Billet> billets = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM billet WHERE ID_Reservation = ?;");
            preparedStatement.setInt(1, IDReservation);

            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                billets.add(new Billet(resultat.getInt("ID_Billet"), resultat.getInt("ID_Reservation"), resultat.getInt("NumeroPlace"), resultat.getString("TypeBillet")));
            }

        } catch (SQLException e) {
            e.printStackTrace();}
        return billets;
    }

    public List<Billet> recupererBilletsBySeance(int IDSeance) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        List<Billet> billets = null;

        try {
            connexion = DAOFactory.getConnection();
            //D'abord récupérer tout les ID Reservation
            preparedStatement = connexion.prepareStatement("SELECT ID_Reservation FROM seance ;");
            resultat = preparedStatement.executeQuery();
            List<Integer> IDReservations = null;
            while (resultat.next()) {
                IDReservations.add(resultat.getInt("ID_Reservation"));
            }
            //Ensuite récupérer tout les réservations présentes dans la table séance
            List<Reservation> reservations = null;
            for (int IDReservation : IDReservations) {
                ReservationsDAO reservationsDAO = new ReservationsDAO_IMPL();
                reservations.add(reservationsDAO.recupererReservationByID(IDReservation));
            }
            for (Reservation reservation : reservations) {
                billets.addAll(recupererBilletsByReservation(reservation.getIdReservation()));
            }

        } catch (SQLException e) {
            e.printStackTrace();}
        return billets;
    }

    

}
