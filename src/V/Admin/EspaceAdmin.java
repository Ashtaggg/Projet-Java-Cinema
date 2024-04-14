package V.Admin;

//Imports Fichiers
import V.FrameBase;

//Imports Java
import javax.swing.*;



public class EspaceAdmin {
    public static void affichageEspaceAdmin(FrameBase frame){
        frame.PageActuelle = "admin";
        frame.getPanelBase().removeAll();;

        //JLabel
        JLabel label = new JLabel("Espace Admin");
        label.setBounds(100, 100, 200, 50);
        frame.getPanelBase().add(label);

        //JButton
        JButton button = new JButton("Retour");
        button.setBounds(100, 200, 200, 50);
        frame.getPanelBase().add(button);
        button.addActionListener(e -> {
            frame.getPanelBase().removeAll();
            frame.RefreshPage();
        });

        frame.RefreshPage();

    }
    
}
