package V.Reservation;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO; 

//Imports Librairies
// Importation des librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Text;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Reservation_Seance_Place {
    public static ArrayList<Integer> places = new ArrayList<Integer>();
    public static ArrayList<Integer> numplacesReservees = new ArrayList<Integer>();
    public static int numPlacesValidees = 0;
    
    public static void affichageReservation_Seance_Place(FrameBase frame){
        for (int i=0; i<frame.reservationActuelle.getNbTicketNormal(); i++){
            places.add(1);
        }
        for (int i=0; i<frame.reservationActuelle.getNbTicketJeune(); i++){
            places.add(2);
        }
        for (int i=0; i<frame.reservationActuelle.getNbTicketAdo(); i++){
            places.add(3);
        }
        //numPlacesValidees = frame.reservationActuelle.getNombrePlace();
        numPlacesValidees = 3;

        //Résumé Film Reservé
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setLayout(null);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        ResumeSeance.setBounds(80, 60, 300, 800);
        //Labels de Résumé
        JLabel TitreFilm = new JLabel(frame.filmActuel.getNom());
        TitreFilm.setFont(new Font ("Arial", Font.BOLD, 37));
        TitreFilm.setForeground(frame.getSecondeCouleur());
        TitreFilm.setBounds(20, 350, 250, 30);
        ResumeSeance.add(TitreFilm);
        //Icon New
        ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
        New = new ImageIcon(New.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel NewLabel = new JLabel(New);
        NewLabel.setBounds(220, 15, 80, 80);
        ResumeSeance.add(NewLabel);
        /*if(frame.filmActuel.getDateSortie().equals(Date.valueOf("2021-07-14"))){//A corriger ca marche pas
            NewLabel.setVisible(true);
        }else{NewLabel.setVisible(false);}*/
        //Nom de notre cinnéma
        JLabel NomCinema = new JLabel("ECE Ciné");
        NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
        NomCinema.setForeground(frame.getSecondeCouleur());
        NomCinema.setBounds(20, 390, 250, 50);
        ResumeSeance.add(NomCinema);
        //Salle de projection
        JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.getIdSalle());
        Salle.setFont(new Font ("Arial", Font.PLAIN, 23));
        Salle.setForeground(frame.getSecondeCouleur());
        Salle.setBounds(20, 430, 250, 50);
        ResumeSeance.add(Salle);
        //Pannel de séparation
        JPanel Separation = new JPanel();
        Separation.setBackground(frame.getSecondeCouleur());
        Separation.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        Separation.setBounds(20, 510, 250, 4);
        ResumeSeance.add(Separation);
        //Heure de la séance
        JLabel HeureSeance = new JLabel(frame.seanceActuelle.getHeure());
        HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
        HeureSeance.setForeground(frame.getQuatreCouleur());
        HeureSeance.setBounds(20, 550, 400, 50);
        ResumeSeance.add(HeureSeance);
        //Heure de fin de la séance
        JLabel HeureFinSeance = new JLabel(frame.filmActuel.getDuree());
        HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
        HeureFinSeance.setForeground(frame.getSecondeCouleur());
        HeureFinSeance.setBounds(20, 590, 300, 50);
        ResumeSeance.add(HeureFinSeance);
        //4DX
        if(frame.filmActuel.getQuatreDX()){
            ImageIcon QuatreDX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX.png");
            QuatreDX = new ImageIcon(QuatreDX.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel QuatreDXLabel = new JLabel(QuatreDX);
            QuatreDXLabel.setBounds(20, 630, 40, 40);
            ResumeSeance.add(QuatreDXLabel);
        }
        //Logo handicapé
        ImageIcon Handicape = null;
        if(frame.DarkMode){Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Blanc.png");}
        else{Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Dark.png");}
        Handicape = new ImageIcon(Handicape.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel HandicapeLabel = new JLabel(Handicape);
        HandicapeLabel.setBounds(120, 720, 50, 50);
        ResumeSeance.add(HandicapeLabel);

        //Pannel PLaces Grid avec toutes les places
        JPanel PlacesGrid = new JPanel();
        PlacesGrid.setBackground(frame.getMainCouleur());
        PlacesGrid.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PlacesGrid.setLayout(new GridLayout(20, 20, 1, 1));
        PlacesGrid.setBounds(550, 60, 1200, 730);

        //Récupérer les places de cette salle à cette séance avec billets
   
        //List<Billet> billets = recupererBilletsBySeance(frame.seanceActuelle.getIdSeance());
        List<Billet> billets = new ArrayList<Billet>();
        billets.add(new Billet(1, 1, 10, "Normal"));
        billets.add(new Billet(2, 1, 20, "Jeune"));
        billets.add(new Billet(3, 1, 30, "Ado"));


        //Panel affichage des places qui restent à réserver
        JPanel PlacesRestantes = new JPanel();
        PlacesRestantes.setBackground(frame.getMainCouleur());
        PlacesRestantes.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PlacesRestantes.setLayout(null);
        PlacesRestantes.setBounds(800, 800, 330, 50);
        //Label Places restantes
        JLabel PlacesRestantesLabel = new JLabel("Places restantes à réserver :  " + numPlacesValidees);
        PlacesRestantesLabel.setFont(new Font ("Arial", Font.BOLD, 20));
        PlacesRestantesLabel.setForeground(frame.getSecondeCouleur());
        PlacesRestantesLabel.setBounds(20, 2, 330, 50);
        PlacesRestantes.add(PlacesRestantesLabel);

        //Bouton de validation de la réservation
        JButton ValiderReservation = new JButton("Valider la réservation");
        ValiderReservation.setFont(new Font ("Arial", Font.BOLD, 20));
        ValiderReservation.setForeground(frame.getSecondeCouleur());
        ValiderReservation.setBackground(frame.getQuatreCouleur());
        ValiderReservation.setEnabled(false);
        ValiderReservation.setBounds(1180, 800, 250, 50);
        ValiderReservation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(numPlacesValidees == 0){
                    //Ajouter les billets dans la base de données
                    System.out.println("Billets ajoutés (a faire mdr)");
                }
            }
        });

        //Ajout des composants dans le panel
        for(int i=0; i<frame.salleActuelle.getNombrePlace(); i++){
            JButton Place = new JButton();
            //Place.setPreferredSize(new Dimension(50, 50));
            //Place.setBackground(frame.getMainCouleur());
            Place.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
            //vérifier si la place est déjà réservée
            for(Billet billet : billets){
                //System.out.println(billet.getNumeroPlace());
                if(billet.getNumeroPlace() == i+1){
                    Place.setBackground(new Color(197, 80, 82));
                    Place.setEnabled(false);
                    System.out.println("Place réservée");
                }
                else{
                    Place.setBackground(new Color(135, 169, 116));
                    }
            }
            Place.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Place.setBackground(frame.getQuatreCouleur());
                    numplacesReservees.add(Integer.parseInt(Place.getText()));
                    numPlacesValidees--;
                    PlacesRestantesLabel.setText("Places restantes à réserver :  " + numPlacesValidees);
                    if(numPlacesValidees == 0){
                        ValiderReservation.setEnabled(true);
                        PlacesRestantesLabel.setText("Toutes les places ont été réservées");
                        PlacesRestantesLabel.setFont(new Font ("Arial", Font.BOLD, 17));
                    }
                }
            });
            Place.setText(Integer.toString(i+1));
            PlacesGrid.add(Place);
        }

        //Ajout des composants dans le frame
        frame.getPanelBase().add(PlacesRestantes);
        frame.getPanelBase().add(ValiderReservation);
        frame.getPanelBase().add(ResumeSeance);
        frame.getPanelBase().add(PlacesGrid);

        frame.RefreshPage();

    }
    
}
