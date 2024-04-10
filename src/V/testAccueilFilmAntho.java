package V;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class testAccueilFilmAntho extends FrameBase {

    public static void affichagePageConnexion(FrameBase frame) {

        // Coordonées de mes films 
        JPanel connexion = new JPanel();
        connexion.setBounds(-150, 290, 2050, 700);
        connexion.setBackground(frame.getMainCouleur());
        connexion.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);

      
        // Carousel de films
        ArrayList<String> cheminAccesFilms = new ArrayList<>();
        cheminAccesFilms.add("images/images bdd/Fast and Furious 5.jpg");
        cheminAccesFilms.add("images/images bdd/Avengers.jpg");
        cheminAccesFilms.add("images/images bdd/Baywatch - Alerte à Malibu.jpg");
        cheminAccesFilms.add("images/images bdd/OSS 117 Le Caire nid d'espions.jpg");
        cheminAccesFilms.add("images/images bdd/OSS 117 Rio ne répond plus.jpg");
        cheminAccesFilms.add("images/images bdd/OSS 117 Alerte rouge en Afrique noire.jpg");

        JPanel carouselPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        for (String chemin : cheminAccesFilms) {
            try {
                // Charger l'image depuis le chemin
                BufferedImage image = ImageIO.read(new File(chemin));
                // Redimensionner l'image à la taille souhaitée (310x420 pixels)
                Image resizedImage = image.getScaledInstance(310, 420, Image.SCALE_SMOOTH);
                // Créer une icône à partir de l'image redimensionnée
                ImageIcon icon = new ImageIcon(resizedImage);
                // Créer une étiquette pour afficher l'icône dans le carousel
                JLabel imageLabel = new JLabel(icon);
                // Ajouter l'étiquette au panel du carousel
                carouselPanel.add(imageLabel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        carouselPanel.setBounds(150, 100, 2050, 420); // Positionnez le carousel en dessous de la liste des films
        connexion.add(carouselPanel);

        // Autres composants (boutons, étiquettes, etc.)
        // ...

        frame.getPanelBase().setVisible(true);
        frame.getPanelBase().add(connexion);

        frame.RefreshPage();
    }
}


