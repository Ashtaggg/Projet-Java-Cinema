package C.Listeners.PageConnexion;

import V.FrameBase;
import M.Utilisateur.Inscription;

import javax.swing.*;
import java.util.Date;

public class PageInscription2Listeners {
    public static void boutonSuivant(FrameBase frame, JLabel problemConnexionLabel, String prenom, String nom, String mail, Date date){
        Inscription.suivant1(frame, problemConnexionLabel, prenom, nom, mail, date);
    }
}
