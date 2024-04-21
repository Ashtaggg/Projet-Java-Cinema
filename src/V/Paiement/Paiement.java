package V.Paiement;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import C.Listeners.Paiement.PayerListener;

//Imports Librairies
// Importation des librairies
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.sql.Date;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Paiement {

    public static void afficherPaiement(FrameBase frame) {

        frame.PageActuelle = "payer";
        frame.getPanelBase().removeAll();

        if(frame.userActuel!=null){
            for(int i = 0; i < frame.reservationActuelle.size(); i++){
                frame.reservationActuelle.get(i).setIdCompte(frame.userActuel.getIdCompte());
            }
        }

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

        

        if(frame.userActuel!=null){
            String numeroCarteStr = frame.userActuel.getCarteNum();
            StringBuilder numeroCarte2 = new StringBuilder();

            for (int i = 0; i < numeroCarteStr.length(); i++) {
                if (i > 0 && i % 4 == 0) {
                    numeroCarte2.append(" ");
                }
                numeroCarte2.append(numeroCarteStr.charAt(i));
            }
            carteNum.setText(numeroCarte2.toString());
            try {
                // Ajouter un jour arbitraire (01) à la date pour former "01/MM/yy"
                String dateStr = "01/" + frame.userActuel.getCarteDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                java.util.Date parsedUtilDate = sdf.parse(dateStr);
                
                // Convertir java.util.Date en java.sql.Date
                java.sql.Date parsedSqlDate = new java.sql.Date(parsedUtilDate.getTime());
                date.setDate(parsedSqlDate);
                
                // Utilisez parsedSqlDate
            } catch (ParseException e) {
                e.printStackTrace();
            }
            carteCCV.setText(Integer.toString(frame.userActuel.getCarteCCV()));
            carteNom.setText(frame.userActuel.getNom());

            System.out.println("Utilisateur connecté : " + frame.userActuel.getNom());
        }
        else{
            System.out.println("Utilisateur non connecté");
        }

        //Check Box Recevoir e mail de confirmation et text field pour l'adresse mail
        JPanel panelMail = new JPanel();
        panelMail.setLayout(null);
        panelMail.setBackground(frame.getMainCouleur());
        panelMail.setBounds(1220, 140, 500, 150);

        JCheckBox recevoirMail = new JCheckBox("Recevoir mon billet par mail");
        recevoirMail.setBounds(10, 10, 400, 30);
        recevoirMail.setBackground(frame.getMainCouleur());
        recevoirMail.setForeground(frame.getSecondeCouleur());
        recevoirMail.setBorder(null);
        recevoirMail.setIconTextGap(23);
        recevoirMail.setFont(new Font("Arial", Font.PLAIN, 24));
        panelMail.add(recevoirMail);

        JLabel Email = new JLabel("Votre Email :");
        Email.setBounds(10, 60, 300, 30);
        Email.setForeground(frame.getSecondeCouleur());
        Email.setFont(new Font("Arial", Font.PLAIN, 24));
        panelMail.add(Email);

        JTextField email = new JTextField("e-mail");
        if(frame.userActuel!=null){email.setText(frame.userActuel.getMail());}
        email.setBounds(10, 100, 300, 30);
        email.setBackground(frame.getMainCouleur());
        email.setForeground(frame.getSecondeCouleur());
        email.setFont(new Font("Arial", Font.PLAIN, 24));
        panelMail.add(email);
        
        JPanel Conditions = new JPanel();
        Conditions.setLayout(null);
        Conditions.setBackground(frame.getMainCouleur());
        Conditions.setBounds(1220, 290, 550, 50);

        JCheckBox accepterConditions = new JCheckBox("J'accepte les conditions générales *");
        accepterConditions.setBounds(10, 5, 500, 30);
        accepterConditions.setBackground(frame.getMainCouleur());
        accepterConditions.setForeground(frame.getSecondeCouleur());
        accepterConditions.setBorder(null);
        accepterConditions.setIconTextGap(23);
        accepterConditions.setFont(new Font("Arial", Font.PLAIN, 24));
        Conditions.add(accepterConditions);

        //Total à payer
        JLabel total = new JLabel();
        total.setBounds(1220, 450, 500, 40);
        total.setForeground(frame.getSecondeCouleur());
        total.setFont(new Font("Arial", Font.BOLD, 30));

        double prixTotal = 0;
        for (int i = 0; i < frame.reservationActuelle.size(); i++) {
            prixTotal += frame.reservationActuelle.get(i).getPrixTotal();
        }
        total.setText("Total à payer : " + prixTotal + " €");


        JButton Payer = new JButton("Payer");
         Payer.setBorder(BorderFactory.createLineBorder(frame.getSecondeCouleur(), 2));
        Payer.setBounds(1220, 590, 350, 50);
        Payer.setBackground(frame.getSecondeCouleur());
        Payer.setForeground(frame.getMainCouleur());
        Payer.setFont(new Font("Arial", Font.BOLD, 24));
        Payer.addActionListener(e ->{
            int ValidPayer = 0;
            if(accepterConditions.isSelected()){
                //Vérifier que les éléments de la CB sont valides
                if(carteNum.getText().length() == 19 && date.getDate() != null && carteCCV.getText().length() == 3 && carteNom.getText().length() > 0){
                    //Vérifier que la date n'est pas dépassée
                    Date dateActuelle = new Date(System.currentTimeMillis());
                    if(date.getDate().after(dateActuelle)){
                        //Vérifier que l'email est valide
                        if(recevoirMail.isSelected()){
                            if(email.getText().contains("@") && email.getText().contains(".")){
                                ValidPayer = PayerListener.Payer(frame);
                                if (ValidPayer == 1){
                                    //JOptionPane.showMessageDialog(null, "Votre billet a été envoyé à l'adresse mail : " + email.getText());
                                    //ChangementPageListeners.ChangementPage("accueil", frame);
                                    frame.RefreshPanier();
                                    ChangementPageListeners.ChangementPage("Merci", frame);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Erreur lors du paiement\nVeuillez réessayer plus tard");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Veuillez entrer une adresse mail valide");
                            }
                        }
                        else{
                            ValidPayer = PayerListener.Payer(frame);
                                if (ValidPayer == 1){
                                    //JOptionPane.showMessageDialog(null, "Paiement effectué et billet disponible dans votre compte");
                                    //ChangementPageListeners.ChangementPage("accueil", frame);
                                    frame.RefreshPanier();
                                    ChangementPageListeners.ChangementPage("Merci", frame);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Erreur lors du paiement\nVeuillez réessayer plus tard");
                                }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Votre carte est expirée");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Veuillez entrer des informations valides");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Veuillez accepter les conditions générales");
            }
        });

        // * détails de toutes conditions générales écrit en petit en bas à gauche avec du html
        JLabel conditions = new JLabel("<html><p style='font-size: 12px;'>* En cliquant sur \"Payer\", vous acceptez les conditions générales de vente et d'utilisation de notre site. <br> Vous acceptez également de recevoir des e-mails de confirmation de votre réservation et de nos offres promotionnelles.</p></html>");
        conditions.setBounds(10, 850, 1000, 100);
        conditions.setForeground(frame.getSecondeCouleur());
        conditions.setFont(new Font("Arial", Font.PLAIN, 12));
        



        //Ajouter les éléments au panel
        frame.getPanelBase().add(carte);
        frame.getPanelBase().add(TitrePaiement);
        frame.getPanelBase().add(panelSeparation);
        frame.getPanelBase().add(panelMail);
        frame.getPanelBase().add(Conditions);
        frame.getPanelBase().add(total);
        frame.getPanelBase().add(Payer);
        frame.getPanelBase().add(conditions);

        //Refresh
        frame.RefreshPage();


    }


    
}
