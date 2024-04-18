package C.Listeners.PageAdmin;

import M.Utilisateur.Admin;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;

public class AjouterFilmListeners {
    public static void boutonValiderFilm(FrameBase frame, JLabel problemValiderFilmLabel, String Photo, String Titre, String Realisateur, Date Date, String Description, String Duree, double Note, String Acteurs, String Synopsis, int QuatreDX){
        Admin.AjouterFilm(frame, problemValiderFilmLabel, Photo, Titre, Realisateur, Date, Description, Duree, Note, Acteurs, Synopsis, QuatreDX);
    }
}
