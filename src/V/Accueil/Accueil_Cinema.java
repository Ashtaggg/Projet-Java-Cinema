package V.Accueil;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Salle;

//Importation des librairies
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Date;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import V.FrameBase;
import V.Panier.Panier;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.Global_CLASS.Film;
import java.util.List;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Accueil_Cinema {

    public static void affichageAccueil_Cinema(FrameBase frame){
        frame.PageActuelle = "accueil_cinema";
        frame.getPanelBase().removeAll();
        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible
        contentPanel.setBackground(frame.getMainCouleur());
        contentPanel.setBounds(0, 0, 500, 800);

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique

        //Petit bandeau avec titre Fillms Cinema et News
        JPanel panelTitre = new JPanel();
        panelTitre.setLayout(new GridLayout());
        panelTitre.setBackground(frame.getMainCouleur());
        panelTitre.setPreferredSize(new Dimension(1886, 100));
        panelTitre.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));  
        panelTitre.setBounds(0, 0, 1920, 70);
        contentPanel.add(panelTitre, gbc);

        //Bouton Films
        JButton boutonFilms = new JButton("Nos Films");
        boutonFilms.setFont(new Font("Arial", Font.BOLD, 20));
        boutonFilms.setBackground(frame.getMainCouleur());
        boutonFilms.setForeground(frame.getSecondeCouleur());
        boutonFilms.setBorder(null);
        boutonFilms.setFocusPainted(false);
        ImageIcon IconFilm;
        if(frame.DarkMode){IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Blanc.png");}
        else{IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Dark.png");}
        IconFilm = new ImageIcon(IconFilm.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonFilms.setIcon(IconFilm);
        boutonFilms.setHorizontalTextPosition(JButton.RIGHT);
        boutonFilms.setVerticalTextPosition(JButton.CENTER);
        boutonFilms.setIconTextGap(13);
        //ActionListener
        boutonFilms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_films", frame);
            }
        });

        //Bouton News
        JButton boutonNews = new JButton("Nos News");
        boutonNews.setFont(new Font("Arial", Font.BOLD, 20));
        boutonNews.setBackground(frame.getMainCouleur());
        boutonNews.setForeground(frame.getSecondeCouleur());
        boutonNews.setBorder(null);
        boutonNews.setFocusPainted(false);
        ImageIcon IconNews;
        if(frame.DarkMode){IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Blanc.png");}
        else{IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Dark.png");}
        IconNews = new ImageIcon(IconNews.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonNews.setIcon(IconNews);
        boutonNews.setHorizontalTextPosition(JButton.RIGHT);
        boutonNews.setVerticalTextPosition(JButton.CENTER);
        boutonNews.setIconTextGap(13);
        //ActionListener
        boutonNews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });

        //Bouton Cinema
        JButton boutonCinema = new JButton("Notre Cinema");
        boutonCinema.setFont(new Font("Arial", Font.BOLD, 20));
        boutonCinema.setBackground(frame.getMainCouleur());
        boutonCinema.setForeground(frame.getQuatreCouleur());
        boutonCinema.setBorder(null);
        boutonCinema.setFocusPainted(false);
        ImageIcon IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Selected.png");
        IconCinema = new ImageIcon(IconCinema.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        boutonCinema.setIcon(IconCinema);
        boutonCinema.setHorizontalTextPosition(JButton.RIGHT);
        boutonCinema.setVerticalTextPosition(JButton.CENTER);
        boutonCinema.setIconTextGap(13);

        //Ajout des boutons au panel
        panelTitre.add(boutonFilms);
        panelTitre.add(boutonNews);
        panelTitre.add(boutonCinema);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.ipady = 100;
        contentPanel.add(new JLabel(), gbc);
        gbc.gridy++;
        gbc.ipady = 80;

        FilmsDAO_IMPL filmsDAO = new FilmsDAO_IMPL();
        List<Film> films = filmsDAO.recupererTousLesFilms(); // Méthode pour récupérer tous les films depuis la base de données


        // News 1: Avatar 2
        JPanel panelNews1 = new JPanel();
        panelNews1.setLayout(new FlowLayout());
        panelNews1.setBackground(frame.getMainCouleur());
        panelNews1.setPreferredSize(new Dimension(1200, 250));
        panelNews1.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        panelNews1.setBounds(0, 0, 1020, 200);
        gbc.gridy++;
        contentPanel.add(panelNews1, gbc);

        JLabel avatar2Label = new JLabel();
        ImageIcon avatar2Image = new ImageIcon("images\\images bdd\\Avatar la voie de l'eau.jpg");
        Image image = avatar2Image.getImage().getScaledInstance(155, 210, Image.SCALE_AREA_AVERAGING);
        avatar2Image = new ImageIcon(image);
        JLabel afficherLabel = new JLabel(avatar2Image);
        panelNews1.add(afficherLabel);

        JLabel avatar2Description = new JLabel("<html>Voici le nouveau film en salle disponible dans tous vos cinémas ECE. Profitez-en le monde de James Cameron n'attend que vous !<br>Film également disponible en 4DX.</html>");
        avatar2Description.setFont(new Font("Arial", Font.BOLD, 14));
        avatar2Description.setForeground(frame.getSecondeCouleur());
        panelNews1.add(avatar2Description);


        // News 2: Service de stands
        JPanel panelNews2 = new JPanel();
        panelNews2.setLayout(new BorderLayout());
        panelNews2.setBackground(frame.getMainCouleur());
        panelNews2.setPreferredSize(new Dimension(1200, 200));
        panelNews2.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        gbc.gridy++;
        contentPanel.add(panelNews2, gbc);

        JLabel eceLogoLabel = new JLabel();
        ImageIcon eceLogoImage = new ImageIcon("images\\images_Projet_V\\Icon_ReservationSeance\\New.png"); // Mettez le chemin correct vers le logo ECE Cinéma
        eceLogoLabel.setIcon(eceLogoImage);
        panelNews2.add(eceLogoLabel, BorderLayout.WEST);

        JLabel eceServiceDescription = new JLabel("Les news de la semaine : entre pop corn et bonbons, ECE Cinéma est fière de vous présenter un service de stands disponible dans tous vos cinémas ECE, notre personnel vous attends nombreux et nombreuses !");
        eceServiceDescription.setFont(new Font("Arial", Font.BOLD, 14));
        eceServiceDescription.setForeground(frame.getSecondeCouleur());
        panelNews2.add(eceServiceDescription, BorderLayout.CENTER);

        // News 3: Mois à 3 euros
        JPanel panelNews3 = new JPanel();
        panelNews3.setLayout(new BorderLayout());
        panelNews3.setBackground(frame.getMainCouleur());
        panelNews3.setPreferredSize(new Dimension(1200, 200));
        panelNews3.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        gbc.gridy++;
        contentPanel.add(panelNews3, gbc);

        JLabel eceLogoLabel2 = new JLabel();
        eceLogoLabel2.setIcon(eceLogoImage); // Réutilisez le même logo ECE Cinéma
        panelNews3.add(eceLogoLabel2, BorderLayout.WEST);

        JLabel mois3EurosDescription = new JLabel("<html>D'ici le mois de juillet afin de passer un été ensemble, ECE Cinéma vous offrira la possibilité de venir voir tous vos films à 3 euros seulement tout âge confondus.<br><br>Conditions générales : les films 4DX ne sont pas compris dans l'offre que vous visionnez</html>");
        mois3EurosDescription.setFont(new Font("Arial", Font.BOLD, 14));
        mois3EurosDescription.setForeground(frame.getSecondeCouleur());
        panelNews3.add(mois3EurosDescription, BorderLayout.CENTER);

        gbc.gridy++;
        gbc.ipady = 80;
        contentPanel.add(new JLabel(), gbc);
        



        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        scrollPane.setBorder(null);
        scrollPane.setBounds(0, 0, 1905, 921); // Ajustez la taille selon vos besoins


        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
        
    }
    
}
