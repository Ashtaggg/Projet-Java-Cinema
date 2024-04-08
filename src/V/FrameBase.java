package V;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;

//Importation des librairies
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Font;

public class FrameBase extends JFrame{

    //Variables
    private JPanel PanelBase;
    public String PageActuelle = "accueil_films";

    public Utilisateur userActuel = null;

    //Couelurs :
    boolean DarkMode = false;
    //Light Mode
    Color MainCouleur_Light = new Color(235, 235, 235);
    Color SecondeCouleur_Light = new Color(0, 19, 77);
    Color TroisCouleur_Light = new Color(62, 96, 193);
    Color QuatreCouleur_Light = new Color(90, 130, 252);
    //Dark Mode
    Color MainCouleur_Dark = new Color(33, 34, 38);
    Color SecondeCouleur_Dark = new Color(0, 19, 77);
    Color TroisCouleur_Dark = new Color(62, 96, 193);
    Color QuatreCouleur_Dark = new Color(90, 130, 252);
    //Couleur actuelle
    Color MainCouleur = MainCouleur_Light;
    Color SecondeCouleur = SecondeCouleur_Light;
    Color TroisCouleur = TroisCouleur_Light;
    Color QuatreCouleur = QuatreCouleur_Light;

    //Constructeur
    public FrameBase(){
        //Setting basique de la fenêtre
        super("Projet Java Cinéma");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setVisible(true);
        if(DarkMode){
            MainCouleur = MainCouleur_Dark;
            SecondeCouleur = SecondeCouleur_Dark;
            TroisCouleur = TroisCouleur_Dark;
            QuatreCouleur = QuatreCouleur_Dark;
        }
        this.getContentPane().setBackground(MainCouleur);

        //Class de Listener pour les boutons
        ChangementPageListeners changementPageListeners = new ChangementPageListeners();
        RechercheListeners rechercheListeners = new RechercheListeners();

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
        BoutonLogo_Accueil.setName("accueil_films");
        BoutonLogo_Accueil.addActionListener(e -> {
            changementPageListeners.ChanhementPage(BoutonLogo_Accueil.getName(), this);
        });

        BandeauSup.add(BoutonLogo_Accueil);
        BoutonLogo_Accueil.setBounds(100, 15, 90, 90);

                //Ajout de l'icon pour le Dark Mode
                ImageIcon IconeDarkMode = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Mode_Blanc.png");
                JButton BoutonDarkMode = new JButton();
                BoutonDarkMode.setIcon(new ImageIcon(IconeDarkMode.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
                BoutonDarkMode.setOpaque(true);
                BoutonDarkMode.setFocusable(false);
                BoutonDarkMode.setBorderPainted(false);
                BoutonDarkMode.setBackground(SecondeCouleur);
                //Action du bouton
                BoutonDarkMode.setName("dark_mode");
                BoutonDarkMode.addActionListener(e -> {
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
                    changementPageListeners.ChanhementPage(PageActuelle, this);
                });
        
                BandeauSup.add(BoutonDarkMode);
                BoutonDarkMode.setBounds(1830, 40, 40, 40);

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
        BoutonCompte.addActionListener(e -> {
            changementPageListeners.ChanhementPage(BoutonCompte.getName(), this);
        });

        BandeauSup.add(BoutonCompte);
        BoutonCompte.setBounds(1700, 20, 120, 80);

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
        BoutonSearch.setName("search_globale");
        BoutonSearch.addActionListener(e -> {
            rechercheListeners.actionPerformed(BoutonSearch.getName(), this);
        });

        BandeauSup.add(BoutonSearch);
        BoutonSearch.setBounds(1580, 20, 120, 80);

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
        BoutonPanier.addActionListener(e -> {
            changementPageListeners.ChanhementPage(BoutonPanier.getName(), this);
        });

        BandeauSup.add(BoutonPanier);
        BoutonPanier.setBounds(1460, 20, 120, 80);

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

    public Color getMainCouleur(){
        return MainCouleur;
    }

    public Color getSecondeCouleur(){
        return SecondeCouleur;
    }

    public Color getTroisCouleur(){
        return TroisCouleur;
    }

    public Color getQuatreCouleur(){
        return QuatreCouleur;
    }

    public void RefreshPage(){
        // Rafraîchir l'interface utilisateur
        this.getPanelBase().revalidate();
        this.getPanelBase().repaint();
        this.getPanelBase().setVisible(true);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
