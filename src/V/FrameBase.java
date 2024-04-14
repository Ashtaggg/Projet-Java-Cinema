package V;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.JAVA_MODEL.Global_CLASS.Salle;
//DAO
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO_IMPL;
import M.DAO.DAO_MYSQL_WAMP.Reservations.ReservationsDAO;
import M.DAO.DAO_MYSQL_WAMP.Reservations.ReservationsDAO_IMPL;
import M.DAO.DAO_MYSQL_WAMP.Seances.SeancesDAO;
import M.DAO.DAO_MYSQL_WAMP.Seances.SeancesDAO_IMPL;
import M.DAO.DAO_MYSQL_WAMP.Salles.SallesDAO;
import M.DAO.DAO_MYSQL_WAMP.Salles.SallesDAO_IMPL;
import M.DAO.DAO_MYSQL_WAMP.Utilisateur.UtilisateursDAO;
import M.DAO.DAO_MYSQL_WAMP.Utilisateur.UtilisateursDAO_IMPL;


//Importation des librairies
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Date;

public class FrameBase extends JFrame{

    //Variables
    private JPanel PanelBase;
    public String PageActuelle = "accueil_films";
    // Déclarez BoutonPanierNombre comme une variable de classe
    private JLabel BoutonPanierNombre;

    public Utilisateur userActuel = null;
    public ArrayList<String> PagePrecedente = new ArrayList<>();
    public ArrayList<Film> filmActuel = new ArrayList<>();
    public ArrayList<Seance> seanceActuelle = new ArrayList<>();
    public ArrayList<Salle> salleActuelle = new ArrayList<>();
    public ArrayList<Reservation> reservationActuelle = new ArrayList<>();
    
    //Font
    Font font = new Font("Arial", Font.BOLD, 12);
    //Couelurs :
    public boolean DarkMode = false;
    //Light Mode
    Color MainCouleur_Light = new Color(235, 235, 235);
    Color SecondeCouleur_Light = new Color(0, 19, 77);
    Color TroisCouleur_Light = new Color(62, 96, 193);
    Color QuatreCouleur_Light = new Color(90, 130, 252);
    //Dark Mode
    Color MainCouleur_Dark = new Color(33, 34, 38);
    Color SecondeCouleur_Dark = new Color(210, 235, 255);
    Color TroisCouleur_Dark = new Color(62, 96, 193);
    Color QuatreCouleur_Dark = new Color(90, 130, 252);
    //Couleur actuelle
    Color MainCouleur = MainCouleur_Light;
    Color SecondeCouleur = SecondeCouleur_Light;
    Color TroisCouleur = TroisCouleur_Light;
    Color QuatreCouleur = QuatreCouleur_Light;
    Color CinqCouleur = new Color(244, 255, 1);

    //DAO
    public FilmsDAO filmsDAO = new FilmsDAO_IMPL();
    public BilletDAO billetDAO = new BilletDAO_IMPL();
    public ReservationsDAO reservationsDAO = new ReservationsDAO_IMPL();
    public SeancesDAO seancesDAO = new SeancesDAO_IMPL();
    public SallesDAO sallesDAO = new SallesDAO_IMPL();
    public UtilisateursDAO utilisateursDAO = new UtilisateursDAO_IMPL();


