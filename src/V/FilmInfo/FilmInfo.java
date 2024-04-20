package V.FilmInfo;

import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;

import javax.swing.*;
import java.awt.*;

public class FilmInfo {

    // Méthode pour afficher les informations du film dans FilmInfo
    public static void afficherFilmInfo(FrameBase frame, Film film) {
        // Créer un nouveau JPanel pour afficher les informations du film
        JPanel panelFilmInfo = new JPanel();
        panelFilmInfo.setLayout(new BorderLayout());
        panelFilmInfo.setBackground(frame.getMainCouleur());

        // Ajouter des JLabel pour afficher les détails du film
        JLabel titreLabel = new JLabel(film.getNom());
        titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titreLabel.setForeground(frame.getSecondeCouleur());
        panelFilmInfo.add(titreLabel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel(film.getDescription());
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setForeground(frame.getSecondeCouleur());
        panelFilmInfo.add(descriptionLabel, BorderLayout.CENTER);

        // Ajouter l'image du film s'il est disponible
        if (film.getPhoto() != null && !film.getPhoto().isEmpty()) {
            JLabel afficherLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(film.getPhoto()); // Utilisez le chemin de l'image du film
            afficherLabel.setIcon(imageIcon);
            panelFilmInfo.add(afficherLabel, BorderLayout.WEST);
        }

        // Ajouter le panelFilmInfo à votre frame
        frame.getPanelBase().add(panelFilmInfo, BorderLayout.CENTER);
    }
}
