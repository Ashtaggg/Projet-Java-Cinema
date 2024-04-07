package C.Listeners;

// Importation des fichiers


// Importation des librairies
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChangementPageActionListeners implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer la source de l'événement
        JButton button = (JButton) e.getSource();

        // Obtenir le nom du bouton
        String buttonName = button.getName();

        // Effectuer une action en fonction du nom du bouton
        switch (buttonName) {
            case "compte":
                System.out.println("Compte");
                break;
            case "panier":
                System.out.println("Panier");
                break;
            case "accueil":
                System.out.println("Accueil");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
