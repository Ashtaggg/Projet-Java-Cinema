package V.Admin;

//Imports Fichiers
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import C.Listeners.PageAdmin.AjouterFilmListeners;
import V.FrameBase;

//Imports Java
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.Hashtable;




public class EspaceAdmin {
    public static void affichageEspaceAdmin(FrameBase frame){
        frame.PageActuelle = "admin";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();
        
        //Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        //Font font3 = new Font("Arial", Font.BOLD, 15);

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);


        JPanel admin = new JPanel();
        admin.setBounds(50, 100, 1800, 770);
        admin.setBackground(frame.getMainCouleur());
        admin.setLayout(null);
        admin.setBorder(bordure);


        JButton boutonAjouterFilm = new JButton("Ajouter un Film");
        JButton boutonSuppModifFilm = new JButton("Supprimer / Modifier un Film");
        JButton boutonAjouterSeance = new JButton("Ajouter une Seance");
        JButton boutonSuppModifSeance = new JButton("Supprimer / Modifier une Seance");



        boutonAjouterFilm.addActionListener(e -> {
            System.out.println("boutonAjouterFilm");
            affichageEspaceAdmin1(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonAjouterSeance, boutonSuppModifSeance);
        });
        boutonAjouterFilm.setBounds(140, 40, 177, 20);
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonAjouterFilm.setBackground(frame.getMainCouleur());
        boutonAjouterFilm.setBorder(null);
        boutonAjouterFilm.setFont(font2);
        frame.getPanelBase().add(boutonAjouterFilm);

        
        boutonSuppModifFilm.addActionListener(e -> {
            System.out.println("boutonSuppModifFilm");
            affichageEspaceAdmin2(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonAjouterSeance, boutonSuppModifSeance);
        });
        boutonSuppModifFilm.setBounds(524, 40, 302, 20);
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setBackground(frame.getMainCouleur());
        boutonSuppModifFilm.setBorder(null);
        boutonSuppModifFilm.setFont(font2);
        frame.getPanelBase().add(boutonSuppModifFilm);


        boutonAjouterSeance.addActionListener(e -> {
            System.out.println("boutonAjouterSeance");
            affichageEspaceAdmin3(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonAjouterSeance, boutonSuppModifSeance);
        });
        boutonAjouterSeance.setBounds(1016, 40, 218, 20);
        boutonAjouterSeance.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setBackground(frame.getMainCouleur());
        boutonAjouterSeance.setBorder(null);
        boutonAjouterSeance.setFont(font2);
        frame.getPanelBase().add(boutonAjouterSeance);


        boutonSuppModifSeance.addActionListener(e -> {
            System.out.println("boutonSuppModifSeance");
            affichageEspaceAdmin4(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonAjouterSeance, boutonSuppModifSeance);
        });
        boutonSuppModifSeance.setBounds(1403, 40, 343, 20);
        boutonSuppModifSeance.setForeground(frame.getTroisCouleur());
        boutonSuppModifSeance.setBackground(frame.getMainCouleur());
        boutonSuppModifSeance.setBorder(null);
        boutonSuppModifSeance.setFont(font2);
        frame.getPanelBase().add(boutonSuppModifSeance);


