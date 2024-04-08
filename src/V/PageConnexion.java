package V;

import javax.swing.*;
import java.awt.*;

import C.Listeners.PageConnexion.ConnexionListeners;
import C.Listeners.PageConnexion.PageInscriptionListeners;

public class PageConnexion {
    public static void affichagePageConnexion(FrameBase frame){
        frame.PageActuelle = "connexion";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();

        JPanel connexion = new JPanel();
        connexion.setBounds(585, 290, 750, 500);
        connexion.setBackground(frame.getMainCouleur());
        connexion.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);


        JLabel idLabel = new JLabel("Adresse Mail");
        idLabel.setBounds(150, 20, 185, 24);
        idLabel.setForeground(frame.getSecondeCouleur());
        idLabel.setFont(font1);
        connexion.add(idLabel);

        JTextField id = new JTextField(20);
        id.setBounds(150, 60, 450, 40);
        id.setOpaque(false);
        id.setForeground(frame.getSecondeCouleur());
        id.setFont(font2);
        connexion.add(id);


        JLabel mdpLabel = new JLabel("Mot de passe");
        mdpLabel.setBounds(150, 150, 190, 24);
        mdpLabel.setForeground(frame.getSecondeCouleur());
        mdpLabel.setFont(font1);
        connexion.add(mdpLabel);

        JTextField mdp = new JTextField(20);
        mdp.setBounds(150, 190, 450, 40);
        mdp.setOpaque(false);
        mdp.setForeground(frame.getSecondeCouleur());
        mdp.setFont(font2);
        connexion.add(mdp);


        JLabel problemConnexionLabel = new JLabel("L'adresse mail ou le mot de passe est incorect");
        problemConnexionLabel.setBounds(211, 230, 327, 24);
        problemConnexionLabel.setForeground(frame.getSecondeCouleur());
        problemConnexionLabel.setFont(font3);
        problemConnexionLabel.setVisible(false);
        connexion.add(problemConnexionLabel);


        JLabel inscriptionLabel = new JLabel("Pas encore de compte ?");
        inscriptionLabel.setBounds(246, 300, 171, 24);
        inscriptionLabel.setForeground(frame.getSecondeCouleur());
        inscriptionLabel.setFont(font3);
        connexion.add(inscriptionLabel);

        JButton inscription = new JButton("Inscription");
        inscription.addActionListener(e -> {
            PageInscriptionListeners.boutonInscription(frame);
        });
        inscription.setBounds(429, 300, 75, 24);
        inscription.setBorder(BorderFactory.createEmptyBorder());
        inscription.setForeground(frame.getSecondeCouleur());
        inscription.setBackground(frame.getMainCouleur());
        inscription.setFont(font3);
        connexion.add(inscription);

        JButton boutonConnect = new JButton("Connexion");
        boutonConnect.addActionListener(e -> {
            String mail = id.getText();
            String password = mdp.getText();
            
            ConnexionListeners.boutonConnexion(frame, problemConnexionLabel, mail, password);
        });
        boutonConnect.setBounds(290, 400, 170, 40);
        boutonConnect.setForeground(frame.getSecondeCouleur());
        boutonConnect.setBackground(frame.getMainCouleur());
        boutonConnect.setFont(font2);
        connexion.add(boutonConnect);


        
        frame.getPanelBase().setVisible(true);
        frame.getPanelBase().add(connexion);

        frame.RefreshPage();
    }
}
