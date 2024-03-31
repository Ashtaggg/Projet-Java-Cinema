package M.JAVA_MODEL.Global_CLASS;

//Imports
import java.util.Date;

//Je ne sais pas si cette classe sera vraiment utile pour l'instant à vérifier avec l'avanacement du projet
public class Actual_Utilisateur extends Utilisateur {
    // Constructeur
    public Actual_Utilisateur(int idCompte, int admin, String prenom, String nom, String motDePasse, Date dateNaissance,
                       String photoProfil, String mail, String telephone, String adresse, int genre, String carteNum,
                       String carteDate, int carteCCV, String carteNom) {
        super(idCompte, admin, prenom, nom, motDePasse, dateNaissance, photoProfil, mail, telephone, adresse, genre,
                carteNum, carteDate, carteCCV, carteNom);
    }

    // Autres méthodes spécifiques à la classe Actual_Utilisateur peuvent être ajoutées ici
}
