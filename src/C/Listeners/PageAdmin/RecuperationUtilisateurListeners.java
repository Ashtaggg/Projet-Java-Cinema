package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;

public class RecuperationUtilisateurListeners {
    public static Utilisateur recupUtilisateur(FrameBase frame, int ID){
        Utilisateur utilisateur = frame.utilisateursDAO.recupererUtilisateurByID(ID);
        return utilisateur;
    }
}
