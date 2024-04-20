package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;

public class ModifierUtilisateurListeners {
    public static void modifUtilisateur(FrameBase frame, Utilisateur utilisateur){
        frame.utilisateursDAO.modifierUtilisateur(utilisateur);
    }
}
