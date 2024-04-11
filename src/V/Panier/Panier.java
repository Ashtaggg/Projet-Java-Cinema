package V.Panier;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;

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

public class Panier {

    //Variables

    public static void affichagePanier(FrameBase frame) {

        frame.PageActuelle = "panier";
        frame.getPanelBase().removeAll();

        //Titre Panier
        JLabel TitrePanier = new JLabel("Récapitulatif de mon panier");
        TitrePanier.setFont(new Font("Arial", Font.BOLD, 37));
        TitrePanier.setForeground(frame.getSecondeCouleur());
        TitrePanier.setBounds(750, 30, 500, 50);

        //Scroll Panier Reservation
        JPanel scrollPanier = new JPanel();
        scrollPanier.setBounds(0, 0, 1200, 5000);
        scrollPanier.setBackground(frame.getMainCouleur());
        scrollPanier.setBorder(BorderFactory.createEmptyBorder());
        scrollPanier.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants

        //Boucle pour afficher reservation actuelles dans le panier
        for (int i = 0; i < frame.reservationActuelle.size(); i++) {
            //Panel pour chaque reservation
            JPanel panelReservation = new JPanel();
            panelReservation.setLayout(null);
            panelReservation.setBackground(frame.getMainCouleur());
            panelReservation.setSize(1000, 200);
            panelReservation.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelReservation.setPreferredSize(new Dimension(1150, 200));

            //Labels de Résumé
            JLabel TitreFilm = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getNom());
            TitreFilm.setFont(new Font ("Arial", Font.BOLD, 37));
            TitreFilm.setForeground(frame.getSecondeCouleur());
            TitreFilm.setBounds(310, 30, 300, 50);
            panelReservation.add(TitreFilm);
            //Icon New
            ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
            New = new ImageIcon(New.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
            JLabel NewLabel = new JLabel(New);
            NewLabel.setBounds(190, 20, 80, 80);
            panelReservation.add(NewLabel);
            /*if(frame.filmActuel.getDateSortie().equals(Date.valueOf("2021-07-14"))){//A corriger ca marche pas
                NewLabel.setVisible(true);
            }else{NewLabel.setVisible(false);}*/
            //Nom de notre cinnéma
            JLabel NomCinema = new JLabel("ECE Ciné");
            NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
            NomCinema.setForeground(frame.getSecondeCouleur());
            NomCinema.setBounds(310, 90, 300, 50);
            panelReservation.add(NomCinema);
            //Salle de projection
            JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSalle());
            Salle.setFont(new Font ("Arial", Font.PLAIN, 23));
            Salle.setForeground(frame.getSecondeCouleur());
            Salle.setBounds(310, 140, 300, 50);
            panelReservation.add(Salle);
            //Heure de la séance
            JLabel HeureSeance = new JLabel(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getHeure());
            HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
            HeureSeance.setForeground(frame.getQuatreCouleur());
            HeureSeance.setBounds(610, 30, 400, 50);
            panelReservation.add(HeureSeance);
            //Heure de fin de la séance
            JLabel HeureFinSeance = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getDuree());
            HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
            HeureFinSeance.setForeground(frame.getSecondeCouleur());
            HeureFinSeance.setBounds(610, 90, 300, 50);
            panelReservation.add(HeureFinSeance);
            //4DX
            if(frame.filmActuel.get(frame.filmActuel.size()-1).getQuatreDX()){
                ImageIcon QuatreDX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX.png");
                QuatreDX = new ImageIcon(QuatreDX.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                JLabel QuatreDXLabel = new JLabel(QuatreDX);
                QuatreDXLabel.setBounds(610, 140, 40, 40);
                panelReservation.add(QuatreDXLabel);
            }
            //Logo handicapé
            ImageIcon Handicape = null;
            if(frame.DarkMode){Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Blanc.png");}
            else{Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Dark.png");}
            Handicape = new ImageIcon(Handicape.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            JLabel HandicapeLabel = new JLabel(Handicape);
            HandicapeLabel.setBounds(610, 200, 50, 50);
            panelReservation.add(HandicapeLabel);

            //Total à payer
            JLabel TotalPayer = new JLabel("Total à payer : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getPrixTotal() + "€");
            TotalPayer.setFont(new Font ("Arial", Font.BOLD, 37));
            TotalPayer.setForeground(frame.getSecondeCouleur());
            TotalPayer.setBounds(760, 30, 600, 50);
            panelReservation.add(TotalPayer);


            
            //Billets Normaux
            JLabel BilletsNormaux = new JLabel("Billets Normaux : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketNormal());
            BilletsNormaux.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsNormaux.setForeground(frame.getSecondeCouleur());
            BilletsNormaux.setBounds(760, 90, 300, 30);
            panelReservation.add(BilletsNormaux);
            //Billets Jeunes
            JLabel BilletsJeunes = new JLabel("Billets Jeunes : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketJeune());
            BilletsJeunes.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsJeunes.setForeground(frame.getSecondeCouleur());
            BilletsJeunes.setBounds(760, 120, 300, 30);
            panelReservation.add(BilletsJeunes);
            //Billets Ados
            JLabel BilletsAdos = new JLabel("Billets Ados : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketAdo());
            BilletsAdos.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsAdos.setForeground(frame.getSecondeCouleur());
            BilletsAdos.setBounds(760, 150, 300, 30);
            panelReservation.add(BilletsAdos);

            JButton SupprimerBillet = new JButton("Supprimer");
            SupprimerBillet.setFont(new Font("Arial", Font.PLAIN, 15));
            SupprimerBillet.setForeground(frame.getMainCouleur());
            SupprimerBillet.setBackground(frame.getSecondeCouleur());
            SupprimerBillet.setBorder(new RoundBorder(frame.getMainCouleur(), 20, 2));
            SupprimerBillet.setBounds(1000, 150, 100, 30);
            SupprimerBillet.setName(String.valueOf(i));

            gbc.gridy++;
            panelReservation.add(SupprimerBillet);

            //ActionListener pour supprimer un billet du panier en fonction de son index
            SupprimerBillet.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = Integer.parseInt(SupprimerBillet.getName());
                    frame.reservationActuelle.remove(index);
                    frame.filmActuel.remove(index);
                    frame.seanceActuelle.remove(index);
                    affichagePanier(frame);
                }
            });

            //Ajout du panel de reservation au panel de scroll
            scrollPanier.add(panelReservation, gbc);

            gbc.gridy++;
        }

        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(scrollPanier);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        scrollPane.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //placer la scroll bar à gauche
        scrollPane.setBounds(90, 110, 1205, 600); // Ajustez la taille selon vos besoins


        //Ajouter éléments au panel
        frame.getPanelBase().add(TitrePanier);
        frame.getPanelBase().add(scrollPane);


        frame.RefreshPage();

    }
}
