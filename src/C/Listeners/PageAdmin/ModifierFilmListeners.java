package C.Listeners.PageAdmin;

import M.Utilisateur.Admin;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;

public class ModifierFilmListeners {
    public static void modifFilms(FrameBase frame, JLabel problemValiderFilmLabel, int ID, String Photo, String Titre, String Realisateur, Date Date, String Description, String Duree, double Note, String Acteurs, String Synopsis, int QuatreDX){
        Admin.ModifierFilm(frame, problemValiderFilmLabel, ID, Photo, Titre, Realisateur, Date, Description, Duree, Note, Acteurs, Synopsis, QuatreDX);
    }
}
