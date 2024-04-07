package V;

//Importation des fichiers
import C.Listeners.ChangementPageActionListeners;

//Importation des librairies
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JButton;
import java.awt.Font;

public class FrameBase extends JFrame{

    //Variables
    private JPanel PanelBase;

    //Constructeur
    public FrameBase(String titre, Color MainCouleur, Color SecondeCouleur, Color TroisCouleur){
        //Setting basique de la fenêtre
        super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.getContentPane().setBackground(MainCouleur);

        //Class de Listener pour les boutons
        ChangementPageActionListeners changementPageActionListeners = new ChangementPageActionListeners();

        //Changer Logo de la Page
        ImageIcon Logo_ECE = new ImageIcon("images/Logo_ECE_Frame/ECE_Logo.jpg");
        this.setIconImage(Logo_ECE.getImage());


        //Création du bandeau bleu en haut de la page
        JPanel BandeauSup = new JPanel();
        BandeauSup.setLayout(null);
        BandeauSup.setBackground(SecondeCouleur);
        BandeauSup.setBounds(0, 0, 1920, 120);

        //Ajout de notre Logo en haut à gauche du bandeau = Bouton caché pour retourner à l'accueil
        ImageIcon LogoProjet = new ImageIcon("images/Logo.jpeg");
        JButton BoutonLogo_Accueil = new JButton();
        BoutonLogo_Accueil.setIcon(new ImageIcon(LogoProjet.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
        BoutonLogo_Accueil.setOpaque(true);
        BoutonLogo_Accueil.setFocusable(false);
        BoutonLogo_Accueil.setBorderPainted(false);
        BoutonLogo_Accueil.setBackground(SecondeCouleur);
        //Action du bouton
        BoutonLogo_Accueil.setName("accueil");
        BoutonLogo_Accueil.addActionListener(changementPageActionListeners);

        BandeauSup.add(BoutonLogo_Accueil);
        BoutonLogo_Accueil.setBounds(35, 15, 90, 90);

        // Bouton de Compte Utilisateur en haut à droite
        JButton BoutonCompte = new JButton();
        ImageIcon IconeCompte = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/User_Blanc.png");
        BoutonCompte.setIcon(new ImageIcon(IconeCompte.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        BoutonCompte.setText("Mon Compte");
        BoutonCompte.setHorizontalTextPosition(JButton.CENTER);
        BoutonCompte.setVerticalTextPosition(JButton.BOTTOM);
        BoutonCompte.setFont(new Font("Arial", Font.BOLD, 12));
        BoutonCompte.setIconTextGap(13);
        BoutonCompte.setForeground(Color.WHITE);
        BoutonCompte.setOpaque(true);
        BoutonCompte.setFocusable(false);
        BoutonCompte.setBorderPainted(false);
        BoutonCompte.setBackground(SecondeCouleur);
        //Action du bouton
        BoutonCompte.setName("compte");
        BoutonCompte.addActionListener(changementPageActionListeners);

        BandeauSup.add(BoutonCompte);
        BoutonCompte.setBounds(1750, 20, 120, 80);

        //Bouton de recherche en haut à droite
        JButton BoutonSearch = new JButton();
        ImageIcon IconeSearch = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Search_Blanc.png");
        BoutonSearch.setIcon(new ImageIcon(IconeSearch.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        BoutonSearch.setText("Rechercher");
        BoutonSearch.setHorizontalTextPosition(JButton.CENTER);
        BoutonSearch.setVerticalTextPosition(JButton.BOTTOM);
        BoutonSearch.setFont(new Font("Arial", Font.BOLD, 12));
        BoutonSearch.setIconTextGap(13);
        BoutonSearch.setForeground(Color.WHITE);
        BoutonSearch.setOpaque(true);
        BoutonSearch.setFocusable(false);
        BoutonSearch.setBorderPainted(false);
        BoutonSearch.setBackground(SecondeCouleur);
        //Action du bouton
        BoutonSearch.addActionListener(e -> {
            System.out.println("Rechercher");
        });

        BandeauSup.add(BoutonSearch);
        BoutonSearch.setBounds(1630, 20, 120, 80);

        //Bouton de Panier en haut à droite
        JButton BoutonPanier = new JButton();
        ImageIcon IconePanier = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Panier_Blanc.png");
        BoutonPanier.setIcon(new ImageIcon(IconePanier.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        BoutonPanier.setText("Panier");
        BoutonPanier.setHorizontalTextPosition(JButton.CENTER);
        BoutonPanier.setVerticalTextPosition(JButton.BOTTOM);
        BoutonPanier.setFont(new Font("Arial", Font.BOLD, 12));
        BoutonPanier.setIconTextGap(13);
        BoutonPanier.setForeground(Color.WHITE);
        BoutonPanier.setOpaque(true);
        BoutonPanier.setFocusable(false);
        BoutonPanier.setBorderPainted(false);
        BoutonPanier.setBackground(SecondeCouleur);
        //Action du bouton
        BoutonPanier.setName("panier");
        BoutonPanier.addActionListener(changementPageActionListeners);

        BandeauSup.add(BoutonPanier);
        BoutonPanier.setBounds(1510, 20, 120, 80);

        //Panel pour le reste de la page à actualiser en focntion de la page
        PanelBase = new JPanel();
        PanelBase.setBackground(MainCouleur);
        PanelBase.setBounds(0, 120, 1920, 960);
        PanelBase.setLayout(null);
        PanelBase.setVisible(true);


        //Ajout des éléments à la Frame Base
        this.add(BandeauSup);
        this.add(PanelBase);
    }

    public JPanel getPanelBase(){
        return PanelBase;
    }

}
