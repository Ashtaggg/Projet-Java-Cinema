package V.Reservation;

/*import javax.swing.JPanel;

// Importation des librairies
import V.FrameBase;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


import javax.swing.JScrollPane;

// Importation des fichiers


public class Reservation_Seance implements AdjustmentListener{

    static double scrollValue = 0;
    static JPanel contentPanel;

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
        frame.getPanelBase().removeAll();

        frame.getPanelBase().setBackground(Color.RED);

        // ajouter une scroll bar à Panelbase
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollBar.setPreferredSize(new Dimension(30, 0));
        scrollBar.setBackground(frame.getMainCouleur());
        scrollBar.setBounds(1890, 120, 13, 915);
        scrollBar.addAdjustmentListener(new Reservation_Seance());

        frame.getPanelBase().add(scrollBar);

        // Créer un nouveau JPanel pour contenir tous les composants
        contentPanel = new JPanel();
        contentPanel.setLayout(null); // Assurez-vous de définir le layout selon vos besoins
        contentPanel.setVisible(true);
        contentPanel.setSize(1890, 2036); // Ajustez la taille selon vos besoins
        contentPanel.setBackground(Color.GREEN);
        contentPanel.setBounds(0, 0, 1890, 1036);

        // Créer les nouveaux composants à ajouter au contentPanel
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setBounds(585, 290, 750, 800);
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setVisible(true);
        ResumeSeance.setOpaque(true);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));

        contentPanel.add(ResumeSeance);

        frame.getPanelBase().add(contentPanel);

        frame.RefreshPage();
        //
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Scrolling : " + e.getValue()); //De 0 à 90
        scrollValue = (e.getValue()/90)*2036;
        System.out.println("Scrolling Value: " + scrollValue); //De 0 à 2036
        contentPanel.setBounds(0, 0-(int)scrollValue, 1890, 2072);

    }
}*/

// Importation des librairies
/*import V.FrameBase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Reservation_Seance {

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
        frame.getPanelBase().removeAll();

        // Créer un nouveau JPanel pour contenir tous les composants avec FlowLayout
        JPanel contentPanel = new JPanel(new FlowLayout());
        contentPanel.setBackground(frame.getMainCouleur());
        contentPanel.setPreferredSize(new Dimension(1705, 921)); // Taille du JScrollPane
        contentPanel.setBorder(BorderFactory.createEmptyBorder(120, 100, 0, 0)); // Ajuster l'espacement
       
        //Résumé Film Reservé
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setPreferredSize(new Dimension(750, 800)); // Taille spécifique pour ResumeSeance
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));

        contentPanel.add(new JLabel("Label 1")); // Ajouter d'autres composants si nécessaire
        contentPanel.add(ResumeSeance);

        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        scrollPane.setBorder(null);
        scrollPane.setBounds(100, 120, 1705, 921); // Ajustez la taille selon vos besoins


        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
    }
}*/

// Importation des librairies
/*import V.FrameBase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class Reservation_Seance {

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
        frame.getPanelBase().removeAll();

        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Assurez-vous de définir le layout selon vos besoins
        contentPanel.setVisible(true);
        contentPanel.setSize(90, 72); // Ajustez la taille selon vos besoins
        contentPanel.setBackground(frame.getMainCouleur());
        contentPanel.setBounds(0, 0, 500, 800);

        JLabel label1 = new JLabel("Label 1");
        contentPanel.add(label1);

        //Résumé Film Reservé
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setSize(750, 800);
        ResumeSeance.setBounds(585, 290, 750, 8000);
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setVisible(true);
        ResumeSeance.setOpaque(true);
        //ResumeSeance.setLayout(null);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));


        // Ajout de labels
        /*for (int i = 1; i <= 10; i++) {
            JLabel label2 = new JLabel("Label2 " + i);
            label2.setBounds(10, 10 + (i * 50), 100, 50);
            ResumeSeance.add(label2);
        }

        contentPanel.add(ResumeSeance);

        // Ajout de labels
        for (int i = 1; i <= 90; i++) {
            JLabel label = new JLabel("Label " + i);
            contentPanel.add(label);
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
        scrollPane.setBounds(100, 120, 1705, 921); // Ajustez la taille selon vos besoins


        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
    }
}*/

