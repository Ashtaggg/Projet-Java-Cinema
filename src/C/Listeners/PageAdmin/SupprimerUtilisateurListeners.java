package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;

public class SupprimerUtilisateurListeners {
    public static void supprUtilisateur(FrameBase frame, Utilisateur utilisateur){
        frame.utilisateursDAO.supprimerUtilisateur(utilisateur);
    }
}
