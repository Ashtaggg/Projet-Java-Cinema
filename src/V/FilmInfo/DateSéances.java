package V.FilmInfo;

//Importation des fichiers
import C.Listeners.ChangementPageListeners;
import C.Listeners.RechercheListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import V.FrameBase;
import V.Panier.Panier;
import M.JAVA_MODEL.Global_CLASS.Salle;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO;
import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.Accueil.Films;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import V.FilmInfo.FilmInfo;



//Importation des librairies
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import java.awt.image.BufferedImage;


import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Date;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DateSéances {
    
    public static boolean sizePage = false;

    private static Panier panier = new Panier();

    private static Film filmSelectionne;

    private static List<Film> filmsAReserver = new ArrayList<>();


    public static void affichageDateSeances(FrameBase frame){
        frame.PageActuelle = "date_seance";
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

    }




}
