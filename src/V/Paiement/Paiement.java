package V.Paiement;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.DAO.DAO_MYSQL_WAMP.Billets.BilletDAO;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import M.JAVA_MODEL.ImagesModifs.ImageIconRounded;

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
import java.awt.TextField;
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

import com.toedter.calendar.JDateChooser;


public class Paiement {

    public static void afficherPaiement(FrameBase frame) {

        frame.PageActuelle = "paiement";
        frame.getPanelBase().removeAll();

        Font font1 = new Font("Arial", Font.BOLD, 34);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        //Pannel Paiement
        /*JPanel panelPaiement = new JPanel();
        panelPaiement.setLayout(null);
        panelPaiement.setBackground(frame.getMainCouleur());
        panelPaiement.setSize(1000, 800);
        panelPaiement.setBounds(120, 140, 800, 500);
        panelPaiement.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));*/

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

        JPanel carte = new JPanel();
        carte.setBounds(120, 140, 800, 500);
        carte.setBackground(frame.getMainCouleur());
        carte.setLayout(null);
        carte.setBorder(new RoundBorder(frame.getSecondeCouleur(), 40, 2));

        JLabel carteLabel = new JLabel("Carte de Crédit");
        carteLabel.setBounds(20, 28, 385, 28);
        carteLabel.setForeground(frame.getSecondeCouleur());
        carteLabel.setFont(font1);
        carte.add(carteLabel);

        JLabel logo1Label = new JLabel(")");
        logo1Label.setBounds(15, 100, 185, 30);
        logo1Label.setForeground(frame.getSecondeCouleur());
        logo1Label.setFont(new Font("Arial", Font.BOLD, 15));
        carte.add(logo1Label);

        JLabel logo2Label = new JLabel(")");
        logo2Label.setBounds(20, 100, 185, 30);
        logo2Label.setForeground(frame.getSecondeCouleur());
        logo2Label.setFont(new Font("Arial", Font.BOLD, 21));
        carte.add(logo2Label);

        JLabel logo3Label = new JLabel(")");
        logo3Label.setBounds(25, 100, 185, 30);
        logo3Label.setForeground(frame.getSecondeCouleur());
        logo3Label.setFont(new Font("Arial", Font.BOLD, 27));
        carte.add(logo3Label);

        JLabel logo4Label = new JLabel(")");
        logo4Label.setBounds(32, 92, 185, 45);
        logo4Label.setForeground(frame.getSecondeCouleur());
        logo4Label.setFont(new Font("Arial", Font.BOLD, 33));
        carte.add(logo4Label);

        if(frame.userActuel!=null){
            String numeroCarte = frame.userActuel.getCarteNum();
            StringBuilder numeroCarte2 = new StringBuilder();

            for (int i = 0; i < numeroCarte.length(); i++) {
                if (i > 0 && i % 4 == 0) {
                    numeroCarte2.append(" ");
                }
                numeroCarte2.append(numeroCarte.charAt(i));
            }

            JLabel carteNum = new JLabel(numeroCarte2.toString());
            carteNum.setBounds(35, 110, 200, 24);
            carteNum.setForeground(frame.getSecondeCouleur());
            carteNum.setFont(font2);
            carte.add(carteNum);


            JLabel carteDateLabel = new JLabel("EXPIRE");
            carteDateLabel.setBounds(75, 135, 185, 24);
            carteDateLabel.setForeground(frame.getSecondeCouleur());
            carteDateLabel.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteDateLabel);

            JLabel carteDate2Label = new JLabel("A FIN");
            carteDate2Label.setBounds(75, 143, 185, 24);
            carteDate2Label.setForeground(frame.getSecondeCouleur());
            carteDate2Label.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteDate2Label);

            JLabel carteDate = new JLabel(frame.userActuel.getCarteDate());
            carteDate.setBounds(135, 139, 185, 24);
            carteDate.setForeground(frame.getSecondeCouleur());
            carteDate.setFont(font3);
            carte.add(carteDate);


