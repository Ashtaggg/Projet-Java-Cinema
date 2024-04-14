package M.DAO.DAO_MYSQL_WAMP.Utilisateur;

//ImportsFichiers
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
//Imports Java
import java.util.List;

//Interface UtilisateursDAO pour définir les méthodes pour les utilisateurs
public interface UtilisateursDAO {
    //Methodes

    //Ajouter un utilisateur
    void ajouterUtilisateur(Utilisateur utilisateur);
    //Modifier un utilisateur
    void modifierUtilisateur(Utilisateur utilisateur);
    //Modifier un utilisateur par ID
    void modifierUtilisateurByID(int ID);
    //Supprimer un utilisateur
    void supprimerUtilisateur(Utilisateur utilisateur);
    //Supprimer un utilisateur par ID
    void supprimerUtilisateurByID(int ID);
    //Récupérer un utilisateur avec son id
    Utilisateur recupererUtilisateurByID(int ID);
    //Récupérer un utilisateur avec son email
    Utilisateur recupererUtilisateurByEmail(String email);
    //Récupérer tous les utilisateurs
    List<Utilisateur> recupererTousLesUtilisateurs();
    //Affciher un utilisateur
    void afficherUtilisateur(Utilisateur utilisateur);
    //Afficher tous les utilisateurs d'une liste
    void afficherTousLesUtilisateurs(List<Utilisateur> utilisateurs);
}
