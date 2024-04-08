package C.Listeners;

// Importation des fichiers
import V.FrameBase;

// Importation des librairies

public class DarkModeListeners {
    public void actionPerformed(FrameBase frame) {
        // Effectuer une action en fonction du nom du bouton
        frame.getDarkMode();
    }
}


if(DarkMode){
    MainCouleur = MainCouleur_Light;
    SecondeCouleur = SecondeCouleur_Light;
    TroisCouleur = TroisCouleur_Light;
    QuatreCouleur = QuatreCouleur_Light;
    this.getContentPane().setBackground(MainCouleur);
    BandeauSup.setBackground(SecondeCouleur);
    PanelBase.setBackground(MainCouleur);
    DarkMode = false;
}else{
    MainCouleur = MainCouleur_Dark;
    SecondeCouleur = SecondeCouleur_Dark;
    TroisCouleur = TroisCouleur_Dark;
    QuatreCouleur = QuatreCouleur_Dark;
    this.getContentPane().setBackground(MainCouleur);
    BandeauSup.setBackground(SecondeCouleur);
    PanelBase.setBackground(MainCouleur);
    DarkMode = true;
}
this.RefreshPage();