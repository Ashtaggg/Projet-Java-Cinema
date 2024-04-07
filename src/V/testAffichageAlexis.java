package V;

import javax.swing.*;
import java.awt.*;
/*import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;*/

import C.MainAlexis;
/*import M.JAVA_MODEL.Global_CLASS.Film;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;*/


public class testAffichageAlexis {
    JFrame test;

    public testAffichageAlexis(){
        this.test = new JFrame("test");
    }

    public void affichage(){
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setLayout(new BorderLayout());
        test.setResizable(false);
        test.setSize(1920, 1080);
        test.setLayout(null);
        
        Color MainCouleur = new Color(250, 250, 250);
        Color SecondeCouleur = new Color(0, 19, 77);
        Color TroisCouleur = new Color(0, 0, 0);

        test.getContentPane().setBackground(MainCouleur);


        /*MainAlexis main = new MainAlexis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        FilmsDAO_IMPL filmsDAO = new FilmsDAO_IMPL();

        Date dateSortie = null;

        try {
            dateSortie = sdf.parse("2002-02-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Film film = new Film(112, "test", 2, dateSortie, "", "1:00:00", "edhgdh", 4.2, 0, "jvjb", "khgu", "uygsvi");*/

        /*JButton bouton = new JButton("Bouton");
        bouton.addActionListener(e -> {
            System.out.println("Appuyé");
            main.boutonAppuye();
            filmsDAO.ajouterFilm(film);
        });
        bouton.setPreferredSize(new Dimension(50, 50));
        test.add(bouton);*/




        JPanel connexion = new JPanel();
        connexion.setBounds(585, 290, 750, 500);
        connexion.setBackground(MainCouleur);
        connexion.setLayout(null);

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        Font font3 = new Font("Arial", Font.BOLD, 15);


        JLabel idLabel = new JLabel("Adresse Mail");
        idLabel.setBounds(150, 20, 185, 24);
        idLabel.setForeground(SecondeCouleur);
        idLabel.setFont(font1);
        connexion.add(idLabel);

        JTextField id = new JTextField(20);
        id.setBounds(150, 60, 450, 40);
        id.setOpaque(false);
        id.setForeground(SecondeCouleur);
        id.setFont(font2);
        connexion.add(id);


        JLabel mdpLabel = new JLabel("Mot de passe");
        mdpLabel.setBounds(150, 150, 190, 24);
        mdpLabel.setForeground(SecondeCouleur);
        mdpLabel.setFont(font1);
        connexion.add(mdpLabel);

        JTextField mdp = new JTextField(20);
        mdp.setBounds(150, 190, 450, 40);
        mdp.setOpaque(false);
        mdp.setForeground(SecondeCouleur);
        mdp.setFont(font2);
        connexion.add(mdp);


        JLabel inscriptionLabel = new JLabel("Pas encore de compte ?");
        inscriptionLabel.setBounds(246, 300, 171, 24);
        inscriptionLabel.setForeground(SecondeCouleur);
        inscriptionLabel.setFont(font3);
        connexion.add(inscriptionLabel);

        JButton inscription = new JButton("Inscription");
        inscription.addActionListener(e -> {
            System.out.println("Inscription...");
        });
        inscription.setBounds(429, 300, 75, 24);
        inscription.setBorder(BorderFactory.createEmptyBorder());
        inscription.setForeground(SecondeCouleur);
        inscription.setBackground(MainCouleur);
        inscription.setFont(font3);
        connexion.add(inscription);

        MainAlexis main = new MainAlexis();
        JButton boutonConnect = new JButton("Connexion");
        boutonConnect.addActionListener(e -> {
            String mail = id.getText();
            String password = mdp.getText();
            
            main.boutonConnexion(mail, password);
        });
        boutonConnect.setBounds(290, 400, 170, 40);
        boutonConnect.setForeground(SecondeCouleur);
        boutonConnect.setBackground(MainCouleur);
        boutonConnect.setFont(font2);
        connexion.add(boutonConnect);

        
        test.setVisible(true);
        test.add(connexion);
    }
}
