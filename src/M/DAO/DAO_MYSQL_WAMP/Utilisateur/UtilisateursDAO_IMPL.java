package M.DAO.DAO_MYSQL_WAMP.Utilisateur;

//ImportsFichiers
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.DAO.DAO_MYSQL_WAMP.DAOFactory;
//Imports Java
import java.util.List;
import java.util.ArrayList;
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
            preparedStatement = connexion.prepareStatement("UPDATE compte SET Admin = ?, Prenom = ?, Nom = ?, MotDePasse = ?, DateNaissance = ?, PhotoProfil = ?, Mail = ?, Telephone = ?, Adresse = ?, CarteNum = ?, CarteDate = ?, CarteCCV = ?, CarteNom = ? WHERE ID_Compte = ?;");
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
            preparedStatement.setString(10, utilisateur.getCarteNum());
            preparedStatement.setString(11, utilisateur.getCarteDate());
            preparedStatement.setInt(12, utilisateur.getCarteCCV());
            preparedStatement.setString(13, utilisateur.getCarteNom());
            preparedStatement.setInt(14, utilisateur.getIdCompte());

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void modifierUtilisateurByID(int ID) {
        // A faire
    }

    public void supprimerUtilisateur(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM compte WHERE ID_Compte = ?");
            preparedStatement.setInt(1, utilisateur.getIdCompte());

            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void supprimerUtilisateurByID(int ID) {
        // A faire
    }

    public Utilisateur recupererUtilisateurByID(int ID) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM compte WHERE ID_Compte = ?");
            preparedStatement.setInt(1, ID);

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
        List<Utilisateur> users = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connexion = DAOFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM compte");
            result = preparedStatement.executeQuery();

            while (result.next()) {
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
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception (par exemple, en lançant une nouvelle exception personnalisée ou en loggant l'erreur)
        } finally {
            // Fermer les ressources (ResultSet, PreparedStatement et Connection)
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
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
