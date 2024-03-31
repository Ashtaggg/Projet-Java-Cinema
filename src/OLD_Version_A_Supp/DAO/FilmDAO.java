package OLD_Version_A_Supp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Film;
import util.DBConnection;

public class FilmDAO {
    private Connection connection;

    public FilmDAO() {
        connection = DBConnection.getConnection();
    }

    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM Films";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setTitle(resultSet.getString("title"));
                film.setDescription(resultSet.getString("description"));
                film.setSchedule(resultSet.getString("schedule"));
                film.setTicketPrice(resultSet.getDouble("ticketPrice"));
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    // Ajoutez d'autres méthodes pour CRUD selon les besoins
}
