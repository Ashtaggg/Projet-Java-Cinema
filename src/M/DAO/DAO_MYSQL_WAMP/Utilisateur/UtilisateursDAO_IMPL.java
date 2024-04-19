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
            utilisateur.setDateNaissance(dateSql);
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
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE compte SET Prenom = ?, Nom = ?, MotDePasse = ?, DateNaissance = ?, PhotoProfil = ?, Mail = ?, Telephone = ?, Adresse = ?, CarteNum = ?, CarteDate = ?, CarteCCV = ?, CarteNom = ? WHERE ID_Compte = ?;");
            preparedStatement.setString(1, utilisateur.getPrenom());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getMotDePasse());
            java.sql.Date dateSql = new java.sql.Date(utilisateur.getDateNaissance().getTime());
            utilisateur.setDateNaissance(dateSql);
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setString(5, utilisateur.getPhotoProfil());
            preparedStatement.setString(6, utilisateur.getMail());
            preparedStatement.setString(7, utilisateur.getTelephone());
            preparedStatement.setString(8, utilisateur.getAdresse());
            preparedStatement.setString(9, utilisateur.getCarteNum());
            preparedStatement.setString(10, utilisateur.getCarteDate());
            preparedStatement.setInt(11, utilisateur.getCarteCCV());
            preparedStatement.setString(12, utilisateur.getCarteNom());
            preparedStatement.setInt(13, utilisateur.getIdCompte());

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
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

    public void afficherUtilisateur(Utilisateur utilisateur) {
        System.out.println("\n--> Utilisateur:");
        System.out.println("ID_Compte: " + utilisateur.getIdCompte());
        System.out.println("Admin: " + utilisateur.getAdmin());
        System.out.println("Prenom: " + utilisateur.getPrenom());
        System.out.println("Nom: " + utilisateur.getNom());
        System.out.println("MotDePasse: " + utilisateur.getMotDePasse());
        System.out.println("DateNaissance: " + utilisateur.getDateNaissance() + "\n");
        //System.out.println("PhotoProfil: " + utilisateur.getPhotoProfil());
    }

    public void afficherTousLesUtilisateurs(List<Utilisateur> utilisateurs) {
        for (Utilisateur utilisateur : utilisateurs) {
            afficherUtilisateur(utilisateur);
        }
    }
}
