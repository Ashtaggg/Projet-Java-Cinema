package C.Listeners;

// Importation des fichiers

// Importation des librairies
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechercheActionListeners implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer la source de l'événement
        JButton button = (JButton) e.getSource();

        // Obtenir le nom du bouton
        String buttonName = button.getName();

        // Effectuer une action en fonction du nom du bouton
        switch (buttonName) {
            case "search_globale":
                System.out.println("Recherche Globale");
                break;
            default:
                System.out.println("Action non reconnue");
        }
    }
}
