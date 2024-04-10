package V.Reservation;

// Importation des fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Seance;
import C.Listeners.Page_ReservationSeance.ReservationSeanceListeners;

// Importation des librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Text;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
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




public class Reservation_Seance {

    public static int nbTicketNormal = 0;
    public static int nbTicketJeune = 0;
    public static int nbTicketAdo = 0;

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
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
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants
        for (int i = 1; i <= 30; i++) {
            JLabel label = new JLabel(" ");
            contentPanel.add(label, gbc);
            gbc.gridy++; // Passer à la prochaine ligne
        }

        //Résumé Film Reservé
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setLayout(null);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //Labels de Résumé
        JLabel TitreFilm = new JLabel(frame.filmActuel.getNom());
        TitreFilm.setFont(new Font ("Arial", Font.BOLD, 37));
        TitreFilm.setForeground(frame.getSecondeCouleur());
        TitreFilm.setBounds(350, 30, 300, 50);
        ResumeSeance.add(TitreFilm);
        //Icon New
        ImageIcon New = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/New.png");
        New = new ImageIcon(New.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        JLabel NewLabel = new JLabel(New);
        NewLabel.setBounds(1070, 0, 80, 80);
        ResumeSeance.add(NewLabel);
        /*if(frame.filmActuel.getDateSortie().equals(Date.valueOf("2021-07-14"))){//A corriger ca marche pas
            NewLabel.setVisible(true);
        }else{NewLabel.setVisible(false);}*/
        //Nom de notre cinnéma
        JLabel NomCinema = new JLabel("ECE Ciné");
        NomCinema.setFont(new Font ("Arial", Font.PLAIN, 23));
        NomCinema.setForeground(frame.getSecondeCouleur());
        NomCinema.setBounds(350, 90, 300, 50);
        ResumeSeance.add(NomCinema);
        //Salle de projection
        JLabel Salle = new JLabel("Salle " + frame.seanceActuelle.getIdSalle());
        Salle.setFont(new Font ("Arial", Font.PLAIN, 23));
        Salle.setForeground(frame.getSecondeCouleur());
        Salle.setBounds(350, 140, 300, 50);
        ResumeSeance.add(Salle);
        //Heure de la séance
        JLabel HeureSeance = new JLabel(frame.seanceActuelle.getHeure());
        HeureSeance.setFont(new Font ("Arial", Font.BOLD, 37));
        HeureSeance.setForeground(frame.getQuatreCouleur());
        HeureSeance.setBounds(750, 30, 400, 50);
        ResumeSeance.add(HeureSeance);
        //Heure de fin de la séance
        JLabel HeureFinSeance = new JLabel(frame.filmActuel.getDuree());
        HeureFinSeance.setFont(new Font ("Arial", Font.PLAIN, 23));
        HeureFinSeance.setForeground(frame.getSecondeCouleur());
        HeureFinSeance.setBounds(750, 90, 300, 50);
        ResumeSeance.add(HeureFinSeance);
        //4DX
        if(frame.filmActuel.getQuatreDX()!=0){
            ImageIcon QuatreDX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX.png");
            QuatreDX = new ImageIcon(QuatreDX.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            JLabel QuatreDXLabel = new JLabel(QuatreDX);
            QuatreDXLabel.setBounds(750, 140, 40, 40);
            ResumeSeance.add(QuatreDXLabel);
        }
        //Logo handicapé
        ImageIcon Handicape = null;
        if(frame.DarkMode){Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Blanc.png");}
        else{Handicape = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Disabled_Dark.png");}
        Handicape = new ImageIcon(Handicape.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel HandicapeLabel = new JLabel(Handicape);
        HandicapeLabel.setBounds(750, 200, 50, 50);
        ResumeSeance.add(HandicapeLabel);


        // Ajouter ResumeSeance avec GridBagLayout
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 1150; // Largeur spécifique
        gbc.ipady = 300; // Hauteur spécifique
        contentPanel.add(ResumeSeance, gbc);

        //Panel sans bordure pour contenir texte tarifs
        JPanel TarifPanel = new JPanel();
        TarifPanel.setBackground(frame.getMainCouleur());
        TarifPanel.setLayout(null);
        TarifPanel.setBorder(null);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipady = 50; // Hauteur spécifique
        contentPanel.add(TarifPanel, gbc);

        //texte "Tarifs" au dessus de la barre de séparation
        ImageIcon Billet = null;
        if(frame.DarkMode){Billet = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Ticket_Blanc.png");}
        else{Billet = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Ticket_Dark.png");}
        JLabel Tarifs = new JLabel("Tarifs  ");
        Tarifs.setFont(new Font ("Arial", Font.BOLD, 40));
        Tarifs.setForeground(frame.getSecondeCouleur());
        Tarifs.setIcon(new ImageIcon(Billet.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        Tarifs.setHorizontalTextPosition(JLabel.LEFT);
        Tarifs.setVerticalTextPosition(JLabel.CENTER);
        Tarifs.setBounds(500, 0, 200, 50);
        TarifPanel.add(Tarifs);

        gbc.gridy = 7; // Revenir à la ligne suivante
        gbc.ipadx = 950; // Largeur spécifique
        gbc.ipady = 50; // Hauteur spécifique
        //Tracer une ligne pour séparer les composants
        JLabel separator = new JLabel(" ");
        separator.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, frame.getTroisCouleur()));
        contentPanel.add(separator, gbc);

        //Nouveau panel pour les tarifs
        JPanel PanelTarifs = new JPanel();
        PanelTarifs.setBackground(frame.getMainCouleur());
        PanelTarifs.setLayout(null);
        PanelTarifs.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //TextField pour le code promo
        JTextField CodePromoTXT = new JTextField();
        CodePromoTXT.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        CodePromoTXT.setBounds(310, 40, 250, 50);
        CodePromoTXT.setOpaque(false);
        CodePromoTXT.setForeground(frame.getSecondeCouleur());
        CodePromoTXT.setText("Code Promo");
        CodePromoTXT.setForeground(frame.getSecondeCouleur());
        CodePromoTXT.setFont(new Font ("Arial", Font.PLAIN, 23));
        PanelTarifs.add(CodePromoTXT);
        //Bouton d'ajou du code promo
        ImageIcon AjoutPromo = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/Promo_Dark.png");
        AjoutPromo = new ImageIcon(AjoutPromo.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton AjoutPromoButton = new JButton("Ajouter  ", AjoutPromo);
        AjoutPromoButton.setHorizontalTextPosition(JButton.LEFT);
        AjoutPromoButton.setVerticalTextPosition(JButton.CENTER);
        AjoutPromoButton.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        AjoutPromoButton.setForeground(frame.getSecondeCouleur());
        AjoutPromoButton.setBackground(frame.getCinqCouleur());
        AjoutPromoButton.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        AjoutPromoButton.setFont(new Font ("Arial", Font.PLAIN, 23));
        AjoutPromoButton.setBounds(590, 40, 250, 50);
        PanelTarifs.add(AjoutPromoButton);

        //Label pour le tarif normal
        JLabel TarifNormal = new JLabel("Tarif Normal");
        TarifNormal.setFont(new Font ("Arial", Font.PLAIN, 23));
        TarifNormal.setForeground(frame.getSecondeCouleur());
        TarifNormal.setBounds(110, 160, 250, 50);
        PanelTarifs.add(TarifNormal);
        //Prix du tarif normal
        JLabel PrixNormal = new JLabel("15.50€");
        PrixNormal.setFont(new Font ("Arial", Font.BOLD, 27));
        PrixNormal.setForeground(frame.getSecondeCouleur());
        PrixNormal.setBounds(110, 200, 250, 50);
        PanelTarifs.add(PrixNormal);
        //Label pour le tarif -26 ans
        JLabel TarifJeune = new JLabel("Tarif -26 ans");
        TarifJeune.setFont(new Font ("Arial", Font.PLAIN, 23));
        TarifJeune.setForeground(frame.getSecondeCouleur());
        TarifJeune.setBounds(110, 330, 250, 50);
        PanelTarifs.add(TarifJeune);
        //Prix du tarif -26 ans
        JLabel PrixJeune = new JLabel("9.90€");
        PrixJeune.setFont(new Font ("Arial", Font.BOLD, 27));
        PrixJeune.setForeground(frame.getSecondeCouleur());
        PrixJeune.setBounds(110, 370, 250, 50);
        PanelTarifs.add(PrixJeune);
        //Label pour le tarif -14 ans
        JLabel TarifSenior = new JLabel("Tarif -14 ans");
        TarifSenior.setFont(new Font ("Arial", Font.PLAIN, 23));
        TarifSenior.setForeground(frame.getSecondeCouleur());
        TarifSenior.setBounds(110, 500, 250, 50);
        PanelTarifs.add(TarifSenior);
        //Prix du tarif -14 ans
        JLabel PrixSenior = new JLabel("7.50€");
        PrixSenior.setFont(new Font ("Arial", Font.BOLD, 27));
        PrixSenior.setForeground(frame.getSecondeCouleur());
        PrixSenior.setBounds(110, 540, 250, 50);
        PanelTarifs.add(PrixSenior);

        //Panel pour bouton nombre de ticket normal
        JPanel PanelNormal = new JPanel();
        PanelNormal.setBackground(frame.getCinqCouleur());
        PanelNormal.setLayout(null);
        PanelNormal.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PanelNormal.setBounds(750, 180, 250, 50);
        //Label pour le nombre de ticket normal
        JLabel NombreNormal = new JLabel("       0");
        NombreNormal.setFont(new Font ("Arial", Font.PLAIN, 23));
        NombreNormal.setForeground(frame.getSecondeCouleur());
        NombreNormal.setBounds(75, 0, 100, 50);
        PanelNormal.add(NombreNormal);
        //Bouton pour ajouter un ticket normal
        JButton AjoutNormal = new JButton("+");
        AjoutNormal.setFont(new Font ("Arial", Font.PLAIN, 23));
        AjoutNormal.setForeground(frame.getSecondeCouleur());
        AjoutNormal.setBackground(frame.getCinqCouleur());
        AjoutNormal.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        AjoutNormal.setBounds(0, 0, 50, 50);
        PanelNormal.add(AjoutNormal);
        //Bouton pour enlever un ticket normal
        JButton RetraitNormal = new JButton("-");
        RetraitNormal.setFont(new Font ("Arial", Font.PLAIN, 23));
        RetraitNormal.setForeground(frame.getSecondeCouleur());
        RetraitNormal.setBackground(frame.getCinqCouleur());
        RetraitNormal.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        RetraitNormal.setBounds(200, 0, 50, 50);
        PanelNormal.add(RetraitNormal);
        PanelTarifs.add(PanelNormal);

        //Panel pour bouton nombre de ticket normal
        JPanel PanelJeune = new JPanel();
        PanelJeune.setBackground(frame.getCinqCouleur());
        PanelJeune.setLayout(null);
        PanelJeune.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PanelJeune.setBounds(750, 350, 250, 50);
        //Label pour le nombre de ticket normal
        JLabel NombreJeune = new JLabel("       0");
        NombreJeune.setFont(new Font ("Arial", Font.PLAIN, 23));
        NombreJeune.setForeground(frame.getSecondeCouleur());
        NombreJeune.setBounds(75, 0, 100, 50);
        PanelJeune.add(NombreJeune);
        //Bouton pour ajouter un ticket Jeune
        JButton AjoutJeune = new JButton("+");
        AjoutJeune.setFont(new Font ("Arial", Font.PLAIN, 23));
        AjoutJeune.setForeground(frame.getSecondeCouleur());
        AjoutJeune.setBackground(frame.getCinqCouleur());
        AjoutJeune.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        AjoutJeune.setBounds(0, 0, 50, 50);
        PanelJeune.add(AjoutJeune);
        //Bouton pour enlever un ticket Jeune
        JButton RetraitJeune = new JButton("-");
        RetraitJeune.setFont(new Font ("Arial", Font.PLAIN, 23));
        RetraitJeune.setForeground(frame.getSecondeCouleur());
        RetraitJeune.setBackground(frame.getCinqCouleur());
        RetraitJeune.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        RetraitJeune.setBounds(200, 0, 50, 50);
        PanelJeune.add(RetraitJeune);
        PanelTarifs.add(PanelJeune);

        //Panel pour bouton nombre de ticket normal
        JPanel PanelAdo = new JPanel();
        PanelAdo.setBackground(frame.getCinqCouleur());
        PanelAdo.setLayout(null);
        PanelAdo.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        PanelAdo.setBounds(750, 520, 250, 50);
        //Label pour le nombre de ticket Ado
        JLabel NombreAdo = new JLabel("       0");
        NombreAdo.setFont(new Font ("Arial", Font.PLAIN, 23));
        NombreAdo.setForeground(frame.getSecondeCouleur());
        NombreAdo.setBounds(75, 0, 100, 50);
        PanelAdo.add(NombreAdo);
        //Bouton pour ajouter un ticket Ado
        JButton AjoutAdo = new JButton("+");
        AjoutAdo.setFont(new Font ("Arial", Font.PLAIN, 23));
        AjoutAdo.setForeground(frame.getSecondeCouleur());
        AjoutAdo.setBackground(frame.getCinqCouleur());
        AjoutAdo.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        AjoutAdo.setBounds(0, 0, 50, 50);
        PanelAdo.add(AjoutAdo);
        //Bouton pour enlever un ticket Ado
        JButton RetraitAdo = new JButton("-");
        RetraitAdo.setFont(new Font ("Arial", Font.PLAIN, 23));
        RetraitAdo.setForeground(frame.getSecondeCouleur());
        RetraitAdo.setBackground(frame.getCinqCouleur());
        RetraitAdo.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        RetraitAdo.setBounds(200, 0, 50, 50);
        PanelAdo.add(RetraitAdo);
        PanelTarifs.add(PanelAdo);


        //Bouton de validation de la réservation
        JButton Valider = new JButton("Valider la réservation");
        Valider.setFont(new Font ("Arial", Font.PLAIN, 23));
        Valider.setForeground(frame.getSecondeCouleur());
        Valider.setEnabled(false);
        Valider.setBackground(frame.getQuatreCouleur());
        Valider.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        Valider.setBounds(450, 700, 250, 50);
        PanelTarifs.add(Valider);

        AjoutNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nbTicketNormal<10)
                {
                    nbTicketNormal++;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreNormal.setText("       " + Integer.toString(nbTicketNormal));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });
        AjoutJeune.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nbTicketJeune<10)
                {
                    nbTicketJeune++;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreJeune.setText("       " + Integer.toString(nbTicketJeune));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });
        AjoutAdo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nbTicketAdo<10)
                {
                    nbTicketAdo++;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreAdo.setText("       " + Integer.toString(nbTicketAdo));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });
        RetraitNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nbTicketNormal > 0) {
                    nbTicketNormal--;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreNormal.setText("       " + Integer.toString(nbTicketNormal));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });
        RetraitJeune.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nbTicketJeune > 0) {
                    nbTicketJeune--;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreJeune.setText("       " + Integer.toString(nbTicketJeune));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });
        RetraitAdo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nbTicketAdo > 0) {
                    nbTicketAdo--;
                    // Mettez à jour le label affichant le nombre de places sélectionnées
                    NombreAdo.setText("       " + Integer.toString(nbTicketAdo));
                    // Vérifiez si au moins une place a été sélectionnée pour activer le bouton de validation
                    Valider.setEnabled(nbTicketNormal > 0 || nbTicketJeune > 0 || nbTicketAdo > 0);
                }
            }
        });

        // Action Listeners pour le bouton de promotion
        AjoutPromoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifiez si le code promo est valide
                if (CodePromoTXT.getText().equals("PROMO")) {
                    // Appliquer une réduction de 50% sur le prix total
                    PrixNormal.setText("7.75€");
                    PrixJeune.setText("4.95€");
                    PrixSenior.setText("3.75€");
                }
            }
        });

        // Action Listeners pour le bouton de validation
        Valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReservationSeanceListeners.ValiderReservation(frame, nbTicketNormal, nbTicketJeune, nbTicketAdo, 1);
            }
        });

        // Ajouter Tarifs avec GridBagLayout
        gbc.gridx = 1;
        gbc.gridy = 8; // Aller à la ligne suivante
        //gbc.gridheight = 50; // Étendre sur 50 lignes
        gbc.ipadx = 1150; // Largeur spécifique
        gbc.ipady = 800; // Hauteur spécifique
        contentPanel.add(PanelTarifs, gbc);

        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        scrollPane.setBorder(null);
        scrollPane.setBounds(0, 120, 1905, 921); // Ajustez la taille selon vos besoins


        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
    }
}