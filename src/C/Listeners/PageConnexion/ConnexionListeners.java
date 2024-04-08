package C.Listeners.PageConnexion;

import javax.swing.*;

import M.Utilisateur.Connexion;
import V.FrameBase;

public class ConnexionListeners {
    public static void boutonConnexion(FrameBase frame, JLabel problemConnexionLabel, String mail, String password){
        Connexion.connexionToUser(frame, problemConnexionLabel, mail, password);
    }
}
