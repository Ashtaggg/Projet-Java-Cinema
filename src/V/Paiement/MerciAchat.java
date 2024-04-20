package V.Paiement;

//Imports Fichier
import V.FrameBase;
import C.Listeners.ChangementPageListeners;

//Imports Java
import javax.swing.*;
import java.awt.*;


public class MerciAchat {
    
    public static void afficherMerciAchat(FrameBase frame)
    {
        frame.PageActuelle = "Merci";
        frame.getPanelBase().removeAll();
        
        // Création d'un JLabel pour afficher le message de remerciement
        JLabel messageMerci = new JLabel("Merci pour votre achat !");
        messageMerci.setFont(new Font("Arial", Font.BOLD, 40));
        messageMerci.setForeground(frame.getSecondeCouleur());
        messageMerci.setHorizontalAlignment(SwingConstants.CENTER);
        messageMerci.setBounds(250, 340, 800, 100);

        // Ajout du message au panel principal
        frame.getPanelBase().add(messageMerci);

        // Bouton pour retourner à la page d'accueil
        JButton retourAccueil = new JButton("Retour à l'accueil");
        retourAccueil.setFont(new Font("Arial", Font.BOLD, 24));
        retourAccueil.setForeground(frame.getMainCouleur());
        retourAccueil.setBackground(frame.getSecondeCouleur());
        retourAccueil.setBounds(430, 490, 400, 60);
        retourAccueil.addActionListener(e -> {
            // Appel à la méthode pour afficher la page d'accueil
            // (remplacer "accueil" par le nom de la méthode pour afficher la page d'accueil)
            ChangementPageListeners.ChangementPage("accueil_films", frame);
        });


        // Ajout du bouton au panel principal
        frame.getPanelBase().add(retourAccueil);

        //Photo de remerciement
        ImageIcon MerciRobot = null;
        if(frame.DarkMode){MerciRobot = new ImageIcon("images/Images_Projet_V/Merci/Robot_Merci_Blanc.png");}
        else{MerciRobot = new ImageIcon("images/Images_Projet_V/Merci/Robot_Merci_Dark.png");}
        MerciRobot = new ImageIcon(MerciRobot.getImage().getScaledInstance(512, 512, Image.SCALE_DEFAULT));
        JLabel MerciRobotLabel = new JLabel(MerciRobot);
        MerciRobotLabel.setBounds(1100, 160, 512, 512);
        frame.getPanelBase().add(MerciRobotLabel);

        //Refresh
        frame.RefreshPage();
    }
}