            JLabel carteCCVLabel = new JLabel("CCV");
            carteCCVLabel.setBounds(235, 139, 185, 24);
            carteCCVLabel.setForeground(frame.getSecondeCouleur());
            carteCCVLabel.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteCCVLabel);

            JLabel carteCCV = new JLabel(Integer.toString(frame.userActuel.getCarteCCV()));
            carteCCV.setBounds(270, 139, 185, 24);
            carteCCV.setForeground(frame.getSecondeCouleur());
            carteCCV.setFont(font3);
            carte.add(carteCCV);


            JLabel carteNom = new JLabel(frame.userActuel.getCarteNom());
            carteNom.setBounds(40, 165, 200, 24);
            carteNom.setForeground(frame.getSecondeCouleur());
            carteNom.setFont(font2);
            carte.add(carteNom);

            ImageIcon LogoCB = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/CB.png");
            LogoCB = ChangerCouleurImage.changer(frame, LogoCB);
            Image LogoCB2 = LogoCB.getImage().getScaledInstance(60, 46, Image.SCALE_SMOOTH);
            JLabel logoCB = new JLabel(new ImageIcon(LogoCB2));
            logoCB.setBounds(250, 10, 60, 46);
            carte.add(logoCB);

            ImageIcon LogoFleche = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Fleche.png");
            LogoFleche = ChangerCouleurImage.changer(frame, LogoFleche);
            Image LogoFleche2 = LogoFleche.getImage().getScaledInstance(13, 42, Image.SCALE_SMOOTH);
            JLabel logoFleche = new JLabel(new ImageIcon(LogoFleche2));
            logoFleche.setBounds(10, 130, 13, 42);
            carte.add(logoFleche);

        
            if(frame.userActuel.getCarteNum().charAt(0) == '4'){
                ImageIcon LogoCarte = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Visa.png");
                LogoCarte = ChangerCouleurImage.changer(frame, LogoCarte);
                Image LogoCarte2 = LogoCarte.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
                JLabel logoCarte = new JLabel(new ImageIcon(LogoCarte2));
                logoCarte.setBounds(175, 75, 200, 200);
                carte.add(logoCarte);
            }
            else if(frame.userActuel.getCarteNum().charAt(0) == '5'){
                ImageIcon LogoCarte = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Mastercard.png");
                Image LogoCarte2 = LogoCarte.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
                JLabel logoCarte = new JLabel(new ImageIcon(LogoCarte2));
                logoCarte.setBounds(175, 75, 200, 200);
                carte.add(logoCarte);
            }
            else if(frame.userActuel.getCarteNum().charAt(0) == '3'){
                ImageIcon LogoCarte = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/American-Express.png");
                LogoCarte = ChangerCouleurImage.changer(frame, LogoCarte);
                Image LogoCarte2 = LogoCarte.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
                JLabel logoCarte = new JLabel(new ImageIcon(LogoCarte2));
                logoCarte.setBounds(175, 75, 200, 200);
                carte.add(logoCarte);
            }
        }
        else{
            String numeroCarte = "Votre Numéro de Carte";
            
            JTextField carteNum = new JTextField(numeroCarte.toString());
            carteNum.setBounds(35, 140, 200, 24);
            carteNum.setForeground(frame.getSecondeCouleur());
            carteNum.setFont(font2);
            carte.add(carteNum);


            JLabel carteDateLabel = new JLabel("EXPIRE");
            carteDateLabel.setBounds(75, 165, 185, 24);
            carteDateLabel.setForeground(frame.getSecondeCouleur());
            carteDateLabel.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteDateLabel);

            JLabel carteDate2Label = new JLabel("A FIN");
            carteDate2Label.setBounds(75, 183, 185, 24);
            carteDate2Label.setForeground(frame.getSecondeCouleur());
            carteDate2Label.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteDate2Label);

            /*JLabel carteDate = new JLabel(frame.userActuel.getCarteDate());
            carteDate.setBounds(135, 139, 185, 24);
            carteDate.setForeground(frame.getSecondeCouleur());
            carteDate.setFont(font3);
            carte.add(carteDate);*/

            JDateChooser date = new JDateChooser();
            date.setBounds(150, 350, 448, 40);
            date.setDateFormatString("yyyy-MM-dd");
            JTextField dateEditor = ((JTextField) date.getDateEditor());
            dateEditor.setForeground(frame.getSecondeCouleur());
            dateEditor.setBackground(frame.getMainCouleur());
            date.setFont(font2);
            carte.add(date);

            JLabel carteCCVLabel = new JLabel("CCV");
            carteCCVLabel.setBounds(235, 179, 185, 24);
            carteCCVLabel.setForeground(frame.getSecondeCouleur());
            carteCCVLabel.setFont(new Font("Arial", Font.BOLD, 10));
            carte.add(carteCCVLabel);

            /*JLabel carteCCV = new JLabel(Integer.toString(frame.userActuel.getCarteCCV()));
            carteCCV.setBounds(270, 139, 185, 24);
            carteCCV.setForeground(frame.getSecondeCouleur());
            carteCCV.setFont(font3);
            carte.add(carteCCV);*/
            JTextField carteCCV = new JTextField("CCV");
            carteCCV.setBounds(270, 179, 185, 24);
            carteCCV.setForeground(frame.getSecondeCouleur());
            carteCCV.setFont(font3);
            carte.add(carteCCV);


            /*JLabel carteNom = new JLabel(frame.userActuel.getCarteNom());
            carteNom.setBounds(40, 165, 200, 24);
            carteNom.setForeground(frame.getSecondeCouleur());
            carteNom.setFont(font2);
            carte.add(carteNom);*/
            JTextField carteNom = new JTextField("Nom");
            carteNom.setBounds(40, 205, 200, 24);
            carteNom.setForeground(frame.getSecondeCouleur());
            carteNom.setFont(font2);

            ImageIcon LogoCB = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/CB.png");
            LogoCB = ChangerCouleurImage.changer(frame, LogoCB);
            Image LogoCB2 = LogoCB.getImage().getScaledInstance(96, 74, Image.SCALE_SMOOTH);
            JLabel logoCB = new JLabel(new ImageIcon(LogoCB2));
            logoCB.setBounds(680, 20, 96, 74);
            carte.add(logoCB);

            ImageIcon LogoFleche = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Fleche.png");
            LogoFleche = ChangerCouleurImage.changer(frame, LogoFleche);
            Image LogoFleche2 = LogoFleche.getImage().getScaledInstance(13, 42, Image.SCALE_SMOOTH);
            JLabel logoFleche = new JLabel(new ImageIcon(LogoFleche2));
            logoFleche.setBounds(10, 170, 13, 42);
            carte.add(logoFleche);


            ImageIcon LogoCarteVisa = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Visa.png");
            LogoCarteVisa = ChangerCouleurImage.changer(frame, LogoCarteVisa);
            Image LogoCarteVisa2 = LogoCarteVisa.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteVisa = new JLabel(new ImageIcon(LogoCarteVisa2));
            logoCarteVisa.setBounds(175, 275, 200, 200);
            carte.add(logoCarteVisa);

            ImageIcon LogoCarteM = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Mastercard.png");
            Image LogoCarteM2 = LogoCarteM.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteM = new JLabel(new ImageIcon(LogoCarteM2));
            logoCarteM.setBounds(237, 275, 200, 200);
            carte.add(logoCarteM);

            ImageIcon LogoCarteAmex = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/American-Express.png");
            LogoCarteAmex = ChangerCouleurImage.changer(frame, LogoCarteAmex);
            Image LogoCarteAmex2 = LogoCarteAmex.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteAmex = new JLabel(new ImageIcon(LogoCarteAmex2));
            logoCarteAmex.setBounds(299, 275, 200, 200);
            carte.add(logoCarteAmex);

        }

        //Ajouter les éléments au panel
        frame.getPanelBase().add(carte);
        frame.getPanelBase().add(TitrePaiement);
        frame.getPanelBase().add(panelSeparation);

        //Refresh
        frame.RefreshPage();


    }


    
}
