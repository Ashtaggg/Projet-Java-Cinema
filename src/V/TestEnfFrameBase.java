package V;

//Importation des fichiers

//Importation des librairies
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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

        // ajouter une scroll bar à Panelbase
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollBar.setPreferredSize(new Dimension(30, 0));
        scrollBar.setBackground(frame.getMainCouleur());
        scrollBar.setBounds(1890, 123, 13, 913);

        frame.getPanelBase().add(scrollBar);

        // Créer les nouveaux composants à ajouter au PanelBase

        JLabel label = new JLabel("Nouveau contenu du PanelBase");
        label.setForeground(Color.BLACK);
        label.setBounds(100, 100, 200, 50); // Spécifier la position (x, y) et la taille (largeur, hauteur)

        JButton button = new JButton("Nouveau bouton");
        button.setBounds(100, 200, 150, 30); // Spécifier la position (x, y) et la taille (largeur, hauteur)


        // Ajoutez les nouveaux composants au PanelBase
        frame.getPanelBase().add(label);
        frame.getPanelBase().add(button);

        //frame.getPanelBase().setBackground(Color.BLACK);

        // Rafraîchir l'interface utilisateur
        frame.RefreshPage();

    System.out.println("testEnfFrameBase");
    }
    
}
