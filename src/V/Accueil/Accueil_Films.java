package V.Accueil;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
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
import java.awt.List;
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

public class Accueil_Films {
    public static void affichageAccueil_Films(FrameBase frame){
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
        boutonFilms.setForeground(frame.getQuatreCouleur());
        boutonFilms.setBorder(null);
        boutonFilms.setFocusPainted(false);
        ImageIcon IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Selected.png");
        IconFilm = new ImageIcon(IconFilm.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonFilms.setIcon(IconFilm);
        boutonFilms.setHorizontalTextPosition(JButton.RIGHT);
        boutonFilms.setVerticalTextPosition(JButton.CENTER);
        boutonFilms.setIconTextGap(13);

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
        boutonCinema.setForeground(frame.getSecondeCouleur());
        boutonCinema.setBorder(null);
        boutonCinema.setFocusPainted(false);
        ImageIcon IconCinema = null;
        if(frame.DarkMode){IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Blanc.png");}
        else{IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Dark.png");}
        IconCinema = new ImageIcon(IconCinema.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        boutonCinema.setIcon(IconCinema);
        boutonCinema.setHorizontalTextPosition(JButton.RIGHT);
        boutonCinema.setVerticalTextPosition(JButton.CENTER);
        boutonCinema.setIconTextGap(13);
        //ActionListener
        boutonCinema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_cinema", frame);
            }
        });

        //Ajout des boutons au panel
        panelTitre.add(boutonFilms);
        panelTitre.add(boutonNews);
        panelTitre.add(boutonCinema);

        //Affichage ici

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.ipady = 100;
        contentPanel.add(new JLabel(), gbc);

                
        for(int i=0; i<=10; i++){
            // Créer un JPanel pour chaque film
            JPanel panelFilm = new JPanel();
            panelFilm.setLayout(null);
            panelFilm.setBackground(frame.getMainCouleur());
            panelFilm.setPreferredSize(new Dimension(886, 200));
            panelFilm.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelFilm.setBounds(0, 0, 1020, 200);
            gbc.gridy++;
            contentPanel.add(panelFilm, gbc);

            // Créer un JLabel pour le titre du film
            JLabel titreFilm = new JLabel("Titre du film");
            titreFilm.setFont(new Font("Arial", Font.BOLD, 20));
            titreFilm.setForeground(frame.getSecondeCouleur());
            titreFilm.setBounds(20, 20, 500, 50);
            panelFilm.add(titreFilm);

            // Créer un JLabel pour la date de sortie du film
            JLabel dateSortie = new JLabel("Date de sortie : 01/01/2021");
            dateSortie.setFont(new Font("Arial", Font.PLAIN, 15));
            dateSortie.setForeground(frame.getSecondeCouleur());
            dateSortie.setBounds(20, 70, 500, 50);
            panelFilm.add(dateSortie);

            // Créer un JLabel pour la durée du film
            JLabel dureeFilm = new JLabel("Durée : 2h30");
            dureeFilm.setFont(new Font("Arial", Font.PLAIN, 15));
            dureeFilm.setForeground(frame.getSecondeCouleur());
            dureeFilm.setBounds(20, 120, 500, 50);
            panelFilm.add(dureeFilm);

            // Créer un JLabel pour le réalisateur du film
            JLabel realisateurFilm = new JLabel("Réalisateur : Quentin Tarantino");
            realisateurFilm.setFont(new Font("Arial", Font.PLAIN, 15));
            realisateurFilm.setForeground(frame.getSecondeCouleur());
            realisateurFilm.setBounds(20, 170, 500, 50);
            panelFilm.add(realisateurFilm);

            // Créer un JButton pour réserver le film
            JButton boutonReserver = new JButton("Réserver");
            boutonReserver.setFont(new Font("Arial", Font.BOLD, 15));
            boutonReserver.setBackground(frame.getCinqCouleur());
            boutonReserver.setForeground(frame.getSecondeCouleur());
            boutonReserver.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
            boutonReserver.setBounds(600, 65, 150, 50);
            panelFilm.add(boutonReserver);

            // Créer un JButton pour voir les séances du film
            JButton boutonSeances = new JButton("Voir les séances");
            boutonSeances.setFont(new Font("Arial", Font.BOLD, 15));
            boutonSeances.setBackground(frame.getCinqCouleur());
            boutonSeances.setForeground(frame.getSecondeCouleur());
            boutonSeances.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
            boutonSeances.setBounds(600, 185, 150, 50);
            panelFilm.add(boutonSeances);
            gbc.gridy++;
            gbc.ipady = 20;
            contentPanel.add(new JLabel(), gbc);

        }


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