        frame.getPanelBase().add(admin);
        frame.RefreshPage();
    }

    
    public static void affichageEspaceAdmin1(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonAjouterSeance, JButton boutonSuppModifSeance){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getSecondeCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setForeground(frame.getTroisCouleur());
        boutonSuppModifSeance.setForeground(frame.getTroisCouleur());


        String[] photo = {ConvertirImageHexa.ImageToHex("images/Images_Projet_V/Icon_Compte/Personalisation_2.png")};

        BufferedImage image = ConvertirImageHexa.HexToImage(photo[0]);
        Image image2 = image.getScaledInstance(310, 420, Image.SCALE_SMOOTH);
        ImageIcon image3 = ChangerCouleurImage.changer(frame, new ImageIcon(image2));
        JButton BoutonChoixImage = new JButton();
        BoutonChoixImage.setIcon(image3);
        BoutonChoixImage.setOpaque(true);
        BoutonChoixImage.setBackground(new Color(0, 0, 0, 0));
        BoutonChoixImage.setRolloverEnabled(false);
        BoutonChoixImage.setFocusable(false);
        BoutonChoixImage.setBorderPainted(true);
        BoutonChoixImage.setForeground(frame.getSecondeCouleur());
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
                BufferedImage newImage = ConvertirImageHexa.HexToImage(photo[0]);
                Image newImageScaled = newImage.getScaledInstance(310, 420, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImageScaled);
                BoutonChoixImage.setIcon(newIcon);
                BoutonChoixImage.repaint();
            }
        });
        BoutonChoixImage.setBounds(75, 50, 310, 420);
        admin.add(BoutonChoixImage);



        JLabel titreLabel = new JLabel("Titre du Film");
        titreLabel.setBounds(460, 50, 185, 24);
        titreLabel.setForeground(frame.getSecondeCouleur());
        titreLabel.setFont(font3);
        admin.add(titreLabel);

        JTextField titre = new JTextField(20);
        titre.setBounds(460, 75, 500, 40);
        titre.setOpaque(false);
        titre.setForeground(frame.getSecondeCouleur());
        titre.setFont(font2);
        admin.add(titre);

        JLabel realisateurLabel = new JLabel("Réalisateur");
        realisateurLabel.setBounds(1035, 50, 185, 24);
        realisateurLabel.setForeground(frame.getSecondeCouleur());
        realisateurLabel.setFont(font3);
        admin.add(realisateurLabel);

        JTextField realisateur = new JTextField(20);
        realisateur.setBounds(1035, 75, 307, 40);
        realisateur.setOpaque(false);
        realisateur.setForeground(frame.getSecondeCouleur());
        realisateur.setFont(font2);
        admin.add(realisateur);

        JLabel dateLabel = new JLabel("Date de Sortie");
        dateLabel.setBounds(1417, 50, 185, 24);
        dateLabel.setForeground(frame.getSecondeCouleur());
        dateLabel.setFont(font3);
        admin.add(dateLabel);

        JDateChooser date = new JDateChooser();
        date.setBounds(1417, 75, 307, 40);
        date.setDateFormatString("yyyy-MM-dd");
        JTextField dateEditor = ((JTextField) date.getDateEditor());
        dateEditor.setForeground(frame.getSecondeCouleur());
        dateEditor.setBackground(frame.getMainCouleur());
        date.setFont(font2);
        admin.add(date);


        JLabel descriptionLabel = new JLabel("Description du Film");
        descriptionLabel.setBounds(460, 200, 185, 24);
        descriptionLabel.setForeground(frame.getSecondeCouleur());
        descriptionLabel.setFont(font3);
        admin.add(descriptionLabel);

        JTextField description = new JTextField(20);
        description.setBounds(460, 225, 500, 40);
        description.setOpaque(false);
        description.setForeground(frame.getSecondeCouleur());
        description.setFont(font2);
        admin.add(description);

        JLabel dureeLabel = new JLabel("Durée du Film");
        dureeLabel.setBounds(1035, 200, 185, 24);
        dureeLabel.setForeground(frame.getSecondeCouleur());
        dureeLabel.setFont(font3);
        admin.add(dureeLabel);

        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.MINUTE);
        model.setValue(new Date(0));
        JSpinner duree = new JSpinner(model);
        SimpleDateFormat format = new SimpleDateFormat("HH 'h' mm");
        JSpinner.DateEditor editor = new JSpinner.DateEditor(duree, format.toPattern());
        duree.setEditor(editor);
        JFormattedTextField textField = editor.getTextField();
        textField.setBackground(frame.getMainCouleur());
        textField.setFont(font2);
        textField.setForeground(frame.getSecondeCouleur());
        duree.setBounds(1035, 225, 185, 40);
        admin.add(duree);

        JLabel noteLabel = new JLabel("Note");
        noteLabel.setBounds(1295, 200, 185, 24);
        noteLabel.setForeground(frame.getSecondeCouleur());
        noteLabel.setFont(font3);
        admin.add(noteLabel);

        JSlider note = new JSlider(0, 50, 0);
        note.setPaintTicks(true);
        note.setPaintLabels(true);
        note.setMajorTickSpacing(10);
        note.setMinorTickSpacing(1);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("0"));
        labelTable.put(10, new JLabel("1"));
        labelTable.put(20, new JLabel("2"));
        labelTable.put(30, new JLabel("3"));
        labelTable.put(40, new JLabel("4"));
        labelTable.put(50, new JLabel("5"));
        note.setLabelTable(labelTable);
        note.setBackground(frame.getMainCouleur());
        note.setForeground(frame.getSecondeCouleur());
        note.setBounds(1295, 225, 430, 50);
        admin.add(note);


        JLabel acteursLabel = new JLabel("Acteurs");
        acteursLabel.setBounds(460, 350, 185, 24);
        acteursLabel.setForeground(frame.getSecondeCouleur());
        acteursLabel.setFont(font3);
        admin.add(acteursLabel);

        JTextArea acteurs = new JTextArea();
        acteurs.setLineWrap(true);
        acteurs.setWrapStyleWord(true);
        acteurs.setPreferredSize(new Dimension(500, 95));
        acteurs.setBackground(frame.getMainCouleur());
        acteurs.setForeground(frame.getSecondeCouleur());
        acteurs.setFont(font2);
        JScrollPane scrollPane = new JScrollPane(acteurs);
        scrollPane.setBounds(460, 375, 500, 95);
        scrollPane.setBackground(frame.getMainCouleur());
        admin.add(scrollPane);

        JLabel synopsisLabel = new JLabel("Synopsis");
        synopsisLabel.setBounds(1035, 350, 185, 24);
        synopsisLabel.setForeground(frame.getSecondeCouleur());
        synopsisLabel.setFont(font3);
        admin.add(synopsisLabel);

        JTextArea synopsis = new JTextArea();
        synopsis.setLineWrap(true);
        synopsis.setWrapStyleWord(true);
        synopsis.setPreferredSize(new Dimension(690, 95));
        synopsis.setBackground(frame.getMainCouleur());
        synopsis.setForeground(frame.getSecondeCouleur());
        synopsis.setFont(font2);
        JScrollPane scrollPane2 = new JScrollPane(synopsis);
        scrollPane2.setBounds(1035, 375, 690, 95);
        scrollPane2.setBackground(frame.getMainCouleur());
        admin.add(scrollPane2);


        JLabel quatreDXLabel = new JLabel("Film avec 4DX");
        quatreDXLabel.setBounds(135, 520, 185, 24);
        quatreDXLabel.setForeground(frame.getSecondeCouleur());
        quatreDXLabel.setFont(font3);
        admin.add(quatreDXLabel);

        JCheckBox quatreDX = new JCheckBox("1");
        quatreDX.setBackground(frame.getMainCouleur());
        quatreDX.setForeground(frame.getSecondeCouleur());
        quatreDX.setBounds(255, 520, 20, 20);
        admin.add(quatreDX);

        JLabel prixAdulteLabel = new JLabel("Prix place Adulte");
        prixAdulteLabel.setBounds(135, 570, 200, 24);
        prixAdulteLabel.setForeground(frame.getSecondeCouleur());
        prixAdulteLabel.setFont(font3);
        admin.add(prixAdulteLabel);

        JLabel prixEtudiantLabel = new JLabel("Prix place Etudiant");
        prixEtudiantLabel.setBounds(135, 600, 200, 24);
        prixEtudiantLabel.setForeground(frame.getSecondeCouleur());
        prixEtudiantLabel.setFont(font3);
        admin.add(prixEtudiantLabel);

        JLabel prixEnfantLabel = new JLabel("Prix place Enfant");
        prixEnfantLabel.setBounds(135, 630, 200, 24);
        prixEnfantLabel.setForeground(frame.getSecondeCouleur());
        prixEnfantLabel.setFont(font3);
        admin.add(prixEnfantLabel);

        JLabel prixAdulte2Label = new JLabel("10.99 €");
        prixAdulte2Label.setBounds(290, 570, 200, 24);
        prixAdulte2Label.setForeground(frame.getSecondeCouleur());
        prixAdulte2Label.setFont(font3);
        admin.add(prixAdulte2Label);

        JLabel prixEtudiant2Label = new JLabel("8.79 €");
        prixEtudiant2Label.setBounds(298, 600, 200, 24);
        prixEtudiant2Label.setForeground(frame.getSecondeCouleur());
        prixEtudiant2Label.setFont(font3);
        admin.add(prixEtudiant2Label);

        JLabel prixEnfant2Label = new JLabel("6.59 €");
        prixEnfant2Label.setBounds(298, 630, 200, 24);
        prixEnfant2Label.setForeground(frame.getSecondeCouleur());
        prixEnfant2Label.setFont(font3);
        admin.add(prixEnfant2Label);

        quatreDX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (quatreDX.isSelected()) {
                    prixAdulte2Label.setText("24.99 €");
                    prixEtudiant2Label.setText("19.99 €");
                    prixEtudiant2Label.setBounds(290, 600, 200, 24);
                    prixEnfant2Label.setText("14.99 €");
                    prixEnfant2Label.setBounds(290, 630, 200, 24);
                } else {
                    prixAdulte2Label.setText("10.99 €");
                    prixEtudiant2Label.setText("8.79 €");
                    prixEtudiant2Label.setBounds(298, 600, 200, 24);
                    prixEnfant2Label.setText("6.59 €");
                    prixEnfant2Label.setBounds(298, 630, 200, 24);
                }
            }
        });

        JLabel problemValiderFilmLabel = new JLabel("");
        problemValiderFilmLabel.setBounds(1010, 663, 327, 24);
        problemValiderFilmLabel.setForeground(frame.getSecondeCouleur());
        problemValiderFilmLabel.setFont(font3);
        problemValiderFilmLabel.setVisible(false);
        admin.add(problemValiderFilmLabel);


        JButton boutonValiderFilm = new JButton("Ajouter Film");
        boutonValiderFilm.addActionListener(e -> {
            String Photo = photo[0];
            String Titre = titre.getText();
            String Realisateur = realisateur.getText();
            Date Date = date.getDate();
            String Description = description.getText();
            SpinnerDateModel Model = (SpinnerDateModel) duree.getModel();
            Date DureeTemp = (Date) Model.getValue();
            SimpleDateFormat DureeFormat = new SimpleDateFormat("HH:mm:ss");
            String Duree = DureeFormat.format(DureeTemp);
            int NoteTemp = note.getValue();
            double Note = (double) NoteTemp / 10; 
            String Acteurs = acteurs.getText();
            String Synopsis = synopsis.getText();
            int QuatreDX = 0;
            if(quatreDX.isSelected()){
                QuatreDX = 1;
            }          
            AjouterFilmListeners.boutonValiderFilm(frame, problemValiderFilmLabel, Photo, Titre, Realisateur, Date, Description, Duree, Note, Acteurs, Synopsis, QuatreDX);
        });
        boutonValiderFilm.setBounds(815, 650, 170, 50);
        boutonValiderFilm.setForeground(frame.getSecondeCouleur());
        boutonValiderFilm.setBackground(frame.getMainCouleur());
        boutonValiderFilm.setFont(font2);
        admin.add(boutonValiderFilm);
        


        frame.RefreshPage();
    }

    public static void affichageEspaceAdmin2(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonAjouterSeance, JButton boutonSuppModifSeance){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getSecondeCouleur());
        boutonAjouterSeance.setForeground(frame.getTroisCouleur());
        boutonSuppModifSeance.setForeground(frame.getTroisCouleur());

    }

    public static void affichageEspaceAdmin3(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonAjouterSeance, JButton boutonSuppModifSeance){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setForeground(frame.getSecondeCouleur());
        boutonSuppModifSeance.setForeground(frame.getTroisCouleur());

    }

    public static void affichageEspaceAdmin4(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonAjouterSeance, JButton boutonSuppModifSeance){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setForeground(frame.getTroisCouleur());
        boutonSuppModifSeance.setForeground(frame.getSecondeCouleur());

    }
    
}
