package V.FilmInfo;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.PageAdmin.RecuperationSeancesByIDFilmListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import V.FrameBase;
import V.Panier.Panier;
import M.JAVA_MODEL.Global_CLASS.Salle;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.Accueil.Films;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import V.FilmInfo.FilmInfo;
import V.Reservation.Reservation_Seance;



//Importation des librairies
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Locale;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import java.awt.image.BufferedImage;


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
import javax.swing.border.LineBorder;



public class DateSéances {
    
    public static boolean sizePage = false;

    private static Panier panier = new Panier();

    private static Film filmSelectionne;

    private static List<Film> filmsAReserver = new ArrayList<>();


    public static void affichageDateSeances(FrameBase frame){
        /*frame.PageActuelle = "date_seance";
        frame.getPanelBase().removeAll();
        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible
        contentPanel.setBackground(frame.getMainCouleur());
        contentPanel.setBounds(0, 0, 500, 5000);

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique*/


        frame.PageActuelle = "date_seance";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);


        JPanel dateSceance = new JPanel();
        dateSceance.setBounds(50, 100, 1800, 770);
        dateSceance.setBackground(frame.getMainCouleur());
        dateSceance.setLayout(null);
        dateSceance.setBorder(bordure);




        JPanel scrollBillets = new JPanel();
        scrollBillets.setBounds(150, 150, 1500, 5000);
        scrollBillets.setBackground(frame.getMainCouleur());
        scrollBillets.setBorder(BorderFactory.createEmptyBorder());
        scrollBillets.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique
        gbc.insets = new Insets(10, 5, 10, 5); // Espacement entre les composants

        List<Seance> seances = RecuperationSeancesByIDFilmListeners.recupSeances(frame, frame.filmActuel.get(frame.filmActuel.size()-1).getIdFilm());

        for (Seance seance : seances){

            JPanel panelFilms = new JPanel();
            panelFilms.setLayout(null);
            panelFilms.setBackground(frame.getMainCouleur());
            panelFilms.setSize(1700, 200);
            panelFilms.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelFilms.setPreferredSize(new Dimension(1700, 200));


            BufferedImage image = ConvertirImageHexa.HexToImage(frame.filmActuel.get(frame.filmActuel.size()-1).getPhoto());
            Image image2 = image.getScaledInstance(132, 180, Image.SCALE_SMOOTH);
            JLabel afficherLabel = new JLabel(new ImageIcon(image2));
            afficherLabel.setBounds(30, 10, 132, 180);
            panelFilms.add(afficherLabel);

            JLabel TitreFilm = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getNom());
            TitreFilm.setFont(font1);
            TitreFilm.setForeground(frame.getSecondeCouleur());
            TitreFilm.setBounds(180, 10, 800, 30);
            panelFilms.add(TitreFilm);

            JLabel DescriptionFilm = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getDescription());
            DescriptionFilm.setFont(font3);
            DescriptionFilm.setForeground(frame.getSecondeCouleur());
            DescriptionFilm.setBounds(180, 40, 500, 30);
            panelFilms.add(DescriptionFilm);

            String dureeFilm = frame.filmActuel.get(frame.filmActuel.size()-1).getDuree();
            String[] parties = dureeFilm.split(":");
            int heures = Integer.parseInt(parties[0]);
            String minutes = parties[1];
            String duree = String.format("%dh%s", heures, minutes);

            JLabel DureeFilm = new JLabel(duree);
            DureeFilm.setFont(font3);
            DureeFilm.setForeground(frame.getSecondeCouleur());
            DureeFilm.setBounds(180, 67, 500, 30);
            panelFilms.add(DureeFilm);

            if(frame.filmActuel.get(frame.filmActuel.size()-1).getQuatreDX() == true){
                ImageIcon Logo4DX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX_2.png");
                Logo4DX = ChangerCouleurImage.changer(frame, Logo4DX);
                Image Logo4DX2 = Logo4DX.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                JLabel logo4DX = new JLabel(new ImageIcon(Logo4DX2));
                logo4DX.setBounds(880, 10, 30, 30);
                panelFilms.add(logo4DX);
            }

            JLabel NumSalle = new JLabel("Salle " + seance.getIdSalle());
            NumSalle.setFont(font2);
            NumSalle.setForeground(frame.getSecondeCouleur());
            NumSalle.setBounds(175, 160, 500, 30);
            panelFilms.add(NumSalle);
        
            ImageIcon LogoDate = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Calendrier.png");
            LogoDate = ChangerCouleurImage.changer(frame, LogoDate);
            Image LogoDate2 = LogoDate.getImage().getScaledInstance(24, 27, Image.SCALE_SMOOTH);
            JLabel logoDate = new JLabel(new ImageIcon(LogoDate2));
            logoDate.setBounds(470, 130, 24, 27);
            panelFilms.add(logoDate);

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
            String dateBillet = sdf.format(seance.getDate());

            JLabel DateBillet = new JLabel(dateBillet);
            DateBillet.setFont(font2);
            DateBillet.setForeground(frame.getSecondeCouleur());
            DateBillet.setBounds(500, 130, 500, 30);
            panelFilms.add(DateBillet);

            ImageIcon LogoHeure = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Horloge.png");
            LogoHeure = ChangerCouleurImage.changer(frame, LogoHeure);
            Image LogoHeure2 = LogoHeure.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
            JLabel logoHeure = new JLabel(new ImageIcon(LogoHeure2));
            logoHeure.setBounds(470, 160, 27, 27);
            panelFilms.add(logoHeure);

            String Heure = seance.getHeure();
            String[] parties2 = Heure.split(":");
            String heure = parties2[0];
            minutes = parties2[1];
            String heureFilm = String.format("%sh%s", heure, minutes);

            JLabel HeureBillet = new JLabel(heureFilm);
            HeureBillet.setFont(font2);
            HeureBillet.setForeground(frame.getSecondeCouleur());
            HeureBillet.setBounds(500, 160, 500, 30);
            panelFilms.add(HeureBillet);


            JLabel placeDispoLabel = new JLabel("Nombre de places disponible : ");
            placeDispoLabel.setBounds(950, 90, 500, 30);
            placeDispoLabel.setForeground(frame.getSecondeCouleur());
            placeDispoLabel.setFont(font3);
            panelFilms.add(placeDispoLabel);

            JLabel placeDispo = new JLabel(Integer.toString(seance.getPlaceDisponible()));
            placeDispo.setBounds(1175, 89, 500, 30);
            placeDispo.setForeground(frame.getSecondeCouleur());
            placeDispo.setFont(font2);
            panelFilms.add(placeDispo);
            
            

            JButton boutonMettreAdmin = new JButton("Réserver cette séance");
            boutonMettreAdmin.addActionListener(e -> {
                frame.seanceActuelle.add(seance);
                Reservation_Seance.affichageReservation_Seance(frame);
            });
            boutonMettreAdmin.setBounds(1300, 80, 250, 40);
            boutonMettreAdmin.setForeground(frame.getSecondeCouleur());
            boutonMettreAdmin.setBackground(frame.getMainCouleur());
            boutonMettreAdmin.setFont(font2);
            panelFilms.add(boutonMettreAdmin);



            scrollBillets.add(panelFilms, gbc);
            gbc.gridy++;
        }
        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(scrollBillets);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        scrollPane.setBounds(50, 1, 1720, 768); // Ajustez la taille selon vos besoins

        dateSceance.add(scrollPane);

        frame.getPanelBase().add(dateSceance);
        frame.RefreshPage();
    }
}
