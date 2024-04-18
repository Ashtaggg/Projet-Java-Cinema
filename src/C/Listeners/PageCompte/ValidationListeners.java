package C.Listeners.PageCompte;

import M.Utilisateur.Validation;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;

public class ValidationListeners {
    public static void boutonValidation(FrameBase frame, JLabel problemValidationLabel, String photo, String Prenom, String Nom, String Mail, String Tel, Date Date, String Adresse, String Mdp, String Mdp2, String CarteNum, String CarteDate, String CarteCCV, String CarteNom){
        Validation.valider(frame, problemValidationLabel, photo, Prenom, Nom, Mail, Tel, Date, Adresse, Mdp, Mdp2, CarteNum, CarteDate, CarteCCV, CarteNom);
    }
}
