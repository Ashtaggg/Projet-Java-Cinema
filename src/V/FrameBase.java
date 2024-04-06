package V;

//Importation des fichiers

//Importation des librairies
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrameBase extends JFrame{
    //Constructeur
    public FrameBase(String titre, Color MainCouleur, Color SecondeCouleur, Color TroisCouleur){
        //Setting basique de la fenêtre
        super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.getContentPane().setBackground(MainCouleur);
        //Changer Logo de la Page
        ImageIcon Logo_ECE = new ImageIcon("C:\\Users\\Mathis\\OneDrive\\Bureau\\ECE\\ING3\\S2 ECE\\Info\\Projet Java\\Projet_Git_V2\\Projet-Java-Cinema\\images\\Logo_ECE_Frame/ECE_Logo.jpg");
        this.setIconImage(Logo_ECE.getImage());

        
        //Création du bandeau bleu en haut de la page

    }
}
