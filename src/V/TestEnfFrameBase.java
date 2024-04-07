package V;

//Importation des fichiers

//Importation des librairies
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Dimension;

public class TestEnfFrameBase {

    //Constructeur
    public TestEnfFrameBase(){
    }

    public void affichertestEnfFrameBase(FrameBase frame) {

        // Retirez les composants actuels du PanelBase
        frame.getPanelBase().removeAll();

        // Créer les nouveaux composants à ajouter au PanelBase
        JLabel label = new JLabel("Nouveau contenu du PanelBase");
        label.setForeground(Color.BLACK);
        JButton button = new JButton("Nouveau bouton");

        // Ajoutez les nouveaux composants au PanelBase
        frame.getPanelBase().add(label);
        frame.getPanelBase().add(button);

        frame.getPanelBase().setBackground(Color.BLACK);

        // Rafraîchir l'interface utilisateur
        frame.getPanelBase().revalidate();
        frame.getPanelBase().repaint();
        frame.getPanelBase().setVisible(true);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();

    System.out.println("testEnfFrameBase");
    }
    
}
