package M.DAO.DAO_MYSQL_WAMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance() {
        DAOFactory instance = new DAOFactory(
                "jdbc:mysql://localhost:3306/projet-java-cinema", "root", "");
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        DAOFactory instance = DAOFactory.getInstance();
        return DriverManager.getConnection(instance.url, instance.username, instance.password);
    }

    // Récupération du Dao
    
}
