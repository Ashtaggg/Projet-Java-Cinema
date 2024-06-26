package V.Reservation;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Billet;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;

//Imports Librairies
// Importation des librairies
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.Date;


public class Reservation_Seance_Place {

    public static ArrayList<Integer> numplacesReservees = new ArrayList<Integer>();
    public static int numPlacesValidees = 0;
    
    public static void affichageReservation_Seance_Place(FrameBase frame){

        frame.PageActuelle = "reservation_seance_place";

        //Remove
        frame.getPanelBase().removeAll();
        frame.getPanelBase().revalidate();
        frame.getPanelBase().repaint();

        int sizeLR = frame.reservationActuelle.size();
        numPlacesValidees = frame.reservationActuelle.get(sizeLR-1).getNombrePlace();
        numplacesReservees.removeAll(numplacesReservees);

        //Résumé Film Reservé
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setLayout(null);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        ResumeSeance.setBounds(80, 60, 300, 800);
        //Labels de Résumé
        JLabel TitreFilm = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getNom());
        TitreFilm.setFont(new Font ("Arial", Font.BOLD, 37));
        TitreFilm.setForeground(frame.getSecondeCouleur());
        TitreFilm.setBounds(20, 350, 250, 30);
        ResumeSeance.add(TitreFilm);
        //Photo du film
        BufferedImage image = ConvertirImageHexa.HexToImage(frame.filmActuel.get(frame.filmActuel.size()-1).getPhoto());
        Image photoFilm = image.getScaledInstance(172, 234, Image.SCALE_SMOOTH);
        ImageIcon Photo = new ImageIcon(photoFilm);
        JLabel PhotoLabel = new JLabel(Photo);
        PhotoLabel.setBounds(55, 70, 172, 234);
        ResumeSeance.add(PhotoLabel);

