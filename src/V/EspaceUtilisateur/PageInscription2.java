package V.EspaceUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import C.Listeners.PageConnexion.PageConnexionListeners;
import C.Listeners.PageConnexion.PageInscriptionListeners;
import C.Listeners.PageConnexion.InscriptionListeners;
import V.FrameBase;

public class PageInscription2 {
    public static void affichagePageInscription2(FrameBase frame, String prenom, String nom, String mail, Date date){
        frame.PageActuelle = "inscription";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();

        JPanel inscription = new JPanel();
        inscription.setBounds(585, 290, 750, 800);
        inscription.setBackground(frame.getMainCouleur());
        inscription.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);


        JLabel telLabel = new JLabel("Telephone");
        telLabel.setBounds(150, 20, 190, 24);
        telLabel.setForeground(frame.getSecondeCouleur());
        telLabel.setFont(font1);
        inscription.add(telLabel);

        JTextField tel = new JTextField(20);
        tel.setBounds(150, 60, 450, 40);
        tel.setOpaque(false);
        tel.setForeground(frame.getSecondeCouleur());
        tel.setFont(font2);
        inscription.add(tel);


        JLabel adresseLabel = new JLabel("Adresse");
        adresseLabel.setBounds(150, 150, 190, 24);
        adresseLabel.setForeground(frame.getSecondeCouleur());
        adresseLabel.setFont(font1);
        inscription.add(adresseLabel);

        JTextField adresse = new JTextField(20);
        adresse.setBounds(150, 190, 450, 40);
        adresse.setOpaque(false);
        adresse.setForeground(frame.getSecondeCouleur());
        adresse.setFont(font2);
        inscription.add(adresse);


        JLabel mdpLabel = new JLabel("Mot de Passe *");
        mdpLabel.setBounds(150, 280, 350, 24);
        mdpLabel.setForeground(frame.getSecondeCouleur());
        mdpLabel.setFont(font1);
        inscription.add(mdpLabel);

        JTextField mdp = new JTextField(20);
        mdp.setBounds(150, 320, 450, 40);
        mdp.setOpaque(false);
        mdp.setForeground(frame.getSecondeCouleur());
        mdp.setFont(font2);
        inscription.add(mdp);


        JLabel dateLabel = new JLabel("Confirmation du Mot de Passe *");
        dateLabel.setBounds(150, 410, 500, 24);
        dateLabel.setForeground(frame.getSecondeCouleur());
        dateLabel.setFont(font1);
        inscription.add(dateLabel);

        JTextField mdp2 = new JTextField(20);
        mdp2.setBounds(150, 450, 450, 40);
        mdp2.setOpaque(false);
        mdp2.setForeground(frame.getSecondeCouleur());
        mdp2.setFont(font2);
        inscription.add(mdp2);



        JLabel problemConnexionLabel = new JLabel("Le mot de passe est erroné");
        problemConnexionLabel.setBounds(278, 490, 194, 24);
        problemConnexionLabel.setForeground(frame.getSecondeCouleur());
        problemConnexionLabel.setFont(font3);
        problemConnexionLabel.setVisible(false);
        inscription.add(problemConnexionLabel);



        JLabel connexionLabel = new JLabel("Pas encore de compte ?");
        connexionLabel.setBounds(246, 540, 171, 24);
        connexionLabel.setForeground(frame.getSecondeCouleur());
        connexionLabel.setFont(font3);
        inscription.add(connexionLabel);

        JButton connexion = new JButton("Connexion");
        connexion.addActionListener(e -> {
            PageConnexionListeners.boutonConnexion(frame);
        });
        connexion.setBounds(427, 540, 77, 24);
        connexion.setBorder(BorderFactory.createEmptyBorder());
        connexion.setForeground(frame.getSecondeCouleur());
        connexion.setBackground(frame.getMainCouleur());
        connexion.setFont(font3);
        inscription.add(connexion);


        JButton precedent = new JButton("Précédent");
        precedent.addActionListener(e -> {
            PageInscriptionListeners.boutonInscription(frame);
        });
        precedent.setBounds(150, 630, 170, 40);
        precedent.setForeground(frame.getSecondeCouleur());
        precedent.setBackground(frame.getMainCouleur());
        precedent.setFont(font2);
        inscription.add(precedent);


        JButton suivant = new JButton("S'inscrire");
        suivant.addActionListener(e -> {
            String Tel = tel.getText();
            String Adresse = adresse.getText();
            String Mdp = mdp.getText();
            String Mdp2 = mdp2.getText();

            InscriptionListeners.boutonInscrire(frame, problemConnexionLabel, prenom, nom, mail, date, Tel, Adresse, Mdp, Mdp2);
        
        });
        suivant.setBounds(430, 630, 170, 40);
        suivant.setForeground(frame.getSecondeCouleur());
        suivant.setBackground(frame.getMainCouleur());
        suivant.setFont(font2);
        inscription.add(suivant);

        frame.getPanelBase().setVisible(true);
        frame.getPanelBase().add(inscription);

        frame.RefreshPage();
    }
}
