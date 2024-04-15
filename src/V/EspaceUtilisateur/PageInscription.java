package V.EspaceUtilisateur;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

import C.Listeners.PageConnexion.PageConnexionListeners;
import C.Listeners.PageConnexion.PageInscription2Listeners;
import V.FrameBase;

public class PageInscription {
    public static void affichagePageInscription(FrameBase frame){
        frame.PageActuelle = "inscription";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();


        JPanel inscription = new JPanel();
        inscription.setBounds(585, 160, 750, 800);
        inscription.setBackground(frame.getMainCouleur());
        inscription.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);


        JLabel prenomLabel = new JLabel("Prenom *");
        prenomLabel.setBounds(150, 20, 190, 24);
        prenomLabel.setForeground(frame.getSecondeCouleur());
        prenomLabel.setFont(font1);
        inscription.add(prenomLabel);

        JTextField prenom = new JTextField(20);
        prenom.setBounds(150, 60, 450, 40);
        prenom.setOpaque(false);
        prenom.setForeground(frame.getSecondeCouleur());
        prenom.setFont(font2);
        inscription.add(prenom);


        JLabel nomLabel = new JLabel("Nom *");
        nomLabel.setBounds(150, 150, 190, 24);
        nomLabel.setForeground(frame.getSecondeCouleur());
        nomLabel.setFont(font1);
        inscription.add(nomLabel);

        JTextField nom = new JTextField(20);
        nom.setBounds(150, 190, 450, 40);
        nom.setOpaque(false);
        nom.setForeground(frame.getSecondeCouleur());
        nom.setFont(font2);
        inscription.add(nom);


        JLabel mailLabel = new JLabel("Adresse Mail *");
        mailLabel.setBounds(150, 280, 210, 24);
        mailLabel.setForeground(frame.getSecondeCouleur());
        mailLabel.setFont(font1);
        inscription.add(mailLabel);

        JTextField mail = new JTextField(20);
        mail.setBounds(150, 320, 450, 40);
        mail.setOpaque(false);
        mail.setForeground(frame.getSecondeCouleur());
        mail.setFont(font2);
        inscription.add(mail);


        JLabel dateLabel = new JLabel("Date de Naissance");
        dateLabel.setBounds(150, 410, 300, 24);
        dateLabel.setForeground(frame.getSecondeCouleur());
        dateLabel.setFont(font1);
        inscription.add(dateLabel);

        JDateChooser date = new JDateChooser();
        date.setBounds(150, 450, 448, 40);
        date.setDateFormatString("yyyy-MM-dd");
        JTextField dateEditor = ((JTextField) date.getDateEditor());
        dateEditor.setForeground(frame.getSecondeCouleur());
        dateEditor.setBackground(frame.getMainCouleur());
        date.setFont(font2);
        inscription.add(date);


        JLabel problemConnexionLabel = new JLabel("L'adresse mail est déjà utilisé");
        problemConnexionLabel.setBounds(271, 490, 209, 24);
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


        JButton suivant = new JButton("Suivant");
        suivant.addActionListener(e -> {
            String Prenom = prenom.getText();
            String Nom = nom.getText();
            String Mail = mail.getText();
            Date Date = date.getDate();
            
            PageInscription2Listeners.boutonSuivant(frame, problemConnexionLabel, Prenom, Nom, Mail, Date);
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



    /*public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawLine(0, 0, 500, 500);
    }*/
}
