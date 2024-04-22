package V.Accueil;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
//import M.JAVA_MODEL.Global_CLASS.Film;
import V.FrameBase;

//Importation des librairies
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Image;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
//import java.util.List;
//import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import java.awt.*;


public class Accueil_Cinema {

    public static boolean sizePage = false;


    public static void affichageAccueil_Cinema(FrameBase frame){
        frame.PageActuelle = "accueil_cinema";
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
        boutonNews.setForeground(frame.getSecondeCouleur());
        boutonNews.setBorder(null);
        boutonNews.setFocusPainted(false);
        ImageIcon IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Selected.png");        if(frame.DarkMode){IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Blanc.png");}
        else{IconNews = new ImageIcon("images/Images_Projet_V/Icon_Accueil/News_Dark.png");}
        IconNews = new ImageIcon(IconNews.getImage().getScaledInstance(36, 36, Image.SCALE_DEFAULT));
        boutonNews.setIcon(IconNews);
        boutonNews.setHorizontalTextPosition(JButton.RIGHT);
        boutonNews.setVerticalTextPosition(JButton.CENTER);
        boutonNews.setIconTextGap(13);
        //ActionListener
        boutonNews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangementPageListeners.ChangementPage("accueil_news", frame);
            }
        });

        //Bouton Cinema
        JButton boutonCinema = new JButton("Notre Cinema");
        boutonCinema.setFont(new Font("Arial", Font.BOLD, 20));
        boutonCinema.setBackground(frame.getMainCouleur());
        boutonCinema.setForeground(frame.getQuatreCouleur());
        boutonCinema.setBorder(null);
        boutonCinema.setFocusPainted(false);
        ImageIcon IconCinema = new ImageIcon("images/Images_Projet_V/Icon_Accueil/Cinema_Selected.png");
        IconCinema = new ImageIcon(IconCinema.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        boutonCinema.setIcon(IconCinema);
        boutonCinema.setHorizontalTextPosition(JButton.RIGHT);
        boutonCinema.setVerticalTextPosition(JButton.CENTER);
        boutonCinema.setIconTextGap(13);

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

        //Pannels pour les informations pratiques
        JPanel panelInfoP = new JPanel();
        panelInfoP.setLayout(null);
        panelInfoP.setBackground(frame.getMainCouleur());
        panelInfoP.setPreferredSize(new Dimension(1800, 800));
        panelInfoP.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));

        //Map
        ImageIcon MapI = new ImageIcon("images/Images_Projet_V/Map/Map.png");
        MapI = new ImageIcon(MapI.getImage().getScaledInstance(900, 540, Image.SCALE_DEFAULT));
        JLabel MapLabelI = new JLabel(MapI);
        MapLabelI.setBounds(820, 200, 900, 540);
        panelInfoP.add(MapLabelI);

        JLabel InfoCine = new JLabel("<html><br>Toutes nos Informations se trouvent à porté de clic !<br><br><br>" + 
        "Notre Cinéma se situe au 145 Quai de Grenelle à Paris.<br><br>" + 
        "Lévez les yeux et vous vérez cette dame de fer veillant sur nos projections.<br><br><br><br>" + 
        "Nous vous accueillons toute la semaine selon les horraires suivant :<br><br>" + 
        "Lundi : 10h30 - 22h30<br><br>"+
        "Mardi : 10h30 - 22h30<br><br>" +
        "Mercredi : 10h30 - 22h30<br><br>" +
        "Jeudi : 10h30 - 01h30<br><br>" +
        "Vendredi : 10h30 - 01h30<br><br>" +
        "Samedi : 10h30 - 01h30<br><br>" +
        "Dimanche : 10h30 - 22h30<br><br><br><br>" +
        "Pour plus d'informations contactez nous : <br>"+
        "Téléphone : 01 02 03 04 05<br>" +
        "Email : ECECiné@gmail.com</html>");
        InfoCine.setFont(new Font("Arial", Font.PLAIN, 18));
        InfoCine.setForeground(frame.getSecondeCouleur());
        InfoCine.setBounds(180, 50, 580, 800);
        panelInfoP.add(InfoCine);

        contentPanel.add(panelInfoP, gbc);
        gbc.gridy++;
        contentPanel.add(new JLabel(), gbc);
        gbc.gridy++;
        //Pannel Histoire
        JPanel panelNews1 = new JPanel();
        panelNews1.setLayout(new FlowLayout());
        panelNews1.setBackground(frame.getMainCouleur());
        panelNews1.setPreferredSize(new Dimension(1800, 1000));
        panelNews1.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
        gbc.gridy++;
        contentPanel.add(panelNews1, gbc);

       // Redimensionnement de la première image
        ImageIcon avatar2Image1 = new ImageIcon("images\\PhotosProfil\\Alexis.jpg");
        Image image1 = avatar2Image1.getImage().getScaledInstance(368, 490, Image.SCALE_AREA_AVERAGING);
        avatar2Image1 = new ImageIcon(image1);
        JLabel afficherLabel1 = new JLabel(avatar2Image1);
        panelNews1.add(afficherLabel1);

        // Redimensionnement de la deuxième image
        ImageIcon avatar2Image2 = new ImageIcon("images\\PhotosProfil\\Anthony.jpg");
        Image image2 = avatar2Image2.getImage().getScaledInstance(368, 490, Image.SCALE_AREA_AVERAGING);
        avatar2Image2 = new ImageIcon(image2);
        JLabel afficherLabel2 = new JLabel(avatar2Image2);
        panelNews1.add(afficherLabel2);

        // Redimensionnement de la troisième image
        ImageIcon avatar2Image3 = new ImageIcon("images\\PhotosProfil\\Mathis.jpg");
        Image image3 = avatar2Image3.getImage().getScaledInstance(368, 490, Image.SCALE_AREA_AVERAGING);
        avatar2Image3 = new ImageIcon(image3);
        JLabel afficherLabel3 = new JLabel(avatar2Image3);
        panelNews1.add(afficherLabel3);

        JLabel avatar2Description = new JLabel("<html><br><br><br>Nous sommes fiers de vous présenter ECE Cinéma !<br><br><br>" + 
        "Une nouvelle expérience cinématographique née de la vision et de l'ingéniosité de trois jeunes innovateurs.<br><br><br>" + 
        "Fondé en début 2024 par Alexis Raynal, Anthony Sabbagh et Mathis Gras, ECE Cinéma est le fruit de leurs échanges et réflexions sur la façon de révolutionner l'industrie cinématographique.<br><br>" + 
        "Leur passion pour le cinéma et leur désir d'améliorer l'expérience du spectateur les ont amenés à créer un lieu où innovation et divertissement se rencontrent.<br><br><br>" + 
        "Nous sommes impatients de vous accueillir dans nos cinémas, où nous espérons que vous découvrirez une nouvelle approche du cinéma futuriste.<br><br>"+
        "Notre cinéma est composé de :<br><br>" +
        "- Les 35 derniers films en vedette de tous genres.<br><br>" +
        "- 18 salles de cinéma, dont certaines équipées de la technologie 4DX pour une expérience immersive inégalée.<br><br>" +
        "- Plus de 2000 séances vous permettant de venir à n'importe quel moment de la journée pour profiter de nos installations.<br><br>" +
        "Nous sommes impatients de vous accueillir dans nos cinémas et de vous faire vivre une expérience cinématographique exceptionnelle.</html>");
        avatar2Description.setFont(new Font("Arial", Font.BOLD, 18));
        avatar2Description.setForeground(frame.getSecondeCouleur());
        panelNews1.add(avatar2Description);

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
                ChangementPageListeners.ChangementPage("accueil_cinema", frame);
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
        
    }
    
}
