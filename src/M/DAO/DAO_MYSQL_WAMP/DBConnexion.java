package src.M.DAO.DAO_MYSQL_WAMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnexion {

    // Informations de connexion à la base de données
    public static String url = "jdbc:mysql://localhost:3306/projet-java-cinema";
    public static String user = "root";
    public static String password = "";

    public static void Connexion(){
        // Connexion à la base de données
        Connection connection = null;
        try{
            // Chargement du driver JDBC
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {// Gestion des exceptions
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    public static void Deconnexion(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la déconnexion à la base de données : " + e.getMessage());
        }
    }

}
