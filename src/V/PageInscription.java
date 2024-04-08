package V;

import javax.swing.*;
import java.awt.*;

import C.Listeners.PageConnexion.PageConnexionListeners;

public class PageInscription {
    public static void affichagePageInscription(FrameBase frame){
        frame.PageActuelle = "inscription";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();

        JPanel inscription = new JPanel();
        inscription.setBounds(585, 290, 750, 500);
        inscription.setBackground(frame.getMainCouleur());
        inscription.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);








        JLabel connexionLabel = new JLabel("Pas encore de compte ?");
        connexionLabel.setBounds(246, 300, 171, 24);
        connexionLabel.setForeground(frame.getSecondeCouleur());
        connexionLabel.setFont(font3);
        inscription.add(connexionLabel);

        JButton connexion = new JButton("Connexion");
        connexion.addActionListener(e -> {
            PageConnexionListeners.boutonConnexion(frame);
        });
        connexion.setBounds(427, 300, 77, 24);
        connexion.setBorder(BorderFactory.createEmptyBorder());
        connexion.setForeground(frame.getSecondeCouleur());
        connexion.setBackground(frame.getMainCouleur());
        connexion.setFont(font3);
        inscription.add(connexion);




        frame.getPanelBase().setVisible(true);
        frame.getPanelBase().add(inscription);

        frame.RefreshPage();
    }
}
