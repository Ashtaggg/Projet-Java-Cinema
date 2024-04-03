package V;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import C.MainMathis;
import M.JAVA_MODEL.Global_CLASS.Film;

public class testAffichageMathis {
    JFrame test;

    public testAffichageMathis(){
        this.test = new JFrame("test");
    }

    public void affichage() {
        // Configuration de la fenêtre principale
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setLayout(new BorderLayout());

        // Création du bandeau bleu en haut de la page
        JPanel bandeau = new JPanel();
        bandeau.setBackground(Color.BLUE);
        bandeau.setPreferredSize(new Dimension(1920, 100));
        test.add(bandeau, BorderLayout.NORTH);

        // Ajout de l'image (logo) à gauche du bandeau bleu
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Mathis\\OneDrive\\Bureau\\ECE\\ING3\\S2 ECE\\Info\\Projet Java\\Projet_Git_V2\\Projet-Java-Cinema\\images/Logo.jpeg"); // Remplacez "chemin/vers/votre/logo.png" par le chemin de votre logo
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon(logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT))); // Redimensionner l'image à 100x100 pixels
        bandeau.setLayout(new FlowLayout(FlowLayout.LEFT)); // Aligner l'image à gauche
        bandeau.add(logoLabel, BorderLayout.WEST);

        // Ajout du bouton "Accueil" au milieu de la page
        JButton boutonAccueil = new JButton("Accueil");
        boutonAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(test, "Bouton Accueil appuyé !");
            }
        });
        boutonAccueil.setPreferredSize(new Dimension(80, 80));
        //boutonAccueil.setPreferredSize(new Dimension(150, 50));
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBouton.add(boutonAccueil);
        panelBouton.setOpaque(false); // Permet au bouton de se fondre dans le fond bleu
        bandeau.add(panelBouton, BorderLayout.CENTER);

        // Affichage de la fenêtre
        test.setSize(1920, 1080);
        test.setVisible(true);
    }
}
