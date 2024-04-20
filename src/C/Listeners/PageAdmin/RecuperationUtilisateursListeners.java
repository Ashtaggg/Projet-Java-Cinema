package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;

import java.util.List;

public class RecuperationUtilisateursListeners {
    public static List<Utilisateur> recupUsers(FrameBase frame){
        List<Utilisateur> utilisateurs = frame.utilisateursDAO.recupererTousLesUtilisateurs();
        return utilisateurs;
    }
}