// Importation des fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Seance;

// Importation des librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.w3c.dom.Text;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;


public class Reservation_Seance {

    public static void affichageReservation_Seance(FrameBase frame, Film film, Seance seance) {

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
        for (int i = 1; i <= 100; i++) {
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
        JLabel TitreFilm = new JLabel("Titre du Film");
        TitreFilm.setFont(new Font ("Arial", Font.BOLD, 25));
        TitreFilm.setForeground(frame.getSecondeCouleur());
        TitreFilm.setBounds(350, 20, 300, 50);
        ResumeSeance.add(TitreFilm);


        // Ajouter ResumeSeance avec GridBagLayout
        gbc.gridx = 1;
        gbc.gridy = 3;
        //gbc.fill = GridBagConstraints.BOTH; // Remplir l'espace disponible
        gbc.ipadx = 1150; // Largeur spécifique
        gbc.ipady = 300; // Hauteur spécifique
        contentPanel.add(ResumeSeance, gbc);

        gbc.gridy = 7; // Revenir à la ligne suivante
        gbc.ipadx = 950; // Largeur spécifique
        gbc.ipady = 50; // Hauteur spécifique
        //Tracer une ligne pour séparer les composants
        JLabel separator = new JLabel(" ");
        separator.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, frame.getTroisCouleur()));
        contentPanel.add(separator, gbc);

        //Nouveau panel pour les tarifs
        JPanel Tarifs = new JPanel();
        Tarifs.setBackground(frame.getMainCouleur());
        Tarifs.setLayout(null);
        Tarifs.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        //Labels de Tarifs
        JLabel TarifNormal = new JLabel("Tarif Normal");
        TarifNormal.setBounds(10, 10, 100, 50);
        Tarifs.add(TarifNormal);

        // Ajouter Tarifs avec GridBagLayout
        gbc.gridx = 1;
        gbc.gridy = 8; // Aller à la ligne suivante
        //gbc.gridheight = 50; // Étendre sur 50 lignes
        gbc.ipadx = 1150; // Largeur spécifique
        gbc.ipady = 800; // Hauteur spécifique
        contentPanel.add(Tarifs, gbc);

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

// Importation des librairies
/*import V.FrameBase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;


public class Reservation_Seance {

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
        frame.getPanelBase().removeAll();

        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible
        contentPanel.setBackground(frame.getMainCouleur());

        // Créer un GridBagConstraints pour le placement des composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants

        // Ajouter des panneaux pour contrôler les colonnes spécifiques avec FlowLayout
        JPanel leftColumnPanel = new JPanel();
        leftColumnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftColumnPanel.setBackground(Color.RED); // Couleur de fond pour la colonne gauche
        contentPanel.add(leftColumnPanel, gbc);

        JPanel rightColumnPanel = new JPanel();
        rightColumnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightColumnPanel.setBackground(Color.BLUE); // Couleur de fond pour la colonne droite
        gbc.gridx = 1; // Placer le panneau de droite sur la colonne suivante
        contentPanel.add(rightColumnPanel, gbc);

        // Ajout de labels à la colonne de gauche
        for (int i = 1; i <= 30; i++) {
            JLabel label = new JLabel("Label " + i);
            gbc.gridy++; // Passer à la prochaine ligne
            leftColumnPanel.add(label);
        }

        //Résumé Film Reservé dans la colonne de droite
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setPreferredSize(new Dimension(200, 800)); // Taille spécifique pour le panneau de résumé
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        rightColumnPanel.add(ResumeSeance);

        // Ajout de labels à la colonne de droite
        for (int i = 31; i <= 60; i++) {
            JLabel label = new JLabel("Label " + i);
            rightColumnPanel.add(label);
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
        scrollPane.setBounds(100, 120, 1705, 921); // Ajustez la taille selon vos besoins

        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
    }
}*/

