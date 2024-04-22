package V.Reservation;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import M.JAVA_MODEL.Global_CLASS.Reservation;

//Imports Librairies
// Importation des librairies
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

public class Recap_Reservation {
    public static void afficherRecapreservation(FrameBase frame){

        frame.PageActuelle = "recap_reservation";
        frame.getPanelBase().removeAll();

        System.out.println("Recap Reservation places résa :");
        for (int i=0; frame.reservationActuelle.get(0).getNumPlaces().size() > i; i++){
            System.out.println(frame.reservationActuelle.get(0).getNumPlaces().get(i));
        }

        //Pannel Résumé de Reservation
        JPanel panelRecapReservation = new JPanel();
        panelRecapReservation.setLayout(null);
        panelRecapReservation.setBackground(frame.getMainCouleur());
        panelRecapReservation.setSize(1000, 800);
        panelRecapReservation.setBounds(350, 100, 1200, 600);
        panelRecapReservation.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));

        //Labels de Résumé
        JLabel TitreFilm = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getNom());
        TitreFilm.setFont(new Font ("Arial", Font.BOLD, 37));
        TitreFilm.setForeground(frame.getSecondeCouleur());
        TitreFilm.setBounds(550, 30, 300, 50);
        panelRecapReservation.add(TitreFilm);
        //Photo du film
        BufferedImage image = ConvertirImageHexa.HexToImage(frame.filmActuel.get(frame.filmActuel.size()-1).getPhoto());
        Image photoFilm = image.getScaledInstance(344, 468, Image.SCALE_SMOOTH);
        ImageIcon Photo = new ImageIcon(photoFilm);
        JLabel PhotoLabel = new JLabel(Photo);
        PhotoLabel.setBounds(60, 60, 344, 468);
        panelRecapReservation.add(PhotoLabel);

        //Icon New
        ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
        New = new ImageIcon(New.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel NewLabel = new JLabel(New);
        NewLabel.setBounds(390, 20, 80, 80);
        //Date dateActuelle = new Date(System.currentTimeMillis()-100*60*60*24*1000);
        Date dateActuelle = new Date(System.currentTimeMillis() - (100L * 24L * 60L * 60L * 1000L));
        if(frame.filmActuel.get(frame.filmActuel.size()-1).getDateSortie().after(dateActuelle)){panelRecapReservation.add(NewLabel);}
        //Nom de notre cinnéma
        JLabel NomCinema = new JLabel("ECE Ciné");
        NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
        NomCinema.setForeground(frame.getSecondeCouleur());
        NomCinema.setBounds(550, 90, 300, 50);
        panelRecapReservation.add(NomCinema);
        //Salle de projection
        JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSalle());
        Salle.setFont(new Font ("Arial", Font.PLAIN, 23));
        Salle.setForeground(frame.getSecondeCouleur());
        Salle.setBounds(550, 140, 300, 50);
        panelRecapReservation.add(Salle);
        //Heure de la séance
        JLabel HeureSeance = new JLabel(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getHeure());
        HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
        HeureSeance.setForeground(frame.getQuatreCouleur());
        HeureSeance.setBounds(950, 30, 400, 50);
        panelRecapReservation.add(HeureSeance);
        //Heure de fin de la séance
        JLabel HeureFinSeance = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getDuree());
        HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
        HeureFinSeance.setForeground(frame.getSecondeCouleur());
        HeureFinSeance.setBounds(950, 90, 300, 50);
        panelRecapReservation.add(HeureFinSeance);
        //4DX
        if(frame.filmActuel.get(frame.filmActuel.size()-1).getQuatreDX()){
            ImageIcon QuatreDX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX.png");
            QuatreDX = new ImageIcon(QuatreDX.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel QuatreDXLabel = new JLabel(QuatreDX);
            QuatreDXLabel.setBounds(950, 140, 40, 40);
            panelRecapReservation.add(QuatreDXLabel);
        }
        //Logo handicapé
        ImageIcon Handicape = null;
        if(frame.DarkMode){Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Blanc.png");}
        else{Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Dark.png");}
        Handicape = new ImageIcon(Handicape.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel HandicapeLabel = new JLabel(Handicape);
        HandicapeLabel.setBounds(950, 200, 50, 50);
        panelRecapReservation.add(HandicapeLabel);

        //Total à payer
        JLabel TotalPayer = new JLabel("Total à payer : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getPrixTotal() + "€");
        TotalPayer.setFont(new Font ("Arial", Font.BOLD, 37));
        TotalPayer.setForeground(frame.getSecondeCouleur());
        TotalPayer.setBounds(550, 300, 600, 50);
        panelRecapReservation.add(TotalPayer);

        //Billets
        JLabel Billets = new JLabel("Billets :");
        Billets.setFont(new Font ("Arial", Font.BOLD, 23));
        Billets.setForeground(frame.getSecondeCouleur());
        Billets.setBounds(550, 350, 300, 50);
        panelRecapReservation.add(Billets);
        
        //Billets Normaux
        JLabel BilletsNormaux = new JLabel("Billets Normaux : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketNormal());
        BilletsNormaux.setFont(new Font ("Arial", Font.PLAIN, 23));
        BilletsNormaux.setForeground(frame.getSecondeCouleur());
        BilletsNormaux.setBounds(550, 400, 300, 50);
        panelRecapReservation.add(BilletsNormaux);
        //Billets Jeunes
        JLabel BilletsJeunes = new JLabel("Billets Jeunes : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketJeune());
        BilletsJeunes.setFont(new Font ("Arial", Font.PLAIN, 23));
        BilletsJeunes.setForeground(frame.getSecondeCouleur());
        BilletsJeunes.setBounds(550, 450, 300, 50);
        panelRecapReservation.add(BilletsJeunes);
        //Billets Ados
        JLabel BilletsAdos = new JLabel("Billets Ados : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketAdo());
        BilletsAdos.setFont(new Font ("Arial", Font.PLAIN, 23));
        BilletsAdos.setForeground(frame.getSecondeCouleur());
        BilletsAdos.setBounds(550, 500, 300, 50);
        panelRecapReservation.add(BilletsAdos);


        //Bouton Ajouter au Panier et Aller au Panier
        JButton boutonAjouterPanier = new JButton("Ajouter et aller au Panier");
        boutonAjouterPanier.setBounds(650, 780, 200, 50);
        boutonAjouterPanier.setFont(new Font("Arial", Font.BOLD, 15));
        boutonAjouterPanier.setBackground(frame.getCinqCouleur());
        boutonAjouterPanier.setForeground(frame.getSecondeCouleur());
        boutonAjouterPanier.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //Action du bouton
        boutonAjouterPanier.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.nombreReservationsPanier++;
                frame.reservationActuelle.add(new Reservation(0, -1, 0, 0, 0));
                frame.RefreshPage();
                //ChangementPageListeners changementPageListeners = new ChangementPageListeners();
                ChangementPageListeners.ChangementPage("panier", frame);
            }
        });

        //Bouton Ajouter au Panier et continuer mes achats
        JButton boutonContinuerAchat = new JButton("Continuer mes achats");
        boutonContinuerAchat.setBounds(1050, 780, 200, 50);
        boutonContinuerAchat.setFont(new Font("Arial", Font.BOLD, 15));
        boutonContinuerAchat.setBackground(frame.getCinqCouleur());
        boutonContinuerAchat.setForeground(frame.getSecondeCouleur());
        boutonContinuerAchat.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //Action du bouton
        boutonContinuerAchat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.nombreReservationsPanier++;
                frame.reservationActuelle.add(new Reservation(0, -1, 0, 0, 0));
                frame.RefreshPage();
                //ChangementPageListeners changementPageListeners = new ChangementPageListeners();
                ChangementPageListeners.ChangementPage("accueil_films", frame);
            }
        });


        frame.getPanelBase().add(panelRecapReservation);
        frame.getPanelBase().add(boutonAjouterPanier);
        frame.getPanelBase().add(boutonContinuerAchat);

        frame.RefreshPage();
    }
        
}