    //Constructeur
    public FrameBase(){
        //Setting basique de la fenêtre
        super("Projet Java Cinéma");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setVisible(true);
        PagePrecedente.add("accueil_films");
        if(DarkMode){
            MainCouleur = MainCouleur_Dark;
            SecondeCouleur = SecondeCouleur_Dark;
            TroisCouleur = TroisCouleur_Dark;
            QuatreCouleur = QuatreCouleur_Dark;
        }
        this.getContentPane().setBackground(MainCouleur);

        //Initialisation des variables à enlever avec la partie de Anhto
        reservationActuelle.add(new Reservation(0, 0, 365, 0, 0));
        seanceActuelle.add(seancesDAO.recupererSeanceByID(626)); //Récupérer Séance 626
        seancesDAO.afficherSeance(seanceActuelle.get(0));
        seancesDAO.afficherSeance(seancesDAO.recupererSeanceByID(626));
        salleActuelle.add(sallesDAO.recupererSalleByID(seanceActuelle.get(0).getIdSalle()));
        sallesDAO.afficherSalle(salleActuelle.get(0));
        filmActuel.add(filmsDAO.recupererFilmByID(seanceActuelle.get(0).getIdFilm()));
        filmsDAO.afficherFilm(filmActuel.get(0));


        //Class de Listener pour les boutons
        ChangementPageListeners changementPageListeners = new ChangementPageListeners();
        RechercheListeners rechercheListeners = new RechercheListeners();

        //Changer Logo de la Page
        ImageIcon Logo_ECE = new ImageIcon("images/Logo_ECE_Frame/ECE_Logo.jpg");
        this.setIconImage(Logo_ECE.getImage());


        //Création du bandeau bleu en haut de la page
        JPanel BandeauSup = new JPanel();
        BandeauSup.setLayout(null);
        BandeauSup.setBackground(SecondeCouleur_Light);
        BandeauSup.setBounds(0, 0, 1920, 120);

        //Ajout de notre Logo en haut à gauche du bandeau = Bouton caché pour retourner à l'accueil
        ImageIcon LogoProjet = new ImageIcon("images/Logo.jpeg");
        JButton BoutonLogo_Accueil = new JButton();
        BoutonLogo_Accueil.setIcon(new ImageIcon(LogoProjet.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
        BoutonLogo_Accueil.setOpaque(true);
        BoutonLogo_Accueil.setFocusable(false);
        BoutonLogo_Accueil.setBorderPainted(false);
        BoutonLogo_Accueil.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonLogo_Accueil.setName("accueil_films");
        BoutonLogo_Accueil.addActionListener(e -> {
            changementPageListeners.ChangementPage(BoutonLogo_Accueil.getName(), this);
        });

        BandeauSup.add(BoutonLogo_Accueil);
        BoutonLogo_Accueil.setBounds(100, 15, 90, 90);

        //Bouton Retour à la page précédente
        JButton BoutonRetour = new JButton();
        ImageIcon IconeRetour = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Retour_Left_Blanc.png");
        BoutonRetour.setIcon(new ImageIcon(IconeRetour.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
        BoutonRetour.setOpaque(true);
        BoutonRetour.setFocusable(false);
        BoutonRetour.setBorderPainted(false);
        BoutonRetour.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonRetour.addActionListener(e -> {
            String Pagetampon = PagePrecedente.get(PagePrecedente.size() - 1);
            changementPageListeners.ChangementPage(Pagetampon, this);
        });

        BandeauSup.add(BoutonRetour);
        BoutonRetour.setBounds(30, 43, 35, 35);

        //Ajout de l'icon pour le Dark Mode
        ImageIcon IconeDarkMode = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Mode_Blanc.png");
        JButton BoutonDarkMode = new JButton();
        BoutonDarkMode.setIcon(new ImageIcon(IconeDarkMode.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        BoutonDarkMode.setOpaque(true);
        BoutonDarkMode.setFocusable(false);
        BoutonDarkMode.setBorderPainted(false);
        BoutonDarkMode.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonDarkMode.setName("dark_mode");
        BoutonDarkMode.addActionListener(e -> {
            if(DarkMode){
                MainCouleur = MainCouleur_Light;
                SecondeCouleur = SecondeCouleur_Light;
                TroisCouleur = TroisCouleur_Light;
                QuatreCouleur = QuatreCouleur_Light;
                this.getContentPane().setBackground(MainCouleur);
                PanelBase.setBackground(MainCouleur);
                DarkMode = false;
            }else{
                MainCouleur = MainCouleur_Dark;
                SecondeCouleur = SecondeCouleur_Dark;
                TroisCouleur = TroisCouleur_Dark;
                QuatreCouleur = QuatreCouleur_Dark;
                this.getContentPane().setBackground(MainCouleur);
                PanelBase.setBackground(MainCouleur);
                DarkMode = true;
            }
            this.RefreshPage();
            changementPageListeners.ChangementPage(PageActuelle, this);
        });

        BandeauSup.add(BoutonDarkMode);
        BoutonDarkMode.setBounds(1830, 40, 40, 40);

        //Bouton d'accès à l'administration en haut à droite
        JButton BoutonAdmin = new JButton();
        ImageIcon IconeAdmin = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/Admin_Blanc.png");
        BoutonAdmin.setIcon(new ImageIcon(IconeAdmin.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        BoutonAdmin.setText("Admin");
        BoutonAdmin.setHorizontalTextPosition(JButton.CENTER);
        BoutonAdmin.setVerticalTextPosition(JButton.BOTTOM);
        BoutonAdmin.setFont(new Font("Arial", Font.BOLD, 12));
        BoutonAdmin.setIconTextGap(13);
        BoutonAdmin.setForeground(Color.WHITE);
        BoutonAdmin.setOpaque(true);
        BoutonAdmin.setFocusable(false);
        BoutonAdmin.setBorderPainted(false);
        BoutonAdmin.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonAdmin.setName("admin");
        BoutonAdmin.addActionListener(e -> {
            changementPageListeners.ChangementPage(BoutonAdmin.getName(), this);
        });

        BandeauSup.add(BoutonAdmin);
        BoutonAdmin.setBounds(1700, 20, 120, 80);

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
        BoutonCompte.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonCompte.setName("compte");
        BoutonCompte.addActionListener(e -> {
            changementPageListeners.ChangementPage(BoutonCompte.getName(), this);
        });

        BandeauSup.add(BoutonCompte);
        BoutonCompte.setBounds(1580, 20, 120, 80);


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
        BoutonPanier.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonPanier.setName("panier");
        BoutonPanier.addActionListener(e -> {
            changementPageListeners.ChangementPage(BoutonPanier.getName(), this);
        });

        //image qui ira au dessus du panier pour indiquer le nombre d'éléments dans le panier
        ImageIcon IconePanierNombre = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/number-"+String.valueOf(reservationActuelle.size())+".png");
        ImageIcon IconePanierNombreResize = new ImageIcon(IconePanierNombre.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        BoutonPanierNombre = new JLabel();
        BoutonPanierNombre.setIcon(IconePanierNombreResize);
        BoutonPanierNombre.setOpaque(true);
        BoutonPanierNombre.setFocusable(false);
        BoutonPanierNombre.setBorder(null);
        BoutonPanierNombre.setBackground(SecondeCouleur_Light);
       // BoutonPanierNombre.setEnabled(false);
        BoutonPanierNombre.setBounds(0, 0, 20, 20);
        BoutonPanier.add(BoutonPanierNombre, Integer.valueOf(1));           

        BandeauSup.add(BoutonPanier);
        BoutonPanier.setBounds(1460, 20, 120, 80);

        //Bouton de recherche en haut à gauche à droite du Logo
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
        BoutonSearch.setBackground(SecondeCouleur_Light);
        //Action du bouton
        BoutonSearch.setName("search_globale");
        BoutonSearch.addActionListener(e -> {
            rechercheListeners.actionPerformed(BoutonSearch.getName(), this);
        });

        BandeauSup.add(BoutonSearch);
        BoutonSearch.setBounds(195, 20, 120, 80);

        //Panel pour le reste de la page à actualiser en focntion de la page
        PanelBase = new JPanel();
        PanelBase.setBackground(MainCouleur);
        PanelBase.setBounds(0, 120, 1920, 960);
        //PanelBase.setBackground(Color.YELLOW);
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

    public Color getCinqCouleur(){
        return CinqCouleur;
    }

    public Font getFont(){
        return font;
    }

    public void RefreshPage(){
        // Rafraîchir l'interface utilisateur
        this.getPanelBase().revalidate();
        this.getPanelBase().repaint();
        this.getPanelBase().setVisible(true);
    
        // Mettre à jour l'icône du BoutonPanierNombre avec le nombre actuel d'éléments dans le panier
        int nombreElementsPanier = reservationActuelle.size();
        ImageIcon iconPanierNombre = new ImageIcon("images/Images_Projet_V/Icon_FrameBase/number-" + nombreElementsPanier + ".png");
        ImageIcon iconPanierNombreResize = new ImageIcon(iconPanierNombre.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        BoutonPanierNombre.setIcon(iconPanierNombreResize);
    
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
