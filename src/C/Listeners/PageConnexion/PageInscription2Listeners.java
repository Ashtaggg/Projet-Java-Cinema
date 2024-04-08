package C.Listeners.PageConnexion;

import V.FrameBase;
import M.Utilisateur.Inscription;

import java.util.Date;

public class PageInscription2Listeners {
    public static void boutonSuivant(FrameBase frame, String prenom, String nom, String mail, Date date){
        Inscription.suivant1(frame, prenom, nom, mail, date);
    }
}
