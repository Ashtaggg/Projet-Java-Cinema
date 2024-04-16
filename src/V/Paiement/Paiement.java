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
import javax.swing.JCheckBox;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Paiement {

    public static void afficherPaiement(FrameBase frame) {

        frame.PageActuelle = "payer";
        frame.getPanelBase().removeAll();

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
        carte.setLayout(null);
        carte.setBackground(frame.getMainCouleur());
        carte.setOpaque(true);
        carte.setLayout(null);
        carte.setBorder(new RoundBorder(frame.getSecondeCouleur(), 40, 2));
        carte.setBounds(220, 140, 800, 500);

        JLabel carteLabel = new JLabel("Carte de Crédit");
        carteLabel.setBounds(40, 32, 385, 40);
        carteLabel.setForeground(frame.getSecondeCouleur());
        carteLabel.setFont(new Font("Arial", Font.BOLD, 37));
        carte.add(carteLabel);

        //Logo Sans Contact
        ImageIcon SansContact = null;
        if(frame.DarkMode){SansContact = new ImageIcon("images/Images_Projet_V/Icon_Paiement/Sans_Contact_Bleu.png");}
        else{SansContact = new ImageIcon("images/Images_Projet_V/Icon_Paiement/Sans_Contact_Dark.png");}
        SansContact = new ImageIcon(SansContact.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel SansContactLabel = new JLabel(SansContact);
        SansContactLabel.setBounds(40, 120, 60, 60);
        carte.add(SansContactLabel);

        if(frame.userActuel!=null){
            String numeroCarte = frame.userActuel.getCarteNum();
            StringBuilder numeroCarte2 = new StringBuilder();

            for (int i = 0; i < numeroCarte.length(); i++) {
                if (i > 0 && i % 4 == 0) {
                    numeroCarte2.append(" ");
                }
                numeroCarte2.append(numeroCarte.charAt(i));
            }

            JTextField carteNum = new JTextField(numeroCarte2.toString());
            carteNum.setBounds(80, 230, 500, 45);
            carteNum.setBackground(frame.getMainCouleur());
            carteNum.setForeground(frame.getSecondeCouleur());
            carteNum.setFont(new Font("Arial", Font.BOLD, 38));
            carte.add(carteNum);


            JLabel carteDateLabel = new JLabel("EXPIRE");
            carteDateLabel.setBounds(175, 320, 185, 24);
            carteDateLabel.setForeground(frame.getSecondeCouleur());
            carteDateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteDateLabel);

            JLabel carteDate2Label = new JLabel("A FIN");
            carteDate2Label.setBounds(175, 342, 185, 24);
            carteDate2Label.setForeground(frame.getSecondeCouleur());
            carteDate2Label.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteDate2Label);

            JDateChooser date = new JDateChooser();
            date.setBounds(275, 320, 180, 40);
            date.setDateFormatString("yyyy-MM-dd");
            JTextField dateEditor = ((JTextField) date.getDateEditor());
            dateEditor.setForeground(frame.getSecondeCouleur());
            dateEditor.setBackground(frame.getMainCouleur());
            date.setFont(new Font("Arial", Font.BOLD, 20));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try{date.setDate(sdf.parse(frame.userActuel.getCarteDate()));}
            catch(ParseException e){e.printStackTrace();}
            carte.add(date);

            JLabel carteCCVLabel = new JLabel("CCV");
            carteCCVLabel.setBounds(575, 320, 85, 34);
            carteCCVLabel.setForeground(frame.getSecondeCouleur());
            carteCCVLabel.setBackground(frame.getMainCouleur());
            carteCCVLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteCCVLabel);

            JTextField carteCCV = new JTextField(Integer.toString(frame.userActuel.getCarteCCV()));
            carteCCV.setBounds(630, 320, 105, 28);
            carteCCV.setForeground(frame.getSecondeCouleur());
            carteCCV.setBackground(frame.getMainCouleur());
            carteCCV.setFont(new Font("Arial", Font.BOLD, 20));
            carte.add(carteCCV);


            JTextField carteNom = new JTextField(frame.userActuel.getCarteNom());
            carteNom.setBounds(110, 400, 340, 34);
            carteNom.setForeground(frame.getSecondeCouleur());
            carteNom.setFont(new Font("Arial", Font.BOLD, 28));
            carteNom.setBackground(frame.getMainCouleur());
            carte.add(carteNom);

            ImageIcon LogoCB = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/CB.png");
            LogoCB = ChangerCouleurImage.changer(frame, LogoCB);
            Image LogoCB2 = LogoCB.getImage().getScaledInstance(96, 74, Image.SCALE_SMOOTH);
            JLabel logoCB = new JLabel(new ImageIcon(LogoCB2));
            logoCB.setBounds(680, 20, 96, 74);
            carte.add(logoCB);

            ImageIcon LogoFleche = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Fleche.png");
            LogoFleche = ChangerCouleurImage.changer(frame, LogoFleche);
            Image LogoFleche2 = LogoFleche.getImage().getScaledInstance(21, 67, Image.SCALE_SMOOTH);
            JLabel logoFleche = new JLabel(new ImageIcon(LogoFleche2));
            logoFleche.setBounds(30, 320, 30, 67);
            carte.add(logoFleche);


            ImageIcon LogoCarteVisa = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Visa.png");
            LogoCarteVisa = ChangerCouleurImage.changer(frame, LogoCarteVisa);
            Image LogoCarteVisa2 = LogoCarteVisa.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteVisa = new JLabel(new ImageIcon(LogoCarteVisa2));
            logoCarteVisa.setBounds(550, 400, 62, 35);
            carte.add(logoCarteVisa);

            //Label / pour les cartes
            JLabel slash = new JLabel("/");
            slash.setBounds(630, 405, 10, 24);
            slash.setForeground(frame.getSecondeCouleur());
            slash.setFont(new Font("Arial", Font.BOLD, 32));
            carte.add(slash);

            ImageIcon LogoCarteM = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Mastercard.png");
            Image LogoCarteM2 = LogoCarteM.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteM = new JLabel(new ImageIcon(LogoCarteM2));
            logoCarteM.setBounds(645, 400, 62, 35);
            carte.add(logoCarteM);

            //Label / pour les cartes
            JLabel slash2 = new JLabel("/");
            slash2.setBounds(715, 405, 10, 24);
            slash2.setForeground(frame.getSecondeCouleur());
            slash2.setFont(new Font("Arial", Font.BOLD, 32));
            carte.add(slash2);

            ImageIcon LogoCarteAmex = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/American-Express.png");
            LogoCarteAmex = ChangerCouleurImage.changer(frame, LogoCarteAmex);
            Image LogoCarteAmex2 = LogoCarteAmex.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteAmex = new JLabel(new ImageIcon(LogoCarteAmex2));
            logoCarteAmex.setBounds(730, 400, 62, 35);
            carte.add(logoCarteAmex);
        }
        else{
            String numeroCarte = "Votre Numéro de Carte";
            
            JTextField carteNum = new JTextField(numeroCarte.toString());
            carteNum.setBounds(80, 230, 500, 45);
            carteNum.setBackground(frame.getMainCouleur());
            carteNum.setForeground(frame.getSecondeCouleur());
            carteNum.setFont(new Font("Arial", Font.BOLD, 38));
            carte.add(carteNum);


            JLabel carteDateLabel = new JLabel("EXPIRE");
            carteDateLabel.setBounds(175, 320, 185, 24);
            carteDateLabel.setForeground(frame.getSecondeCouleur());
            carteDateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteDateLabel);

            JLabel carteDate2Label = new JLabel("A FIN");
            carteDate2Label.setBounds(175, 342, 185, 24);
            carteDate2Label.setForeground(frame.getSecondeCouleur());
            carteDate2Label.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteDate2Label);

            JDateChooser date = new JDateChooser();
            date.setBounds(275, 320, 180, 40);
            date.setDateFormatString("yyyy-MM-dd");
            JTextField dateEditor = ((JTextField) date.getDateEditor());
            dateEditor.setForeground(frame.getSecondeCouleur());
            dateEditor.setBackground(frame.getMainCouleur());
            date.setFont(new Font("Arial", Font.BOLD, 20));
            carte.add(date);

            JLabel carteCCVLabel = new JLabel("CCV");
            carteCCVLabel.setBounds(575, 320, 85, 34);
            carteCCVLabel.setForeground(frame.getSecondeCouleur());
            carteCCVLabel.setBackground(frame.getMainCouleur());
            carteCCVLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            carte.add(carteCCVLabel);

            JTextField carteCCV = new JTextField("CCV");
            carteCCV.setBounds(630, 320, 105, 28);
            carteCCV.setForeground(frame.getSecondeCouleur());
            carteCCV.setBackground(frame.getMainCouleur());
            carteCCV.setFont(new Font("Arial", Font.BOLD, 20));
            carte.add(carteCCV);


            JTextField carteNom = new JTextField("Nom du Titulaire");
            carteNom.setBounds(110, 400, 340, 34);
            carteNom.setForeground(frame.getSecondeCouleur());
            carteNom.setFont(new Font("Arial", Font.BOLD, 28));
            carteNom.setBackground(frame.getMainCouleur());
            carte.add(carteNom);

            ImageIcon LogoCB = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/CB.png");
            LogoCB = ChangerCouleurImage.changer(frame, LogoCB);
            Image LogoCB2 = LogoCB.getImage().getScaledInstance(96, 74, Image.SCALE_SMOOTH);
            JLabel logoCB = new JLabel(new ImageIcon(LogoCB2));
            logoCB.setBounds(680, 20, 96, 74);
            carte.add(logoCB);

            ImageIcon LogoFleche = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Fleche.png");
            LogoFleche = ChangerCouleurImage.changer(frame, LogoFleche);
            Image LogoFleche2 = LogoFleche.getImage().getScaledInstance(21, 67, Image.SCALE_SMOOTH);
            JLabel logoFleche = new JLabel(new ImageIcon(LogoFleche2));
            logoFleche.setBounds(30, 320, 30, 67);
            carte.add(logoFleche);


            ImageIcon LogoCarteVisa = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Visa.png");
            LogoCarteVisa = ChangerCouleurImage.changer(frame, LogoCarteVisa);
            Image LogoCarteVisa2 = LogoCarteVisa.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteVisa = new JLabel(new ImageIcon(LogoCarteVisa2));
            logoCarteVisa.setBounds(550, 400, 62, 35);
            carte.add(logoCarteVisa);

            //Label / pour les cartes
            JLabel slash = new JLabel("/");
            slash.setBounds(630, 405, 10, 24);
            slash.setForeground(frame.getSecondeCouleur());
            slash.setFont(new Font("Arial", Font.BOLD, 32));
            carte.add(slash);

            ImageIcon LogoCarteM = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/Mastercard.png");
            Image LogoCarteM2 = LogoCarteM.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteM = new JLabel(new ImageIcon(LogoCarteM2));
            logoCarteM.setBounds(645, 400, 62, 35);
            carte.add(logoCarteM);

            //Label / pour les cartes
            JLabel slash2 = new JLabel("/");
            slash2.setBounds(715, 405, 10, 24);
            slash2.setForeground(frame.getSecondeCouleur());
            slash2.setFont(new Font("Arial", Font.BOLD, 32));
            carte.add(slash2);

            ImageIcon LogoCarteAmex = new ImageIcon("images/Images_Projet_V/Icon_Carte_Credit/American-Express.png");
            LogoCarteAmex = ChangerCouleurImage.changer(frame, LogoCarteAmex);
            Image LogoCarteAmex2 = LogoCarteAmex.getImage().getScaledInstance(62, 35, Image.SCALE_SMOOTH);
            JLabel logoCarteAmex = new JLabel(new ImageIcon(LogoCarteAmex2));
            logoCarteAmex.setBounds(730, 400, 62, 35);
            carte.add(logoCarteAmex);

        }

        //Check Box Recevoir e mail de confirmation et text field pour l'adresse mail
        JPanel panelMail = new JPanel();
        panelMail.setLayout(null);
        panelMail.setBackground(frame.getMainCouleur());
        panelMail.setBounds(2220, 140, 300, 200);

        JCheckBox recevoirMail = new JCheckBox("Recevoir mon billet par mail");
        recevoirMail.setBounds(10, 10, 200, 30);
        recevoirMail.setBackground(frame.getMainCouleur());
        recevoirMail.setForeground(frame.getSecondeCouleur());
        recevoirMail.setFont(new Font("Arial", Font.PLAIN, 20));
        panelMail.add(recevoirMail);
        


        



        //Ajouter les éléments au panel
        frame.getPanelBase().add(carte);
        frame.getPanelBase().add(TitrePaiement);
        frame.getPanelBase().add(panelSeparation);
        frame.getPanelBase().add(panelMail);

        //Refresh
        frame.RefreshPage();


    }


    
}
