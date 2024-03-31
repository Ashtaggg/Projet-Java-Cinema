package OLD_Version_A_Supp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reservation;
import util.DBConnection;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM Reservations";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setFilmId(resultSet.getInt("filmId"));
                reservation.setClientId(resultSet.getInt("clientId"));
                reservation.setNumberOfTickets(resultSet.getInt("numberOfTickets"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    // Ajoutez d'autres méthodes pour CRUD selon les besoins
}
