package V.Accueil;

import V.FrameBase;
//import V.Panier.Panier;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.Global_CLASS.Film;
import V.FilmInfo.DateSéances;
/*import java.util.List;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;*/
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Accueil_News {

    //private static Panier panier = new Panier();

    public static boolean sizePage = false;
    public static int filmCarroussel = 0;
    public static Timer timer;


    public static void affichageAccueil_News(FrameBase frame){
        frame.PageActuelle = "accueil_news";
        frame.getPanelBase().removeAll();

        // Créer un nouveau JPanel pour contenir tous les composants
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible
        contentPanel.setBackground(frame.getMainCouleur());
        contentPanel.setBounds(0, 0, 500, 5000);

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique

        //Petit bandeau avec titre Fillms Cinema et News
        JPanel panelTitre = new JPanel();
        panelTitre.setLayout(new GridLayout());
        panelTitre.setBackground(frame.getMainCouleur());
        panelTitre.setPreferredSize(new Dimension(1886, 100));
        panelTitre.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));  
        panelTitre.setBounds(0, 0, 1920, 70);
        contentPanel.add(panelTitre, gbc);

        //Bouton Films
        JButton boutonFilms = new JButton("Nos Films");
        boutonFilms.setFont(new Font("Arial", Font.BOLD, 20));
        boutonFilms.setBackground(frame.getMainCouleur());
        boutonFilms.setForeground(frame.getSecondeCouleur());
        boutonFilms.setBorder(null);
        boutonFilms.setFocusPainted(false);
        ImageIcon IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Selected.png");
        if(frame.DarkMode){IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Blanc.png");}
        else{IconFilm = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Film_Dark.png");}
        IconFilm = new ImageIcon(IconFilm.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonFilms.setIcon(IconFilm);
        boutonFilms.setHorizontalTextPosition(JButton.RIGHT);
        boutonFilms.setVerticalTextPosition(JButton.CENTER);
        boutonFilms.setIconTextGap(13);
        //ActionListener
        boutonFilms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_films", frame);
            }
        });


        //Bouton News
        JButton boutonNews = new JButton("Nos News");
        boutonNews.setFont(new Font("Arial", Font.BOLD, 20));
        boutonNews.setBackground(frame.getMainCouleur());
        boutonNews.setForeground(frame.getQuatreCouleur());
        boutonNews.setBorder(null);
        boutonNews.setFocusPainted(false);
        ImageIcon IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Selected.png");;
        IconNews = new ImageIcon(IconNews.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonNews.setIcon(IconNews);
        boutonNews.setHorizontalTextPosition(JButton.RIGHT);
        boutonNews.setVerticalTextPosition(JButton.CENTER);
        boutonNews.setIconTextGap(13);

        //Bouton Cinema
        JButton boutonCinema = new JButton("Notre Cinema");
        boutonCinema.setFont(new Font("Arial", Font.BOLD, 20));
        boutonCinema.setBackground(frame.getMainCouleur());
        boutonCinema.setForeground(frame.getSecondeCouleur());
        boutonCinema.setBorder(null);
        boutonCinema.setFocusPainted(false);
        ImageIcon IconCinema = null;
        if(frame.DarkMode){IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Blanc.png");}
        else{IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Dark.png");}
        IconCinema = new ImageIcon(IconCinema.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        boutonCinema.setIcon(IconCinema);
        boutonCinema.setHorizontalTextPosition(JButton.RIGHT);
        boutonCinema.setVerticalTextPosition(JButton.CENTER);
        boutonCinema.setIconTextGap(13);
        //ActionListener
        boutonCinema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_cinema", frame);
            }
        });

        //Ajout des boutons au panel
        panelTitre.add(boutonFilms);
        panelTitre.add(boutonNews);
        panelTitre.add(boutonCinema);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.ipady = 100;
        contentPanel.add(new JLabel(), gbc);
        gbc.gridy++;
        gbc.ipady = 80;

        //FilmsDAO_IMPL filmsDAO = new FilmsDAO_IMPL();
        //List<Film> films = filmsDAO.recupererTousLesFilms(); // Méthode pour récupérer tous les films depuis la base de données

        //Panel pour le carroussel

        JPanel PanelCar = new JPanel();
        PanelCar.setLayout(null);
        PanelCar.setBackground(frame.getMainCouleur());
        PanelCar.setPreferredSize(new Dimension(1400, 400));
        PanelCar.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        PanelCar.setBounds(0, 0, 1400, 350);

        //Titre Nos Dernières sorties
        JLabel TitreCarroussel = new JLabel("Nos Dernières Sorties");
        TitreCarroussel.setFont(new Font("Arial", Font.BOLD, 30));
        TitreCarroussel.setForeground(frame.getSecondeCouleur());
        TitreCarroussel.setBounds(510, 10, 400, 50);
        PanelCar.add(TitreCarroussel);

        JButton BLeft = new JButton();
        BLeft.setBackground(frame.getMainCouleur());
        BLeft.setForeground(frame.getSecondeCouleur());
        BLeft.setBorder(null);
        BLeft.setFocusPainted(false);
        BLeft.setText("<");
        BLeft.setBounds(140, 255, 50, 50);
        BLeft.setFont(new Font("Arial", Font.BOLD, 40));
        BLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(filmCarroussel == 0){filmCarroussel = 9;}
                else{filmCarroussel--;}
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });

        JButton BRight = new JButton();
        BRight.setBackground(frame.getMainCouleur());
        BRight.setForeground(frame.getSecondeCouleur());
        BRight.setBorder(null);
        BRight.setFocusPainted(false);
        BRight.setText(">");
        BRight.setBounds(1200, 255, 50, 50);
        BRight.setFont(new Font("Arial", Font.BOLD, 40));
        BRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(filmCarroussel == 9){filmCarroussel = 0;}
                else{filmCarroussel++;}
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });

        PanelCar.add(BLeft);
        PanelCar.add(BRight);

        //Faire défiler automatiquement les films du carroussel toutes les 5 secondes
        // Faire défiler automatiquement les films du carrousel toutes les 5 secondes
        timer = new Timer(7000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(filmCarroussel == 9){
                    filmCarroussel = 0;
                } else {
                    filmCarroussel++;
                }
                timer.stop();
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });
        timer.start(); // N'oubliez pas de démarrer le timer

        //Panel pour les films du carroussel
        JPanel PanelFilms = new JPanel();
        PanelFilms.setLayout(new FlowLayout());
        PanelFilms.setBackground(frame.getMainCouleur());
        PanelFilms.setPreferredSize(new Dimension(250, 330));
        PanelFilms.setBorder(null);
        PanelFilms.setBounds(555, 110, 250, 335);


        List<Film> films = new ArrayList<Film>();
        films = frame.filmsDAO.recupererFilmsRecents();

        //Afficher l'affiche du film et son titre à l'index filmCarroussel
        BufferedImage imageC = ConvertirImageHexa.HexToImage(films.get(filmCarroussel).getPhoto());
        Image image2 = imageC.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        JLabel afficheLabel = new JLabel(new ImageIcon(image2));
        afficheLabel.setText(films.get(filmCarroussel).getNom());
        afficheLabel.setFont(new Font("Arial", Font.BOLD, 20));
        afficheLabel.setForeground(frame.getSecondeCouleur());
        afficheLabel.setHorizontalTextPosition(JLabel.CENTER);
        afficheLabel.setVerticalTextPosition(JLabel.BOTTOM);
        afficheLabel.setHorizontalAlignment(JLabel.CENTER);
        afficheLabel.setVerticalAlignment(JLabel.CENTER);
        afficheLabel.setIconTextGap(10);

        Film filmPassage = films.get(filmCarroussel);
        afficheLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.filmActuel.add(filmPassage);
                //ChangementPageListeners.ChangementPage("date_seance", frame);
                timer.stop();
                DateSéances.affichageDateSeances(frame);
            }
        });

        PanelFilms.add(afficheLabel);

        PanelCar.add(PanelFilms);

        //Ajouter l'image du rideau gauche à gauche de l'affiche du film
        ImageIcon rideauGauche = new ImageIcon("images/Images_Projet_V/Icon_News/blinds_gauche.png");
        rideauGauche = new ImageIcon(rideauGauche.getImage().getScaledInstance(150, 380, Image.SCALE_DEFAULT));
        JLabel rideauGaucheLabel = new JLabel(rideauGauche);
        rideauGaucheLabel.setBounds(370, 90, 150, 380);
        PanelCar.add(rideauGaucheLabel);

        //Ajouter l'image du rideau droit à droite de l'affiche du film
        ImageIcon rideauDroit = new ImageIcon("images/Images_Projet_V/Icon_News/blinds_droite.png");
        rideauDroit = new ImageIcon(rideauDroit.getImage().getScaledInstance(150, 380, Image.SCALE_DEFAULT));
        JLabel rideauDroitLabel = new JLabel(rideauDroit);
        rideauDroitLabel.setBounds(835, 90, 150, 380);
        PanelCar.add(rideauDroitLabel);

        gbc.gridy++;

        contentPanel.add(PanelCar, gbc);

        gbc.gridy++;

        contentPanel.add(new JLabel(), gbc);

        // News 1: Avatar 2
        JPanel panelNews1 = new JPanel();
        panelNews1.setLayout(new FlowLayout());
        panelNews1.setBackground(frame.getMainCouleur());
        panelNews1.setPreferredSize(new Dimension(1200, 250));
        panelNews1.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        panelNews1.setBounds(0, 0, 1020, 200);
        gbc.gridy++;
        contentPanel.add(panelNews1, gbc);

        //JLabel avatar2Label = new JLabel();
        ImageIcon avatar2Image = new ImageIcon("images\\images bdd\\Avatar la voie de l'eau.jpg");
        Image image = avatar2Image.getImage().getScaledInstance(155, 210, Image.SCALE_AREA_AVERAGING);
        avatar2Image = new ImageIcon(image);
        JLabel afficherLabel = new JLabel(avatar2Image);
        panelNews1.add(afficherLabel);

        JLabel avatar2Description = new JLabel("<html>Voici le nouveau film en salle disponible dans tous vos cinémas ECE. Profitez-en le monde de James Cameron n'attend que vous !<br>Film également disponible en 4DX.</html>");
        avatar2Description.setFont(new Font("Arial", Font.BOLD, 14));
        avatar2Description.setForeground(frame.getSecondeCouleur());
        panelNews1.add(avatar2Description);

        gbc.gridy++;

        contentPanel.add(new JLabel(), gbc);

        gbc.gridy++;

        // News 2: Service de stands
        JPanel panelNews2 = new JPanel();
        panelNews2.setLayout(new BorderLayout());
        panelNews2.setBackground(frame.getMainCouleur());
        panelNews2.setPreferredSize(new Dimension(1200, 200));
        panelNews2.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        gbc.gridy++;
        contentPanel.add(panelNews2, gbc);

        JLabel eceLogoLabel = new JLabel();
        ImageIcon eceLogoImage = new ImageIcon("images\\images_Projet_V\\Icon_ReservationSeance\\New.png"); // Mettez le chemin correct vers le logo ECE Cinéma
        eceLogoLabel.setIcon(eceLogoImage);
        panelNews2.add(eceLogoLabel, BorderLayout.WEST);

        JLabel eceServiceDescription = new JLabel("Les news de la semaine : entre pop corn et bonbons, ECE Cinéma est fière de vous présenter un service de stands disponible dans tous vos cinémas ECE, notre personnel vous attends nombreux et nombreuses !");
        eceServiceDescription.setFont(new Font("Arial", Font.BOLD, 14));
        eceServiceDescription.setForeground(frame.getSecondeCouleur());
        panelNews2.add(eceServiceDescription, BorderLayout.CENTER);

        gbc.gridy++;

        contentPanel.add(new JLabel(), gbc);

        gbc.gridy++;

        // News 3: Mois à 3 euros
        JPanel panelNews3 = new JPanel();
        panelNews3.setLayout(new BorderLayout());
        panelNews3.setBackground(frame.getMainCouleur());
        panelNews3.setPreferredSize(new Dimension(1200, 200));
        panelNews3.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        gbc.gridy++;
        contentPanel.add(panelNews3, gbc);

        JLabel eceLogoLabel2 = new JLabel();
        eceLogoLabel2.setIcon(eceLogoImage); // Réutilisez le même logo ECE Cinéma
        panelNews3.add(eceLogoLabel2, BorderLayout.WEST);

        JLabel mois3EurosDescription = new JLabel("<html>D'ici le mois de juillet afin de passer un été ensemble, ECE Cinéma vous offrira la possibilité de venir voir tous vos films à 3 euros seulement tout âge confondus.<br><br>Conditions générales : les films 4DX ne sont pas compris dans l'offre que vous visionnez</html>");
        mois3EurosDescription.setFont(new Font("Arial", Font.BOLD, 14));
        mois3EurosDescription.setForeground(frame.getSecondeCouleur());
        panelNews3.add(mois3EurosDescription, BorderLayout.CENTER);

        gbc.gridy++;
        gbc.ipady = 80;
        contentPanel.add(new JLabel(), gbc);

        

        //Footer avec nos conditions de ventes, cooerdonnées et mentions légales + Map

        // Ajouter un footer
        JPanel footer = new JPanel();
        footer.setBackground(frame.getSecondeCouleur());
        footer.setVisible(true);
        footer.setOpaque(true);
        footer.setPreferredSize(new Dimension(1886, 200));
        footer.setLayout(null);
        footer.setBorder(BorderFactory.createLineBorder(frame.getMainCouleur(), 2));
        //Conditions de vente
        JLabel ConditionsVente = new JLabel("Conditions de vente");
        ConditionsVente.setFont(new Font ("Arial", Font.PLAIN, 23));
        ConditionsVente.setForeground(frame.getMainCouleur());
        ConditionsVente.setBounds(50, 10, 250, 50);
        footer.add(ConditionsVente);
        //Texte des conditions de vente pour l'instant invisible
        JLabel TexteConditionsVente = new JLabel("<html>Politique d'Annulation et de Remboursement :<br>" +
        "Les billets achetés ne sont ni échangeables ni remboursables, sauf en cas d'annulation d'une séance par le cinéma.<br>" +
        "Les remboursements pour les annulations de séances seront traités conformément à la politique de remboursement en vigueur du cinéma.<br><br>" +
        "Disponibilité des Places :<br>" +
        "La disponibilité des places est limitée et n'est pas garantie jusqu'à ce que la réservation soit confirmée et payée.<br><br>" +
        "Responsabilité :<br>" +
        "Nous ne sommes pas responsables des pertes, dommages, coûts ou dépenses résultant de l'utilisation de notre application ou de l'achat de billets de cinéma via celle-ci.<br><br>" +
        "Conditions d'Utilisation :<br>" +
        "L'utilisation de cette application est soumise à nos Conditions Générales d'Utilisation, consultables sur notre site web.<br><br>" +
        "Sécurité des Transactions :<br>" +
        "Nous prenons des mesures de sécurité pour protéger les informations de paiement de nos utilisateurs, mais nous ne pouvons garantir la sécurité absolue des transactions en ligne.<br><br>" +
        "Modification des Conditions de Vente :<br>" +
        "Nous nous réservons le droit de modifier les présentes conditions de vente à tout moment sans préavis. Les modifications seront effectives dès leur publication sur l'application.<br><br>" +
        "Droits d'Auteur :<br>" +
        "Tous les contenus présents sur l'application, y compris les images, les logos et les textes, sont protégés par des droits d'auteur et ne peuvent être utilisés sans autorisation.<br><br>" +
        "Loi Applicable :<br>" +
        "Les présentes conditions de vente sont régies par les lois en vigueur dans votre juridiction.<br><br>" +
        "Contact :<br>" +
        "Pour toute question ou réclamation concernant les billets de cinéma réservés via notre application, veuillez nous contacter à l'adresse électronique ou au numéro de téléphone fourni sur l'application.</html>");


        TexteConditionsVente.setFont(new Font ("Arial", Font.PLAIN, 23));
        TexteConditionsVente.setForeground(frame.getMainCouleur());
        TexteConditionsVente.setBounds(50, 250, 1750, 800);
        if(sizePage){footer.add(TexteConditionsVente);}
        //Bouton pour afficher les conditions de vente
        JButton ConditionsVenteButton = new JButton("Voir");
        ConditionsVenteButton.setFont(new Font ("Arial", Font.PLAIN, 23));
        ConditionsVenteButton.setForeground(frame.getMainCouleur());
        ConditionsVenteButton.setBackground(frame.getTroisCouleur());
        ConditionsVenteButton.setBorder(BorderFactory.createLineBorder(frame.getMainCouleur(), 2));
        ConditionsVenteButton.setBounds(85, 80, 100, 50);
        footer.add(ConditionsVenteButton);
        //Action Listeners pour le bouton des conditions de vente
        ConditionsVenteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Afficher ou cacher les conditions de vente
                if(TexteConditionsVente.isVisible()){TexteConditionsVente.setVisible(false);}
                else{TexteConditionsVente.setVisible(true);}
                sizePage = !sizePage;
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });

        //Coordonnées
        JLabel Coordonnees = new JLabel("Coordonnées");
        Coordonnees.setFont(new Font ("Arial", Font.PLAIN, 23));
        Coordonnees.setForeground(frame.getMainCouleur());
        Coordonnees.setBounds(500, 10, 250, 50);
        footer.add(Coordonnees);
        //Texte des coordonnées
        JLabel TexteCoordonnees = new JLabel("<html>Adresse : 145 Quai de Grenelle, Paris<br>" +
        "Téléphone : 01 02 03 04 05<br>" +
        "Email : ECECiné@gmail.com</html>");
        TexteCoordonnees.setFont(new Font ("Arial", Font.PLAIN, 20));
        TexteCoordonnees.setForeground(frame.getMainCouleur());
        TexteCoordonnees.setBounds(500, 80, 500, 100);
        footer.add(TexteCoordonnees);
        //Mentions légales
        JLabel MentionsLegales = new JLabel("Mentions légales");
        MentionsLegales.setFont(new Font ("Arial", Font.PLAIN, 23));
        MentionsLegales.setForeground(frame.getMainCouleur());
        MentionsLegales.setBounds(950, 10, 250, 50);
        footer.add(MentionsLegales);
        //Texte des mentions légales
        JLabel TexteMentionsLegales = new JLabel("<html>Ce site a été créé dans le cadre d'un projet scolaire de l'ECE Paris.<br>" +
        "Il n'a pas vocation à être commercialisé et ne génère aucun revenu.<br>" +
        "Les images et logos utilisés sont la propriété de leurs auteurs respectifs.<br>" +
        "Pour toute réclamation, veuillez nous contacter à l'adresse électronique fournie.</html>");
        TexteMentionsLegales.setFont(new Font ("Arial", Font.PLAIN, 20));
        TexteMentionsLegales.setForeground(frame.getMainCouleur());
        TexteMentionsLegales.setBounds(950, 80, 500, 100);
        footer.add(TexteMentionsLegales);
        //Map
        ImageIcon Map = new ImageIcon("images/Images_Projet_V/Map/Map.png");
        Map = new ImageIcon(Map.getImage().getScaledInstance(300, 180, Image.SCALE_DEFAULT));
        JLabel MapLabel = new JLabel(Map);
        MapLabel.setBounds(1470, 10, 300, 180);
        footer.add(MapLabel);

        // Ajouter footer avec GridBagLayout
        gbc.gridx = 0;
        gbc.gridy += 2; // Aller à la ligne suivante
        gbc.ipady = 0;
        if(sizePage){gbc.ipady = 950;} // Hauteur spécifique
        contentPanel.add(footer, gbc);

        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 0));
        scrollPane.setBorder(null);
        scrollPane.setBounds(0, 0, 1905, 921); // Ajustez la taille selon vos besoins


        frame.getPanelBase().add(scrollPane);

        frame.RefreshPage();
    }}
