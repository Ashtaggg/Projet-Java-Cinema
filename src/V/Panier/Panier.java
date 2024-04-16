package V.Panier;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;

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
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.ComponentOrientation;
import java.awt.image.BufferedImage;

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
            System.out.println("Taille de la liste de reservation : " + frame.reservationActuelle.size());
            System.out.println("Reservation n°" + i);
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
            TitreFilm.setBounds(300, 30, 300, 50);
            panelReservation.add(TitreFilm);
            //Photo du film
            BufferedImage image = ConvertirImageHexa.HexToImage(frame.filmActuel.get(frame.filmActuel.size()-1).getPhoto());
            Image photoFilm = image.getScaledInstance(120, 164, Image.SCALE_SMOOTH);
            ImageIcon Photo = new ImageIcon(photoFilm);
            JLabel PhotoLabel = new JLabel(Photo);
            PhotoLabel.setBounds(60, 15, 120, 164);
            panelReservation.add(PhotoLabel);

            //Icon New
            ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
            New = new ImageIcon(New.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            JLabel NewLabel = new JLabel(New);
            NewLabel.setBounds(190, 10, 60, 60);
            panelReservation.add(NewLabel);
            /*if(frame.filmActuel.getDateSortie().equals(Date.valueOf("2021-07-14"))){//A corriger ca marche pas
                NewLabel.setVisible(true);
            }else{NewLabel.setVisible(false);}*/
            //Nom de notre cinnéma
            JLabel NomCinema = new JLabel("ECE Ciné");
            NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
            NomCinema.setForeground(frame.getSecondeCouleur());
            NomCinema.setBounds(300, 90, 300, 50);
            panelReservation.add(NomCinema);
            //Salle de projection
            JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getIdSalle());
            Salle.setFont(new Font ("Arial", Font.PLAIN, 23));
            Salle.setForeground(frame.getSecondeCouleur());
            Salle.setBounds(300, 140, 300, 50);
            panelReservation.add(Salle);
            //Heure de la séance
            JLabel HeureSeance = new JLabel(frame.seanceActuelle.get(frame.seanceActuelle.size()-1).getHeure());
            HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
            HeureSeance.setForeground(frame.getQuatreCouleur());
            HeureSeance.setBounds(500, 30, 400, 50);
            panelReservation.add(HeureSeance);
            //Heure de fin de la séance
            JLabel HeureFinSeance = new JLabel(frame.filmActuel.get(frame.filmActuel.size()-1).getDuree());
            HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
            HeureFinSeance.setForeground(frame.getSecondeCouleur());
            HeureFinSeance.setBounds(500, 90, 300, 50);
            panelReservation.add(HeureFinSeance);
            //4DX
            if(frame.filmActuel.get(frame.filmActuel.size()-1).getQuatreDX()){
                ImageIcon QuatreDX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX.png");
                QuatreDX = new ImageIcon(QuatreDX.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                JLabel QuatreDXLabel = new JLabel(QuatreDX);
                QuatreDXLabel.setBounds(500, 140, 40, 40);
                panelReservation.add(QuatreDXLabel);
            }
            //Logo handicapé
            ImageIcon Handicape = null;
            if(frame.DarkMode){Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Blanc.png");}
            else{Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Dark.png");}
            Handicape = new ImageIcon(Handicape.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            JLabel HandicapeLabel = new JLabel(Handicape);
            HandicapeLabel.setBounds(600, 200, 50, 50);
            panelReservation.add(HandicapeLabel);

            //Total à payer
            JLabel TotalPayer = new JLabel("Total Billet : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getPrixTotal() + "€");
            TotalPayer.setFont(new Font ("Arial", Font.BOLD, 37));
            TotalPayer.setForeground(frame.getSecondeCouleur());
            TotalPayer.setBounds(750, 30, 600, 50);
            panelReservation.add(TotalPayer);


            
            //Billets Normaux
            JLabel BilletsNormaux = new JLabel("Billets Normaux : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketNormal());
            BilletsNormaux.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsNormaux.setForeground(frame.getSecondeCouleur());
            BilletsNormaux.setBounds(750, 90, 300, 30);
            panelReservation.add(BilletsNormaux);
            //Billets Jeunes
            JLabel BilletsJeunes = new JLabel("Billets Jeunes : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketJeune());
            BilletsJeunes.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsJeunes.setForeground(frame.getSecondeCouleur());
            BilletsJeunes.setBounds(750, 120, 300, 30);
            panelReservation.add(BilletsJeunes);
            //Billets Ados
            JLabel BilletsAdos = new JLabel("Billets Ados : " + frame.reservationActuelle.get(frame.reservationActuelle.size()-1).getNbTicketAdo());
            BilletsAdos.setFont(new Font ("Arial", Font.PLAIN, 23));
            BilletsAdos.setForeground(frame.getSecondeCouleur());
            BilletsAdos.setBounds(750, 150, 300, 30);
            panelReservation.add(BilletsAdos);

            JButton SupprimerBillet = new JButton(" ");
            SupprimerBillet.setFont(new Font("Arial", Font.PLAIN, 15));
            SupprimerBillet.setForeground(frame.getMainCouleur());
            SupprimerBillet.setBackground(frame.getMainCouleur());
            SupprimerBillet.setBorder(null);
            SupprimerBillet.setBounds(1060, 150, 50, 30);
            SupprimerBillet.setName(String.valueOf(i));
            //Icon Trash
            ImageIcon Trash = null;
            if(frame.DarkMode){Trash = new ImageIcon("images/Images_Projet_V/Icon_Panier/Trash_Blanc.png");}
            else{Trash = new ImageIcon("images/Images_Projet_V/Icon_Panier/Trash_Dark.png");}
            SupprimerBillet.setIcon(new ImageIcon(Trash.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT)));
            SupprimerBillet.setHorizontalTextPosition(JButton.RIGHT);
            SupprimerBillet.setVerticalTextPosition(JButton.CENTER);
            SupprimerBillet.setIconTextGap(13);

            gbc.gridy++;
            panelReservation.add(SupprimerBillet);

            //ActionListener pour supprimer un billet du panier en fonction de son index
            SupprimerBillet.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = Integer.parseInt(SupprimerBillet.getName());
                    System.out.println("Suppression du billet n°" + index);
                    frame.reservationActuelle.remove(index);
                    //Ne pas Oublier d'enlever les commentaires quand Antho aura fait sa partie 
                    //frame.filmActuel.remove(index);
                    //frame.seanceActuelle.remove(index);
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
        scrollPane.setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        //placer la scroll bar à gauche
        
        // Placer la scrollBar à gauche
        scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        scrollPane.setBounds(90, 100, 1205, 600); // Ajustez la taille selon vos besoins

        //Pannel Total Pannier
        JPanel panelTotalPanier = new JPanel();
        panelTotalPanier.setLayout(null);
        panelTotalPanier.setBackground(frame.getMainCouleur());
        panelTotalPanier.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        panelTotalPanier.setBounds(1410, 110, 420, 310);

        //Total
        JLabel Total = new JLabel("Total : ");
        Total.setFont(new Font("Arial", Font.BOLD, 37));
        Total.setForeground(frame.getSecondeCouleur());
        Total.setBounds(50, 30, 300, 50);
        panelTotalPanier.add(Total);
        //Prix Total
        double prixTotal = 0;
        for (int i = 0; i < frame.reservationActuelle.size(); i++) {
            prixTotal += frame.reservationActuelle.get(i).getPrixTotal();
        }
        JLabel PrixTotal = new JLabel(prixTotal + "€");
        PrixTotal.setFont(new Font("Arial", Font.PLAIN, 37));
        PrixTotal.setForeground(frame.getSecondeCouleur());
        PrixTotal.setBounds(200, 30, 300, 50);
        panelTotalPanier.add(PrixTotal);
        //Bouton Payer
        JButton boutonPayer = new JButton("Valider et Payer");
        boutonPayer.setBounds(50, 120, 300, 50);
        boutonPayer.setFont(new Font("Arial", Font.BOLD, 15));
        boutonPayer.setBackground(frame.getCinqCouleur());
        boutonPayer.setForeground(frame.getSecondeCouleur());
        boutonPayer.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //Action du bouton
        boutonPayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(frame.userActuel == null){
                    Image icon = new ImageIcon("images/Images_Projet_V/Icon_Panier/UserAdd_Dark.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    int choix = JOptionPane.showConfirmDialog(null, "Etes vous sur de ne pas vouloir vous connecter avant de valider votre panier ?", "Connexion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(icon));
                    if(choix == 1){
                        ChangementPageListeners.ChangementPage("connexion", frame);
                    }
                    else{ChangementPageListeners.ChangementPage("payer", frame);}
                }
                else{
                    ChangementPageListeners.ChangementPage("payer", frame);
                }
                
            }
        });
        panelTotalPanier.add(boutonPayer);
        //Bouton Vider Panier
        JButton boutonVider = new JButton("Vider le Panier");
        boutonVider.setBounds(50, 200, 300, 50);
        boutonVider.setFont(new Font("Arial", Font.BOLD, 15));
        boutonVider.setBackground(frame.getMainCouleur());
        boutonVider.setForeground(frame.getSecondeCouleur());
        boutonVider.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 1));
        ImageIcon Poubelle = new ImageIcon("images/Images_Projet_V/Icon_Panier/Trash_Rouge.png");
        boutonVider.setIcon(new ImageIcon(Poubelle.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        boutonVider.setHorizontalTextPosition(JButton.RIGHT);
        boutonVider.setVerticalTextPosition(JButton.CENTER);
        boutonVider.setIconTextGap(13);


        //Action du bouton
        boutonVider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.reservationActuelle.clear();
                frame.filmActuel.clear();
                frame.seanceActuelle.clear();
                affichagePanier(frame);
            }
        });
        panelTotalPanier.add(boutonVider);

        //Panel Connexion
        JPanel panelConnexion = new JPanel();
        panelConnexion.setLayout(null);
        panelConnexion.setBackground(frame.getMainCouleur());
        panelConnexion.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        panelConnexion.setBounds(1410, 450, 420, 230);

        //Connexion Label
        JLabel Connexion = new JLabel("Connexion");
        Connexion.setFont(new Font("Arial", Font.BOLD, 23));
        Connexion.setForeground(frame.getSecondeCouleur());
        Connexion.setBounds(20, 30, 400, 100);
        if (frame.userActuel != null) {
            Connexion.setText("<html>Déjà membre !<br>" +
            "Vous avez fais le bon choix !.<br>.</html>");
            // image d'un emoji heureux
        }
        else {
            Connexion.setText("<html>Vous n'êtes pas connecté !<br>" +
            "Connectez-vous pour profiter de nos offres !</html>");
            //Bouton Connexion
            JButton boutonConnexion = new JButton("Connexion");
            boutonConnexion.setBounds(50, 150, 300, 50);
            boutonConnexion.setFont(new Font("Arial", Font.BOLD, 15));
            boutonConnexion.setBackground(frame.getMainCouleur());
            boutonConnexion.setForeground(frame.getSecondeCouleur());
            //Icon USer Add
            ImageIcon UserAdd = null;
            if(frame.DarkMode){UserAdd = new ImageIcon("images/Images_Projet_V/Icon_Panier/UserAdd_Blanc.png");}
            else{UserAdd = new ImageIcon("images/Images_Projet_V/Icon_Panier/UserAdd_Dark.png");}
            UserAdd = new ImageIcon(UserAdd.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            boutonConnexion.setIcon(UserAdd);
            boutonConnexion.setHorizontalTextPosition(JButton.RIGHT);
            boutonConnexion.setVerticalTextPosition(JButton.CENTER);
            boutonConnexion.setIconTextGap(13);
            //boutonConnexion.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
            //Action du bouton
            boutonConnexion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangementPageListeners.ChangementPage("connexion", frame);
                }
            });
            panelConnexion.add(boutonConnexion);

        }
        panelConnexion.add(Connexion);

        //bouton continuer mes achats
        JButton boutonContinuer = new JButton("Continuer mes achats");
        boutonContinuer.setBounds(88, 705, 200, 30);
        boutonContinuer.setFont(new Font("Arial", Font.BOLD, 15));
        boutonContinuer.setBackground(frame.getMainCouleur());
        boutonContinuer.setForeground(frame.getSecondeCouleur());
        boutonContinuer.setBorder(null);
        ImageIcon Continuer = null;
        if(frame.DarkMode){Continuer = new ImageIcon("images/Images_Projet_V/Icon_Panier/Fleche_Blanc.png");}
        else{Continuer = new ImageIcon("images/Images_Projet_V/Icon_Panier/Fleche_Dark.png");}
        boutonContinuer.setIcon(new ImageIcon(Continuer.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        boutonContinuer.setHorizontalTextPosition(JButton.RIGHT);
        boutonContinuer.setVerticalTextPosition(JButton.CENTER);
        boutonContinuer.setIconTextGap(10);
        //Action du bouton
        boutonContinuer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_films", frame);
            }
        });

        //Pannel footer

        //Footer avec nos conditions de ventes, cooerdonnées et mentions légales + Map

        // Ajouter un footer
        JPanel footer = new JPanel();
        footer.setBackground(frame.getSecondeCouleur());
        footer.setLayout(null);
        footer.setBorder(BorderFactory.createLineBorder(frame.getMainCouleur(), 2));
        footer.setBounds(0, 800, 1903, 160);
        //Conditions de vente
        JLabel ConditionsVente = new JLabel("Conditions de vente");
        ConditionsVente.setFont(new Font ("Arial", Font.PLAIN, 20));
        ConditionsVente.setForeground(frame.getMainCouleur());
        ConditionsVente.setBounds(50, 10, 250, 30);
        footer.add(ConditionsVente);
        //Texte des conditions de vente
        JLabel TexteConditionsVente = new JLabel("<html>Les billets ne sont ni repris, ni échangés.<br><html>");
        TexteConditionsVente.setFont(new Font ("Arial", Font.PLAIN, 14));
        TexteConditionsVente.setForeground(frame.getMainCouleur());
        TexteConditionsVente.setBounds(50, 50, 300, 30);
        footer.add(TexteConditionsVente);

        //Coordonnées
        JLabel Coordonnees = new JLabel("Coordonnées");
        Coordonnees.setFont(new Font ("Arial", Font.PLAIN, 20));
        Coordonnees.setForeground(frame.getMainCouleur());
        Coordonnees.setBounds(500, 10, 250, 30);
        footer.add(Coordonnees);
        //Texte des coordonnées
        JLabel TexteCoordonnees = new JLabel("<html>Adresse : 145 Quai de Grenelle, Paris<br>" +
        "Téléphone : 01 02 03 04 05<br>" +
        "Email : ECECiné@gmail.com</html>");
        TexteCoordonnees.setFont(new Font ("Arial", Font.PLAIN, 14));
        TexteCoordonnees.setForeground(frame.getMainCouleur());
        TexteCoordonnees.setBounds(500, 30, 500, 80);
        footer.add(TexteCoordonnees);
        //Mentions légales
        JLabel MentionsLegales = new JLabel("Mentions légales");
        MentionsLegales.setFont(new Font ("Arial", Font.PLAIN, 20));
        MentionsLegales.setForeground(frame.getMainCouleur());
        MentionsLegales.setBounds(950, 10, 250, 30);
        footer.add(MentionsLegales);
        //Texte des mentions légales
        JLabel TexteMentionsLegales = new JLabel("<html>Ce site a été créé dans le cadre d'un projet scolaire de l'ECE Paris.<br>" +
        "Il n'a pas vocation à être commercialisé et ne génère aucun revenu.<br>" +
        "Les images et logos utilisés sont la propriété de leurs auteurs respectifs.<br>" +
        "Pour toute réclamation, veuillez nous contacter à l'adresse électronique fournie.</html>");
        TexteMentionsLegales.setFont(new Font ("Arial", Font.PLAIN, 13));
        TexteMentionsLegales.setForeground(frame.getMainCouleur());
        TexteMentionsLegales.setBounds(950, 30, 500, 100);
        footer.add(TexteMentionsLegales);
        //Map
        ImageIcon Map = new ImageIcon("images/Images_Projet_V/Map/Map.png");
        Map = new ImageIcon(Map.getImage().getScaledInstance(220, 160, Image.SCALE_DEFAULT));
        JLabel MapLabel = new JLabel(Map);
        MapLabel.setBounds(1620, 10, 220, 160);
        footer.add(MapLabel);


        //Ajouter éléments au panel
        frame.getPanelBase().add(TitrePanier);
        frame.getPanelBase().add(scrollPane);
        frame.getPanelBase().add(panelTotalPanier);
        frame.getPanelBase().add(panelConnexion);
        frame.getPanelBase().add(boutonContinuer);
        frame.getPanelBase().add(footer);

        frame.RefreshPage();
    }
}
