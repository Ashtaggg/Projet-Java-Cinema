package V.Paiement;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;

//Imports Librairies
// Importation des librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Text;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.ComponentOrientation;

public class Paiement {

    public static void afficherPaiement(FrameBase frame) {

        frame.PageActuelle = "paiement";
        frame.getPanelBase().removeAll();

        //Pannel Paiement
        JPanel panelPaiement = new JPanel();
        panelPaiement.setLayout(null);
        panelPaiement.setBackground(frame.getMainCouleur());
        panelPaiement.setSize(1000, 800);
        panelPaiement.setBounds(120, 140, 800, 500);
        panelPaiement.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));

        //Labels de Paiement
        JLabel TitrePaiement = new JLabel("Paiement");
        TitrePaiement.setFont(new Font("Arial", Font.BOLD, 37));
        TitrePaiement.setForeground(frame.getSecondeCouleur());
        TitrePaiement.setBounds(920, 20, 300, 50);

        //Panel de séparation
        JPanel panelSeparation = new JPanel();
        panelSeparation.setLayout(null);
        panelSeparation.setBackground(frame.getSecondeCouleur());
        panelSeparation.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        panelSeparation.setSize(1000, 2);
        panelSeparation.setBounds(480, 80, 1000, 2);

        //Ajouter les éléments au panel
        frame.getPanelBase().add(panelPaiement);
        frame.getPanelBase().add(TitrePaiement);
        frame.getPanelBase().add(panelSeparation);

        //Refresh
        frame.RefreshPage();


    }


    
}
