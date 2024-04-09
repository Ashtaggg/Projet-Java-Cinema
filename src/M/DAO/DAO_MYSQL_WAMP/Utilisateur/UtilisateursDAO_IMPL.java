package M.DAO.DAO_MYSQL_WAMP.Utilisateur;

//ImportsFichiers
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
//Imports Java
import java.util.List;
import java.sql.*;

public class UtilisateursDAO_IMPL implements UtilisateursDAO{
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO compte (admin, prenom, nom, motDePasse, dateNaissance, photoProfil, mail, telephone, adresse, genre, carteNum, carteDate, carteCCV, carteNom) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, utilisateur.getAdmin());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getMotDePasse());
            java.sql.Date dateSql = new java.sql.Date(utilisateur.getDateNaissance().getTime());
            preparedStatement.setDate(5, dateSql);
            preparedStatement.setString(6, utilisateur.getPhotoProfil());
            preparedStatement.setString(7, utilisateur.getMail());
            preparedStatement.setString(8, utilisateur.getTelephone());
            preparedStatement.setString(9, utilisateur.getAdresse());
            preparedStatement.setInt(10, utilisateur.getGenre());
            preparedStatement.setString(11, utilisateur.getCarteNum());
            preparedStatement.setString(12, utilisateur.getCarteDate());
            preparedStatement.setInt(13, utilisateur.getCarteCCV());
            preparedStatement.setString(14, utilisateur.getCarteNom());

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        // A faire
    }

    public void modifierUtilisateurByID(int ID) {
        // A faire
    }

    public void supprimerUtilisateur(Utilisateur utilisateur) {
        // A faire
    }

    public void supprimerUtilisateurByID(int ID) {
        // A faire
    }

    public Utilisateur recupererUtilisateurByID(int ID) {
        // A faire
        return null;
    }

    public Utilisateur recupererUtilisateurByEmail(String email) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM compte WHERE Mail = ?");
            preparedStatement.setString(1, email);

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                int idCompte = result.getInt("ID_Compte");
                int admin = result.getInt("Admin");
                String prenom = result.getString("Prenom");
                String nom = result.getString("Nom");
                String motDePasse = result.getString("MotDePasse");
                Date dateNaissance = result.getDate("DateNaissance");
                String photoProfil = result.getString("PhotoProfil");
                String mail = result.getString("Mail");
                String telephone = result.getString("Telephone");
                String adresse = result.getString("Adresse");
                int genre = result.getInt("Genre");
                String carteNum = result.getString("CarteNum");
                String carteDate = result.getString("CarteDate");
                int carteCCV = result.getInt("CarteCCV");
                String carteNom = result.getString("CarteNom");

                Utilisateur user = new Utilisateur(idCompte, admin, prenom, nom, motDePasse, dateNaissance, photoProfil, mail, telephone, adresse, genre, carteNum, carteDate, carteCCV, carteNom);

                return user;
            }

        } catch (SQLException error) {
            System.out.println(error);
        }

        return null;
    }

    
    public int emailDejaUtilise(String email) {
        int utilise = 0;

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT COUNT(*) FROM compte WHERE Mail = ?");
            preparedStatement.setString(1, email);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int count = result.getInt(1);
                if(count > 0){
                    utilise = 1;
                }
            }

        } catch (SQLException error) {
            System.out.println(error);
        }

        return utilise;
    }

    public List<Utilisateur> recupererTousLesUtilisateurs() {
        // A faire
        return null;
    }
}
