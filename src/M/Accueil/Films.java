package M.Accueil;

import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Films {

    private String affiche; // Chemin de l'image de l'affiche du film

    // Constructeur de la classe Film
    public Films (String affiche) {
        // Initialisation des autres attributs
        this.affiche = affiche;
    }

    // Méthode pour récupérer le chemin de l'image de l'affiche du film
    public String getAffiche() {
        return affiche;
    }     
    
}
