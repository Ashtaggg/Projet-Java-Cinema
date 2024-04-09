package C.Listeners.PageConnexion;

import M.Utilisateur.Inscription;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;

public class InscriptionListeners {
    public static void boutonInscrire(FrameBase frame, JLabel problemConnexionLabel, String prenom, String nom, String mail, Date date, String tel, String adresse, String mdp, String mdp2){
        Inscription.inscrire(frame, problemConnexionLabel, prenom, nom, mail, date, tel, adresse, mdp, mdp2);
    }
}
