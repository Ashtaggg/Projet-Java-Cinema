package src.M.DAO.DAO_MYSQL_WAMP.Salles;

//Imports Fichiers
import src.M.JAVA_MODEL.Global_CLASS.Salle;
//Imports Java
import java.util.List;

//Interface SallesDAO pour définir les méthodes liées à la table Salles
public interface SallesDAO {
    //Methodes

    //Ajouter une salle
    void ajouterSalle(Salle salle);
    //Modifier une salle
    void modifierSalle(Salle salle);
    //Modifier une salle par ID
    void modifierSalleByID(int ID);
    //Supprimer une salle
    void supprimerSalle(Salle salle);
    //Supprimer une salle par ID
    void supprimerSalleByID(int ID);
    //Récupérer une salle avec son id
    Salle recupererSalleByID(int ID);
    //Récupérer toutes les salles
    List<Salle> recupererToutesLesSalles();
}
