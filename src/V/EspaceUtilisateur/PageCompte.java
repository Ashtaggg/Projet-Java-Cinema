package V.EspaceUtilisateur;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.image.BufferedImage;

import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.ConversionImageBDD.ChangerCouleurImage;
import M.JAVA_MODEL.ConversionImageBDD.ConvertirImageHexa;
import M.JAVA_MODEL.ConversionImageBDD.ImageIconRounded;
import V.FrameBase;

public class PageCompte {
    public static void affichagePageCompte(FrameBase frame){
        frame.PageActuelle = "compte";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);

        JPanel compte = new JPanel();
        compte.setBounds(50, 50, 750, 820);
        compte.setBackground(frame.getMainCouleur());
        compte.setLayout(null);
        compte.setBorder(bordure);
        

        if(!frame.userActuel.getPhotoProfil().isEmpty()){
            BufferedImage image = ConvertirImageHexa.HexToImage(frame.userActuel.getPhotoProfil());
            Image image2 = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIconRounded(image2));
            imageLabel.setBounds(275, 50, 200, 200);
            compte.add(imageLabel);
        }
        


        JLabel prenomLabel = new JLabel("Prenom");
        prenomLabel.setBounds(75, 300, 185, 24);
        prenomLabel.setForeground(frame.getSecondeCouleur());
        prenomLabel.setFont(font3);
        compte.add(prenomLabel);

        JLabel prenom = new JLabel(frame.userActuel.getPrenom());
        prenom.setBounds(75, 325, 250, 40);
        prenom.setForeground(frame.getSecondeCouleur());
        prenom.setFont(font2);
        prenom.setBorder(bordure);
        compte.add(prenom);

        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setBounds(425, 300, 185, 24);
        nomLabel.setForeground(frame.getSecondeCouleur());
        nomLabel.setFont(font3);
        compte.add(nomLabel);

        JLabel nom = new JLabel(frame.userActuel.getNom());
        nom.setBounds(425, 325, 250, 40);
        nom.setForeground(frame.getSecondeCouleur());
        nom.setFont(font2);
        nom.setBorder(bordure);
        compte.add(nom);


        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setBounds(75, 400, 185, 24);
        mailLabel.setForeground(frame.getSecondeCouleur());
        mailLabel.setFont(font3);
        compte.add(mailLabel);

        JLabel mail = new JLabel(frame.userActuel.getMail());
        mail.setBounds(75, 425, 250, 40);
        mail.setForeground(frame.getSecondeCouleur());
        mail.setFont(font3);
        mail.setBorder(bordure);
        compte.add(mail);

        JLabel telLabel = new JLabel("Téléphone");
        telLabel.setBounds(425, 400, 185, 24);
        telLabel.setForeground(frame.getSecondeCouleur());
        telLabel.setFont(font3);
        compte.add(telLabel);

        JLabel tel = new JLabel(frame.userActuel.getTelephone());
        tel.setBounds(425, 425, 250, 40);
        tel.setForeground(frame.getSecondeCouleur());
        tel.setFont(font2);
        tel.setBorder(bordure);
        compte.add(tel);


        JLabel dateLabel = new JLabel("Date de Naissance");
        dateLabel.setBounds(75, 500, 185, 24);
        dateLabel.setForeground(frame.getSecondeCouleur());
        dateLabel.setFont(font3);
        compte.add(dateLabel);

        JLabel date = new JLabel(frame.userActuel.getDateNaissance().toString());
        date.setBounds(75, 525, 250, 40);
        date.setForeground(frame.getSecondeCouleur());
        date.setFont(font2);
        date.setBorder(bordure);
        compte.add(date);

        JLabel adresseLabel = new JLabel("Adresse");
        adresseLabel.setBounds(425, 500, 185, 24);
        adresseLabel.setForeground(frame.getSecondeCouleur());
        adresseLabel.setFont(font3);
        compte.add(adresseLabel);

        JLabel adresse = new JLabel(frame.userActuel.getAdresse());
        adresse.setBounds(425, 525, 250, 40);
        adresse.setForeground(frame.getSecondeCouleur());
        adresse.setFont(font3);
        adresse.setBorder(bordure);
        compte.add(adresse);



        JPanel carte = new JPanel();
        carte.setBounds(215, 600, 320, 200);
        carte.setBackground(frame.getMainCouleur());
        carte.setLayout(null);
        carte.setBorder(bordure);
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










        JPanel billets = new JPanel();
        billets.setBounds(850, 50, 1000, 820);
        billets.setBackground(frame.getMainCouleur());
        billets.setLayout(null);
        billets.setBorder(bordure);


        JLabel billetsLabel = new JLabel("Séances Réservées");
        billetsLabel.setBounds(358, 50, 284, 30);
        billetsLabel.setForeground(frame.getSecondeCouleur());
        billetsLabel.setFont(font1);
        billets.add(billetsLabel);



        JPanel scrollBillets = new JPanel();
        scrollBillets.setBounds(50, 100, 900, 5000);
        scrollBillets.setBackground(frame.getMainCouleur());
        scrollBillets.setBorder(BorderFactory.createEmptyBorder());
        scrollBillets.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique
        gbc.insets = new Insets(10, 5, 10, 5); // Espacement entre les composants

        
        for (int i = 0; i < 5; i++) {
            JPanel panelBillets = new JPanel();
            panelBillets.setLayout(null);
            panelBillets.setBackground(frame.getMainCouleur());
            panelBillets.setSize(950, 200);
            panelBillets.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelBillets.setPreferredSize(new Dimension(950, 200));

            JLabel TitreFilm = new JLabel("Séance " + i);
            TitreFilm.setFont(font1);
            TitreFilm.setForeground(frame.getSecondeCouleur());
            TitreFilm.setBounds(422, 30, 131, 50);
            panelBillets.add(TitreFilm);


            //Ajout du panel de reservation au panel de scroll
            scrollBillets.add(panelBillets, gbc);

            gbc.gridy++;
        }
        

        // Créer un JScrollPane et y ajouter le contentPanel
        JScrollPane scrollPane = new JScrollPane(scrollBillets);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setBackground(frame.getMainCouleur());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(16);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        scrollPane.setBounds(20, 125, 975, 694); // Ajustez la taille selon vos besoins




        billets.add(scrollPane);
        frame.getPanelBase().setVisible(true);
        frame.getPanelBase().add(compte);
        frame.getPanelBase().add(billets);

        frame.RefreshPage();
    }
}
