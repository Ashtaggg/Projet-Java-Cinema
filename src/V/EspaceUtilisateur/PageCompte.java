package V.EspaceUtilisateur;

import javax.swing.*;
import java.awt.*;

import V.FrameBase;

public class PageCompte {
    public static void affichagePageCompte(FrameBase frame){
        frame.PageActuelle = "compte";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();
    

    }
}
