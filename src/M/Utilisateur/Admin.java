package M.Utilisateur;

import  C.Listeners.ChangementPageListeners;
import  M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.JAVA_MODEL.Global_CLASS.Film;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;

public class Admin {
    public static void AjouterFilm(FrameBase frame, JLabel problemValiderFilmLabel, String Photo, String Titre, String Realisateur, Date Date, String Description, String Duree, double Note, String Acteurs, String Synopsis, int QuatreDX){
        if(Titre.equals("")){
            problemValiderFilmLabel.setText("Aucun titre n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Realisateur.equals("")){
            problemValiderFilmLabel.setText("Aucun réalisateur n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Date == null){
            problemValiderFilmLabel.setText("Aucune date de sortie n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Description.equals("")){
            problemValiderFilmLabel.setText("Aucune description n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Note == 0){
            problemValiderFilmLabel.setText("Aucune note n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Acteurs.equals("")){
            problemValiderFilmLabel.setText("Aucun acteur n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Synopsis.equals("")){
            problemValiderFilmLabel.setText("Aucun synopsis n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else{
            double Prix = 0;
            boolean quatreDX = false;
            if(QuatreDX == 0){
                Prix = 10.99;
                quatreDX = false;
            }
            else if(QuatreDX == 1){
                Prix = 24.99;
                quatreDX = true;
            }
            problemValiderFilmLabel.setText("");
            problemValiderFilmLabel.setVisible(false);
            FilmsDAO_IMPL filmDAO = new FilmsDAO_IMPL();
            Film film = new Film(0, Titre, Prix, Date, Photo, Duree, Description, Note, quatreDX, Realisateur, Acteurs, Synopsis);
            filmDAO.ajouterFilm(film);
            ChangementPageListeners.ChangementPage("admin", frame);
        }
    }



    public static void ModifierFilm(FrameBase frame, JLabel problemValiderFilmLabel, int ID, String Photo, String Titre, String Realisateur, Date Date, String Description, String Duree, double Note, String Acteurs, String Synopsis, int QuatreDX){
        if(Titre.equals("")){
            problemValiderFilmLabel.setText("Aucun titre n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Realisateur.equals("")){
            problemValiderFilmLabel.setText("Aucun réalisateur n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Date == null){
            problemValiderFilmLabel.setText("Aucune date de sortie n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Description.equals("")){
            problemValiderFilmLabel.setText("Aucune description n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Note == 0){
            problemValiderFilmLabel.setText("Aucune note n'a été saisie");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Acteurs.equals("")){
            problemValiderFilmLabel.setText("Aucun acteur n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else if(Synopsis.equals("")){
            problemValiderFilmLabel.setText("Aucun synopsis n'a été saisi");
            problemValiderFilmLabel.setVisible(true);
        }
        else{
            double Prix = 0;
            boolean quatreDX = false;
            if(QuatreDX == 0){
                Prix = 10.99;
                quatreDX = false;
            }
            else if(QuatreDX == 1){
                Prix = 24.99;
                quatreDX = true;
            }
            problemValiderFilmLabel.setText("");
            problemValiderFilmLabel.setVisible(false);
            FilmsDAO_IMPL filmDAO = new FilmsDAO_IMPL();
            Film film = new Film(ID, Titre, Prix, Date, Photo, Duree, Description, Note, quatreDX, Realisateur, Acteurs, Synopsis);
            filmDAO.modifierFilm(film);
            ChangementPageListeners.ChangementPage("admin", frame);
        }
    }
}
