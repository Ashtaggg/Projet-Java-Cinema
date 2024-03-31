package M.DAO.DAO_MYSQL_WAMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    public static String url;
    public static String username;
    public static String password;

    DAOFactory(String url, String username, String password) {
        this.url = "jdbc:mysql://localhost:3306/projet-java-cinema";
        this.username = "root";
        this.password = "";
    }

    public static DAOFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DAOFactory instance = new DAOFactory(
                "jdbc:mysql://localhost:3306/javaee", "root", "");
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    
}
