package V;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import C.MainAlexis;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;

public class testAffichageAlexis {
    JFrame test;

    public testAffichageAlexis(){
        this.test = new JFrame("test");
    }

    public void affichage(){
        MainAlexis main = new MainAlexis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        FilmsDAO_IMPL filmsDAO = new FilmsDAO_IMPL();
        Date dateSortie = null;
        try {
            dateSortie = sdf.parse("2002-02-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Film film = new Film(112, "test", 2, dateSortie, "", "1:00:00", "edhgdh", 4.2, 0, "jvjb", "khgu", "uygsvi");
        
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setLayout(new GridLayout(20, 10));

        JLabel truc = new JLabel("sjgefvsiluvhio");
        test.add(truc);

        JButton bouton = new JButton("Bouton");
        bouton.addActionListener(e -> {
            System.out.println("Appuyé");
            main.boutonAppuye();
            filmsDAO.ajouterFilm(film);
        });
        bouton.setPreferredSize(new Dimension(50, 50));
        test.add(bouton);

        test.setSize(1920, 1080);
        test.setVisible(true);
    }
}