        //Icon New
        ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
        New = new ImageIcon(New.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel NewLabel = new JLabel(New);
        NewLabel.setBounds(220, 15, 80, 80);
        //Date après le aujourdhui - 100 jours
        //Date dateActuelle = new Date(System.currentTimeMillis()-100*60*60*24*1000);
        Date dateActuelle = new Date(System.currentTimeMillis() - (100L * 24L * 60L * 60L * 1000L));
        if(frame.filmActuel.get(frame.filmActuel.size()-1).getDateSortie().after(dateActuelle)){ResumeSeance.add(NewLabel);}
        //Nom de notre cinnéma
        JLabel NomCinema = new JLabel("ECE Ciné");
        NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
        NomCinema.setForeground(frame.getSecondeCouleur());
        NomCinema.setBounds(20, 390, 250, 50);
        ResumeSeance.add(NomCinema);
        //Salle de projection
        JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSalle());
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
        JLabel HeureSeance = new JLabel(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getHeure());
        HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
        HeureSeance.setForeground(frame.getQuatreCouleur());
        HeureSeance.setBounds(20, 550, 400, 50);
        ResumeSeance.add(HeureSeance);
        //Heure de fin de la séance
        JLabel HeureFinSeance = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getDuree());
        HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
        HeureFinSeance.setForeground(frame.getSecondeCouleur());
        HeureFinSeance.setBounds(20, 590, 300, 50);
        ResumeSeance.add(HeureFinSeance);
        //4DX
        if(frame.filmActuel.get(frame.filmActuel.size()-1).getQuatreDX()){
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

        //Pannel de schéma Salle
        JPanel SchemaSalle = new JPanel();
        SchemaSalle.setBackground(frame.getMainCouleur());
        SchemaSalle.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        SchemaSalle.setLayout(null);
        SchemaSalle.setBounds(550, 60, 1204, 734);


        //Pannel PLaces Grid avec toutes les places
        JPanel PlacesGrid = new JPanel();
        PlacesGrid.setBackground(frame.getMainCouleur());
        PlacesGrid.setBorder(null);
        int size = (int) Math.sqrt(frame.salleActuelle.get(frame.salleActuelle.size()-1).getNombrePlace());
        PlacesGrid.setLayout(new GridLayout( size, size , 3, 3));
        PlacesGrid.setBounds(6, 2, 1190, 660);

        //Récupérer les places de cette salle à cette séance avec billets
   
        List<Billet> billets = frame.billetDAO.recupererBilletsBySeance(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSeance());

        //Panels dessin Ecran 
        JPanel Ecran = new JPanel();
        Ecran.setBackground(Color.DARK_GRAY);
        Ecran.setBorder(BorderFactory.createLineBorder((Color.DARK_GRAY), 2));
        Ecran.setLayout(null);
        Ecran.setBounds(200, 710, 800, 12);

        
        //Panel affichage des places qui restent à réserver
        JPanel PlacesRestantes = new JPanel();
        PlacesRestantes.setBackground(frame.getMainCouleur());
        PlacesRestantes.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PlacesRestantes.setLayout(null);
        PlacesRestantes.setBounds(820, 810, 330, 50);
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
        ValiderReservation.setBounds(1200, 810, 250, 50);
        ValiderReservation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(numPlacesValidees == 0){
                    for(int j=0; j<numplacesReservees.size(); j++){
                        System.out.println(numplacesReservees.get(j));
                    }
                    frame.reservationActuelle.get(frame.reservationActuelle.size()-1).setNumPlaces(numplacesReservees);
                    ChangementPageListeners.ChangementPage("recap_reservation", frame);
                }
            }
        });

        //Ajout des composants dans le panel
        for(int i=0; i<frame.salleActuelle.get(frame.salleActuelle.size()-1).getNombrePlace(); i++){
            JButton Place = new JButton();
            Place.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));

            // Par défaut, la couleur est verte
            Place.setBackground(new Color(135, 169, 116));

            // Vérifier si la place est déjà réservée
            for (Billet billet : billets) {
                if (billet.getNumeroPlace() == i + 1) {
                    // Si la place est réservée, changer la couleur en rouge
                    Place.setBackground(new Color(197, 80, 82));
                    Place.setEnabled(false);
                    System.out.println("Place "+ (i+1) +" déjà réservée");
                    break; // Sortir de la boucle car la place est déjà réservée
                }
            }
            Place.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(Place.getBackground().equals(new Color(135, 169, 116))){
                        if(numPlacesValidees > 0){
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
                    }
                    else{
                        Place.setBackground(new Color(135, 169, 116));
                        for(int i=0; i<numplacesReservees.size(); i++){
                            if(numplacesReservees.get(i) == Integer.parseInt(Place.getText())){
                                numplacesReservees.remove(i);
                            }
                        }
                        numPlacesValidees++;
                        PlacesRestantesLabel.setText("Places restantes à réserver :  " + numPlacesValidees);
                        ValiderReservation.setEnabled(false);
                        PlacesRestantesLabel.setFont(new Font ("Arial", Font.BOLD, 20));
                    }
                    }
                }
            );
            Place.setText(Integer.toString(i+1));
        PlacesGrid.add(Place);
        }

        //Bouton Annuler 
        JButton Annuler = new JButton("Annuler");
        Annuler.setFont(new Font ("Arial", Font.BOLD, 18));
        Annuler.setForeground(frame.getSecondeCouleur());
        Annuler.setBackground(new Color(197, 80, 82));
        Annuler.setBounds(1630, 810, 120, 50);
        Annuler.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numplacesReservees.removeAll(numplacesReservees);
                Reservation_Seance_Place.affichageReservation_Seance_Place(frame);
            }
        });

        //Ajout des composants dans le frame
        SchemaSalle.add(PlacesGrid);
        SchemaSalle.add(Ecran);
        frame.getPanelBase().add(PlacesRestantes);
        frame.getPanelBase().add(ValiderReservation);
        frame.getPanelBase().add(ResumeSeance);
        frame.getPanelBase().add(Annuler);
        frame.getPanelBase().add(SchemaSalle);

        frame.RefreshPage();

    }
    
}
