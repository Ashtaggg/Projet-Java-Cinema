package V.EspaceUtilisateur;

import C.Listeners.PageCompte.ValidationListeners;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import M.JAVA_MODEL.ImagesModifs.ImageIconRounded;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import V.FrameBase;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PageModifCompte {
    public static void affichagePageModifCompte(FrameBase frame, JPanel compte){
        frame.PageActuelle = "compte";
        compte.removeAll();
        frame.RefreshPage();

        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);


        ImageIcon LogoRetour = new ImageIcon("images/Images_Projet_V/Icon_Compte/Retour.png");
        LogoRetour = ChangerCouleurImage.changer(frame, LogoRetour);
        JButton BoutonLogo_Retour = new JButton();
        BoutonLogo_Retour.setIcon(new ImageIcon(LogoRetour.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        BoutonLogo_Retour.setOpaque(true);
        BoutonLogo_Retour.setFocusable(false);
        BoutonLogo_Retour.setBorderPainted(false);
        BoutonLogo_Retour.setName("Retour");
        BoutonLogo_Retour.addActionListener(e -> {
            System.out.println("Retour...........");
            ChangementPageListeners.ChangementPage("compte", frame);
        });
        BoutonLogo_Retour.setBounds(20, 20, 30, 30);
        compte.add(BoutonLogo_Retour);


        String[] photo = {frame.userActuel.getPhotoProfil()};

        if(!frame.userActuel.getPhotoProfil().isEmpty()){
            BufferedImage image = ConvertirImageHexa.HexToImage(frame.userActuel.getPhotoProfil());
            Image image2 = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JButton BoutonChoixImage = new JButton();
            BoutonChoixImage.setIcon(new ImageIconRounded(image2));
            BoutonChoixImage.setOpaque(true);
            BoutonChoixImage.setBackground(new Color(0, 0, 0, 0));
            BoutonChoixImage.setRolloverEnabled(false);
            BoutonChoixImage.setFocusable(false);
            BoutonChoixImage.setBorderPainted(false);
            BoutonChoixImage.setName("ChoixImage");
            BoutonChoixImage.addActionListener(e -> {
                JFileChooser filechooser = new JFileChooser();
                filechooser.setCurrentDirectory(new File("images/"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp");
                filechooser.setFileFilter(filter);
                int reponse = filechooser.showSaveDialog(null);
                if(reponse == JFileChooser.APPROVE_OPTION){
                    String path = new String(filechooser.getSelectedFile().getAbsolutePath());
                    photo[0] = ConvertirImageHexa.ImageToHex(path);
                }
                frame.RefreshPage();
            });
            BoutonChoixImage.setBounds(275, 50, 200, 200);
            compte.add(BoutonChoixImage);
        }
        else{
            ImageIcon LogoPersonalisation = new ImageIcon("images/Images_Projet_V/Icon_Compte/Personalisation.png");
            LogoPersonalisation = ChangerCouleurImage.changer(frame, LogoPersonalisation);
            JButton BoutonChoixImage = new JButton();
            BoutonChoixImage.setIcon(new ImageIcon(LogoPersonalisation.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            BoutonChoixImage.setOpaque(true);
            BoutonChoixImage.setBackground(new Color(0, 0, 0, 0));
            BoutonChoixImage.setRolloverEnabled(false);
            BoutonChoixImage.setFocusable(false);
            BoutonChoixImage.setBorderPainted(false);
            BoutonChoixImage.setName("ChoixImage");
            BoutonChoixImage.addActionListener(e -> {
                JFileChooser filechooser = new JFileChooser();
                filechooser.setCurrentDirectory(new File("images/"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "bmp");
                filechooser.setFileFilter(filter);
                int reponse = filechooser.showSaveDialog(null);
                if(reponse == JFileChooser.APPROVE_OPTION){
                    String path = new String(filechooser.getSelectedFile().getAbsolutePath());
                    photo[0] = ConvertirImageHexa.ImageToHex(path);
                }
                frame.RefreshPage();
                
            });
            BoutonChoixImage.setBounds(350, 125, 50, 50);
            compte.add(BoutonChoixImage);
        }
        JPanel photoProfil = new JPanel();
        photoProfil.setLayout(null);
        photoProfil.setBackground(frame.getMainCouleur());
        photoProfil.setBounds(274, 49, 202, 202);
        photoProfil.setBorder(new RoundBorder(frame.getSecondeCouleur(), 200, 1));
        compte.add(photoProfil);





        JLabel prenomLabel = new JLabel("Prenom");
        prenomLabel.setBounds(75, 300, 185, 24);
        prenomLabel.setForeground(frame.getSecondeCouleur());
        prenomLabel.setFont(font3);
        compte.add(prenomLabel);

        JTextField prenom = new JTextField(20);
        prenom.setBounds(75, 325, 250, 40);
        prenom.setText(frame.userActuel.getPrenom());
        prenom.setOpaque(false);
        prenom.setForeground(frame.getSecondeCouleur());
        prenom.setFont(font2);
        compte.add(prenom);


        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setBounds(425, 300, 185, 24);
        nomLabel.setForeground(frame.getSecondeCouleur());
        nomLabel.setFont(font3);
        compte.add(nomLabel);

        JTextField nom = new JTextField(20);
        nom.setBounds(425, 325, 250, 40);
        nom.setText(frame.userActuel.getNom());
        nom.setOpaque(false);
        nom.setForeground(frame.getSecondeCouleur());
        nom.setFont(font2);
        compte.add(nom);


        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setBounds(75, 400, 185, 24);
        mailLabel.setForeground(frame.getSecondeCouleur());
        mailLabel.setFont(font3);
        compte.add(mailLabel);

        JTextField mail = new JTextField(20);
        mail.setBounds(75, 425, 250, 40);
        mail.setText(frame.userActuel.getMail());
        mail.setOpaque(false);
        mail.setForeground(frame.getSecondeCouleur());
        mail.setFont(font3);
        compte.add(mail);


        JLabel telLabel = new JLabel("Téléphone");
        telLabel.setBounds(425, 400, 185, 24);
        telLabel.setForeground(frame.getSecondeCouleur());
        telLabel.setFont(font3);
        compte.add(telLabel);

        JTextField tel = new JTextField(20);
        tel.setBounds(425, 425, 250, 40);
        tel.setText(frame.userActuel.getTelephone());
        tel.setOpaque(false);
        tel.setForeground(frame.getSecondeCouleur());
        tel.setFont(font2);
        compte.add(tel);


        JLabel dateLabel = new JLabel("Date de Naissance");
        dateLabel.setBounds(75, 500, 185, 24);
        dateLabel.setForeground(frame.getSecondeCouleur());
        dateLabel.setFont(font3);
        compte.add(dateLabel);

        JDateChooser date = new JDateChooser();
        date.setBounds(75, 525, 250, 40);
        date.setDateFormatString("yyyy-MM-dd");
        JTextField dateEditor = ((JTextField) date.getDateEditor());
        dateEditor.setForeground(frame.getSecondeCouleur());
        dateEditor.setBackground(frame.getMainCouleur());
        date.setDate(frame.userActuel.getDateNaissance());
        date.setFont(font2);
        compte.add(date);


        JLabel adresseLabel = new JLabel("Adresse");
        adresseLabel.setBounds(425, 500, 185, 24);
        adresseLabel.setForeground(frame.getSecondeCouleur());
        adresseLabel.setFont(font3);
        compte.add(adresseLabel);

        JTextField adresse = new JTextField(20);
        adresse.setBounds(425, 525, 250, 40);
        adresse.setText(frame.userActuel.getAdresse());
        adresse.setOpaque(false);
        adresse.setForeground(frame.getSecondeCouleur());
        adresse.setFont(font3);
        compte.add(adresse);

        
        JLabel mdpLabel = new JLabel("Nouveau Mot de Passe");
        mdpLabel.setBounds(425, 600, 185, 24);
        mdpLabel.setForeground(frame.getSecondeCouleur());
        mdpLabel.setFont(font3);
        compte.add(mdpLabel);

        JTextField mdp2 = new JTextField(20);
        mdp2.setBounds(425, 625, 250, 40);
        mdp2.setOpaque(false);
        mdp2.setForeground(frame.getSecondeCouleur());
        mdp2.setFont(font2);
        compte.add(mdp2);


        JLabel mdp2Label = new JLabel("Confirmation du Mot de Passe");
        mdp2Label.setBounds(425, 700, 300, 24);
        mdp2Label.setForeground(frame.getSecondeCouleur());
        mdp2Label.setFont(font3);
        compte.add(mdp2Label);

        JTextField mdp = new JTextField(20);
        mdp.setBounds(425, 725, 250, 40);
        mdp.setOpaque(false);
        mdp.setForeground(frame.getSecondeCouleur());
        mdp.setFont(font2);
        compte.add(mdp);



        JPanel carte = new JPanel();
        carte.setBounds(40, 600, 320, 200);
        carte.setBackground(frame.getMainCouleur());
        carte.setLayout(null);
        carte.setBorder(new RoundBorder(frame.getSecondeCouleur(), 40, 2));
        compte.add(carte);


        JLabel carteLabel = new JLabel("Carte de Crédit");
        carteLabel.setBounds(20, 18, 185, 24);
        carteLabel.setForeground(frame.getSecondeCouleur());
        carteLabel.setFont(font2);
        carte.add(carteLabel);

        JLabel logo1Label = new JLabel(")");
        logo1Label.setBounds(10, 70, 185, 30);
        logo1Label.setForeground(frame.getSecondeCouleur());
        logo1Label.setFont(new Font("Arial", Font.BOLD, 10));
        carte.add(logo1Label);

        JLabel logo2Label = new JLabel(")");
        logo2Label.setBounds(13, 70, 185, 30);
        logo2Label.setForeground(frame.getSecondeCouleur());
        logo2Label.setFont(new Font("Arial", Font.BOLD, 16));
        carte.add(logo2Label);

        JLabel logo3Label = new JLabel(")");
        logo3Label.setBounds(17, 70, 185, 30);
        logo3Label.setForeground(frame.getSecondeCouleur());
        logo3Label.setFont(new Font("Arial", Font.BOLD, 22));
        carte.add(logo3Label);

        JLabel logo4Label = new JLabel(")");
        logo4Label.setBounds(22, 69, 185, 30);
        logo4Label.setForeground(frame.getSecondeCouleur());
        logo4Label.setFont(new Font("Arial", Font.BOLD, 30));
        carte.add(logo4Label);


        String numeroCarte = frame.userActuel.getCarteNum();
        StringBuilder numeroCarte2 = new StringBuilder();

        for (int i = 0; i < numeroCarte.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                numeroCarte2.append(" ");
            }
            numeroCarte2.append(numeroCarte.charAt(i));
        }

        JTextField carteNum = new JTextField(20);
        carteNum.setBounds(35, 110, 200, 24);
        carteNum.setText(numeroCarte2.toString());
        carteNum.setOpaque(false);
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

        JTextField carteDate = new JTextField(20);
        carteDate.setBounds(135, 139, 55, 24);
        carteDate.setText(frame.userActuel.getCarteDate());
        carteDate.setOpaque(false);
        carteDate.setForeground(frame.getSecondeCouleur());
        carteDate.setFont(font2);
        carte.add(carteDate);


        JLabel carteCCVLabel = new JLabel("CCV");
        carteCCVLabel.setBounds(235, 139, 185, 24);
        carteCCVLabel.setForeground(frame.getSecondeCouleur());
        carteCCVLabel.setFont(new Font("Arial", Font.BOLD, 10));
        carte.add(carteCCVLabel);

        JTextField carteCCV = new JTextField(20);
        carteCCV.setBounds(270, 139, 40, 24);
        if(frame.userActuel.getCarteCCV() != -1){
            carteCCV.setText(Integer.toString(frame.userActuel.getCarteCCV()));
        }
        carteCCV.setOpaque(false);
        carteCCV.setForeground(frame.getSecondeCouleur());
        carteCCV.setFont(font2);
        carte.add(carteCCV);


        JTextField carteNom = new JTextField(20);
        carteNom.setBounds(35, 165, 200, 24);
        carteNom.setText(frame.userActuel.getCarteNom());
        carteNom.setOpaque(false);
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



        ImageIcon LogoValidation = new ImageIcon("images/Images_Projet_V/Icon_Compte/Validation.png");
        LogoValidation = ChangerCouleurImage.changer(frame, LogoValidation);
        JButton BoutonLogo_Validation = new JButton();
        BoutonLogo_Validation.setIcon(new ImageIcon(LogoValidation.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        BoutonLogo_Validation.setOpaque(true);
        BoutonLogo_Validation.setFocusable(false);
        BoutonLogo_Validation.setBorderPainted(false);
        BoutonLogo_Validation.setName("Validation");
        BoutonLogo_Validation.addActionListener(e -> {
            String Prenom = prenom.getText();
            String Nom = nom.getText();
            String Mail = mail.getText();
            String Tel = tel.getText();
            Date Date = date.getDate();
            String Adresse = adresse.getText();
            String Mdp = mdp.getText();
            String Mdp2 = mdp2.getText();
            String CarteNum = carteNum.getText();
            String CarteDate = carteDate.getText();
            String CarteCCV = carteCCV.getText();
            String CarteNom = carteNom.getText();
            System.out.println("Validation................");
            ValidationListeners.boutonValidation(frame, photo[0], Prenom, Nom, Mail, Tel, Date, Adresse, Mdp, Mdp2, CarteNum, CarteDate, CarteCCV, CarteNom);
        });
        BoutonLogo_Validation.setBounds(700, 20, 30, 30);
        compte.add(BoutonLogo_Validation);
    }
}
