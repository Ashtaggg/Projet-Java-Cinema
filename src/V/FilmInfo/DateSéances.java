package V.FilmInfo;

//Importation des fichiers
import C.Listeners.PageAdmin.RecuperationSeancesByIDFilmAndDateListeners;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import V.FrameBase;
import V.Reservation.Reservation_Seance;



//Importation des librairies
import javax.swing.JLabel;

import java.util.List;
import javax.swing.*;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Locale;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import java.awt.image.BufferedImage;

import java.awt.Image;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;



public class DateSéances {
    public static void affichageDateSeances(FrameBase frame){
        frame.PageActuelle = "date_seance";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();


        Font font2 = new Font("Arial", Font.BOLD, 20);

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);


        JPanel dateSceance = new JPanel();
        dateSceance.setBounds(50, 100, 1800, 770);
        dateSceance.setBackground(frame.getMainCouleur());
        dateSceance.setLayout(null);
        dateSceance.setBorder(bordure);

        



        Calendar cal = Calendar.getInstance();
        JDateChooser date = new JDateChooser();
        date.setBounds(125, 30, 300, 40);
        date.setDateFormatString("yyyy-MM-dd");
        JTextField dateEditor = ((JTextField) date.getDateEditor());
        dateEditor.setForeground(frame.getSecondeCouleur());
        dateEditor.setBackground(frame.getMainCouleur());
        date.setDate(cal.getTime());
        date.setFont(font2);
        frame.getPanelBase().add(date);


        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date.getDate());
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        Date[] DatePlus1 = {cal2.getTime()};
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        Date[] DatePlus2 = {cal2.getTime()};
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        Date[] DatePlus3 = {cal2.getTime()};

        JButton boutonDatePlus1 = new JButton(sdf.format(DatePlus1[0]));
        JButton boutonDatePlus2 = new JButton(sdf.format(DatePlus2[0]));
        JButton boutonDatePlus3 = new JButton(sdf.format(DatePlus3[0]));

        date.getDateEditor().addPropertyChangeListener(e -> {
            cal2.setTime(date.getDate());
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            DatePlus1[0] = cal2.getTime();
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            DatePlus2[0] = cal2.getTime();
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            DatePlus3[0] = cal2.getTime();
            boutonDatePlus1.setText(sdf.format(DatePlus1[0]));
            boutonDatePlus2.setText(sdf.format(DatePlus2[0]));
            boutonDatePlus3.setText(sdf.format(DatePlus3[0]));
            affichageDateSeances2(frame, dateSceance, date.getDate());
        });


        boutonDatePlus1.addActionListener(e -> {
            date.setDate(DatePlus1[0]);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            boutonDatePlus1.setText(sdf.format(DatePlus1[0]));
            boutonDatePlus2.setText(sdf.format(DatePlus2[0]));
            boutonDatePlus3.setText(sdf.format(DatePlus3[0]));
        });
        boutonDatePlus1.setBounds(575, 30, 300, 40);
        boutonDatePlus1.setForeground(frame.getSecondeCouleur());
        boutonDatePlus1.setBackground(frame.getMainCouleur());
        boutonDatePlus1.setFont(font2);
        frame.getPanelBase().add(boutonDatePlus1);

        boutonDatePlus2.addActionListener(e -> {
            date.setDate(DatePlus2[0]);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            boutonDatePlus1.setText(sdf.format(DatePlus1[0]));
            boutonDatePlus2.setText(sdf.format(DatePlus2[0]));
            boutonDatePlus3.setText(sdf.format(DatePlus3[0]));
        });
        boutonDatePlus2.setBounds(1025, 30, 300, 40);
        boutonDatePlus2.setForeground(frame.getSecondeCouleur());
        boutonDatePlus2.setBackground(frame.getMainCouleur());
        boutonDatePlus2.setFont(font2);
        frame.getPanelBase().add(boutonDatePlus2);

        boutonDatePlus3.addActionListener(e -> {
            date.setDate(DatePlus3[0]);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            boutonDatePlus1.setText(sdf.format(DatePlus1[0]));
            boutonDatePlus2.setText(sdf.format(DatePlus2[0]));
            boutonDatePlus3.setText(sdf.format(DatePlus3[0]));
        });
        boutonDatePlus3.setBounds(1475, 30, 300, 40);
        boutonDatePlus3.setForeground(frame.getSecondeCouleur());
        boutonDatePlus3.setBackground(frame.getMainCouleur());
        boutonDatePlus3.setFont(font2);
        frame.getPanelBase().add(boutonDatePlus3);


        affichageDateSeances2(frame, dateSceance, date.getDate());

        frame.getPanelBase().add(dateSceance);
        frame.RefreshPage();
    }

    public static void affichageDateSeances2(FrameBase frame, JPanel dateSceance, Date dateSelec){
        frame.PageActuelle = "date_seance";

        dateSceance.removeAll();


        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);

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

        List<Seance> seances = RecuperationSeancesByIDFilmAndDateListeners.recupSeances(frame, frame.filmActuel.get(frame.filmActuel.size()-1).getIdFilm(), dateSelec);

        if(seances.isEmpty()){
            JLabel Label = new JLabel("Aucune séance prévue à ce jour");
            Label.setBounds(675, 365, 459, 40);
            Label.setForeground(frame.getSecondeCouleur());
            Label.setFont(font1);
            dateSceance.add(Label);
        }

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
                logo4DX.setBounds(215 + TitreFilm.getPreferredSize().width, 9, 30, 30);
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


            JLabel placeDispoLabel = new JLabel("Nombre de places disponibles : ");
            placeDispoLabel.setBounds(940, 90, 500, 30);
            placeDispoLabel.setForeground(frame.getSecondeCouleur());
            placeDispoLabel.setFont(font3);
            panelFilms.add(placeDispoLabel);

            JLabel placeDispo = new JLabel(Integer.toString(seance.getPlaceDisponible()));
            placeDispo.setBounds(1175, 89, 500, 30);
            placeDispo.setForeground(frame.getSecondeCouleur());
            placeDispo.setFont(font2);
            panelFilms.add(placeDispo);
            
            
            JButton boutonChoisir = new JButton("Réserver cette séance");
            boutonChoisir.addActionListener(e -> {
                frame.seanceActuelle.add(seance);
                frame.reservationActuelle.get(frame.reservationActuelle.size()-1).setIdSeance(seance.getIdSeance());
                frame.salleActuelle.add(frame.sallesDAO.recupererSalleByID(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSalle()));
                Reservation_Seance.affichageReservation_Seance(frame);
            });
            boutonChoisir.setBounds(1300, 80, 250, 40);
            boutonChoisir.setForeground(frame.getSecondeCouleur());
            boutonChoisir.setBackground(frame.getMainCouleur());
            boutonChoisir.setFont(font2);
            panelFilms.add(boutonChoisir);



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

        frame.RefreshPage();
    }
}
