package V.Reservation;

import javax.swing.JPanel;

// Importation des librairies
import V.FrameBase;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import javax.swing.JScrollPane;

// Importation des fichiers


public class Reservation_Seance {

    public static void affichageReservation_Seance(FrameBase frame) {

        frame.PageActuelle = "reservation_seance";
        frame.getPanelBase().removeAll();

        frame.getPanelBase().setBackground(Color.RED);

        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Assurez-vous de définir le layout selon vos besoins
        contentPanel.setBackground(Color.GREEN);
        contentPanel.setBounds(0, 0, 1890, 1036);

        // Créer les nouveaux composants à ajouter au contentPanel
        JPanel ResumeSeance = new JPanel();
        ResumeSeance.setBounds(585, 290, 750, 800);
        ResumeSeance.setBackground(frame.getMainCouleur());
        ResumeSeance.setVisible(true);
        ResumeSeance.setOpaque(true);
        ResumeSeance.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));

        // Ajouter les composants au contentPanel
        contentPanel.add(ResumeSeance);

        // Ajouter le contentPanel au PanelBase
        frame.getPanelBase().add(contentPanel);

        // ajouter une scroll bar à Panelbase
        JScrollPane scrollBar = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setPreferredSize(new Dimension(30, 0));
        scrollBar.setBackground(frame.getMainCouleur());
        scrollBar.setBounds(1890, 123, 13, 913);

        // Ajouter le JScrollPane à la FrameBase
        frame.getPanelBase().add(scrollBar);

        frame.RefreshPage();
        //
    }
}
