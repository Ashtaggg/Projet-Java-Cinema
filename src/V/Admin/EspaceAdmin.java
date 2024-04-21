package V.Admin;

//Imports Fichiers
import C.Listeners.PageAdmin.AjouterFilmListeners;
import C.Listeners.PageAdmin.SupprimerFilmListeners;
import C.Listeners.PageAdmin.ModifierFilmListeners;
import C.Listeners.PageCompte.RecuperationFilmListeners;
import C.Listeners.PageAdmin.RecuperationFilmsListeners;
import C.Listeners.PageAdmin.SupprimerUtilisateurListeners;
import C.Listeners.PageAdmin.ModifierUtilisateurListeners;
import C.Listeners.PageAdmin.RecuperationUtilisateurListeners;
import C.Listeners.PageAdmin.RecuperationUtilisateursListeners;
import C.Listeners.PageAdmin.RecuperationSeancesByIDFilmListeners;
import C.Listeners.PageAdmin.RecuperationSeancesByIDSalleAndDateListeners;
import C.Listeners.PageAdmin.RecuperationReservationsByIDSeance;
import C.Listeners.PageAdmin.CompterBilletsByIDReservation;
import C.Listeners.ChangementPageListeners;
import M.JAVA_MODEL.Global_CLASS.Film;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import M.JAVA_MODEL.Global_CLASS.Reservation;
import M.JAVA_MODEL.Global_CLASS.Seance;
import M.JAVA_MODEL.ImagesModifs.ChangerCouleurImage;
import M.JAVA_MODEL.ImagesModifs.ConvertirImageHexa;
import M.JAVA_MODEL.RoundBorder.RoundBorder;
import M.JAVA_MODEL.ImagesModifs.ImageIconRounded;
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
import java.util.List;
import java.text.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;





public class EspaceAdmin {
    public static void affichageEspaceAdmin(FrameBase frame){
        frame.PageActuelle = "admin";
        frame.getPanelBase().removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 60);
        Font font2 = new Font("Arial", Font.BOLD, 20);

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);


        JPanel admin = new JPanel();
        admin.setBounds(50, 100, 1800, 770);
        admin.setBackground(frame.getMainCouleur());
        admin.setLayout(null);
        admin.setBorder(bordure);


        JLabel Label = new JLabel("Espace Administrateur");
        Label.setBounds(575, 355, 650, 60);
        Label.setForeground(frame.getSecondeCouleur());
        Label.setFont(font1);
        admin.add(Label);


        JButton boutonAjouterFilm = new JButton("Ajouter un Film");
        JButton boutonSuppModifFilm = new JButton("Supprimer / Modifier un Film");
        JButton boutonAjouterSeance = new JButton("Ajouter une Seance");
        JButton boutonSuppModifCompte = new JButton("Supprimer / Modifier un Compte");
        JButton boutonAfficherStat = new JButton("Afficher Statistiques");



        boutonAjouterFilm.addActionListener(e -> {
            affichageEspaceAdmin1(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonSuppModifCompte, boutonAfficherStat);
        });
        //boutonAjouterFilm.setBounds(140, 40, 177, 20);
        boutonAjouterFilm.setBounds(92, 40, 177, 20);
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonAjouterFilm.setBackground(frame.getMainCouleur());
        boutonAjouterFilm.setBorder(null);
        boutonAjouterFilm.setFont(font2);
        frame.getPanelBase().add(boutonAjouterFilm);

        
        boutonSuppModifFilm.addActionListener(e -> {
            affichageEspaceAdmin2(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonSuppModifCompte, boutonAfficherStat);
        });
        //boutonSuppModifFilm.setBounds(524, 40, 302, 20);
        boutonSuppModifFilm.setBounds(389, 40, 302, 20);
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setBackground(frame.getMainCouleur());
        boutonSuppModifFilm.setBorder(null);
        boutonSuppModifFilm.setFont(font2);
        frame.getPanelBase().add(boutonSuppModifFilm);

        boutonAjouterSeance.addActionListener(e -> {
            affichageEspaceAdmin5(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonSuppModifCompte, boutonAfficherStat, boutonAjouterSeance);
        });
        boutonAjouterSeance.setBounds(808, 40, 184, 20);
        boutonAjouterSeance.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setBackground(frame.getMainCouleur());
        boutonAjouterSeance.setBorder(null);
        boutonAjouterSeance.setFont(font2);
        frame.getPanelBase().add(boutonAjouterSeance);


        boutonSuppModifCompte.addActionListener(e -> {
            affichageEspaceAdmin3(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonSuppModifCompte, boutonAfficherStat);
        });
        //boutonSuppModifCompte.setBounds(974, 40, 302, 20);
        boutonSuppModifCompte.setBounds(1109, 40, 302, 20);
        boutonSuppModifCompte.setForeground(frame.getTroisCouleur());
        boutonSuppModifCompte.setBackground(frame.getMainCouleur());
        boutonSuppModifCompte.setBorder(null);
        boutonSuppModifCompte.setFont(font2);
        frame.getPanelBase().add(boutonSuppModifCompte);


        boutonAfficherStat.addActionListener(e -> {
            affichageEspaceAdmin4(frame, admin, boutonAjouterFilm, boutonSuppModifFilm, boutonSuppModifCompte, boutonAfficherStat);
        });
        //boutonAfficherStat.setBounds(1479, 40, 192, 20);
        boutonAfficherStat.setBounds(1524, 40, 192, 20);
        boutonAfficherStat.setForeground(frame.getTroisCouleur());
        boutonAfficherStat.setBackground(frame.getMainCouleur());
        boutonAfficherStat.setBorder(null);
        boutonAfficherStat.setFont(font2);
        frame.getPanelBase().add(boutonAfficherStat);


        frame.getPanelBase().add(admin);
        frame.RefreshPage();
    }

    
    public static void affichageEspaceAdmin1(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonSuppModifCompte, JButton boutonAfficherStat){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getSecondeCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifCompte.setForeground(frame.getTroisCouleur());
        boutonAfficherStat.setForeground(frame.getTroisCouleur());


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

    public static void affichageEspaceAdmin2(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonSuppModifCompte, JButton boutonAfficherStat){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getSecondeCouleur());
        boutonSuppModifCompte.setForeground(frame.getTroisCouleur());
        boutonAfficherStat.setForeground(frame.getTroisCouleur());


        JPanel scrollBillets = new JPanel();
        scrollBillets.setBounds(150, 150, 1500, 5000);
        scrollBillets.setBackground(frame.getMainCouleur());
        scrollBillets.setBorder(BorderFactory.createEmptyBorder());
        scrollBillets.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique
        gbc.insets = new Insets(10, 5, 10, 5); // Espacement entre les composants

        List<Film> films = RecuperationFilmsListeners.recupFilms(frame);

        for (Film film : films) {

            JPanel panelFilms = new JPanel();
            panelFilms.setLayout(null);
            panelFilms.setBackground(frame.getMainCouleur());
            panelFilms.setSize(1700, 125);
            panelFilms.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelFilms.setPreferredSize(new Dimension(1700, 125));


            BufferedImage image = ConvertirImageHexa.HexToImage(film.getPhoto());
            Image image2 = image.getScaledInstance(88, 120, Image.SCALE_SMOOTH);
            JLabel afficherLabel = new JLabel(new ImageIcon(image2));
            afficherLabel.setBounds(50, 3, 88, 120);
            panelFilms.add(afficherLabel);


            JLabel TitreFilm = new JLabel(film.getNom());
            TitreFilm.setFont(font1);
            TitreFilm.setForeground(frame.getSecondeCouleur());
            TitreFilm.setBounds(180, 10, 800, 30);
            panelFilms.add(TitreFilm);

            JLabel RealisateurFilm = new JLabel("de " + film.getRealisateur());
            RealisateurFilm.setFont(font3);
            RealisateurFilm.setForeground(frame.getSecondeCouleur());
            RealisateurFilm.setBounds(180, 45, 800, 15);
            panelFilms.add(RealisateurFilm);

            

            if(film.getQuatreDX() == true){
                ImageIcon Logo4DX = new ImageIcon("images/Images_Projet_V/Icon_ReservationSeance/4DX_2.png");
                Logo4DX = ChangerCouleurImage.changer(frame, Logo4DX);
                Image Logo4DX2 = Logo4DX.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                JLabel logo4DX = new JLabel(new ImageIcon(Logo4DX2));
                logo4DX.setBounds(180, 90, 30, 30);
                panelFilms.add(logo4DX);

                JLabel DescriptionFilm = new JLabel(film.getDescription());
                DescriptionFilm.setFont(font2);
                DescriptionFilm.setForeground(frame.getSecondeCouleur());
                DescriptionFilm.setBounds(215, 95, 800, 20);
                panelFilms.add(DescriptionFilm);
            }
            else if(film.getQuatreDX() == false){
                JLabel DescriptionFilm = new JLabel(film.getDescription());
                DescriptionFilm.setFont(font2);
                DescriptionFilm.setForeground(frame.getSecondeCouleur());
                DescriptionFilm.setBounds(180, 95, 800, 20);
                panelFilms.add(DescriptionFilm);
            }



            JButton boutonModifier = new JButton("Modifier");
            boutonModifier.addActionListener(e -> {
                int index = film.getIdFilm();
                Film filmSelec = RecuperationFilmListeners.recupFilm(frame, index);
                affichageEspaceAdmin2_bis(frame, admin, filmSelec);
            });
            boutonModifier.setBounds(1100, 40, 170, 40);
            boutonModifier.setForeground(frame.getSecondeCouleur());
            boutonModifier.setBackground(frame.getMainCouleur());
            boutonModifier.setFont(font2);
            panelFilms.add(boutonModifier);


            JButton boutonSupprimer = new JButton("Supprimer");
            boutonSupprimer.addActionListener(e -> {
                int index = film.getIdFilm();
                Film filmSelec = RecuperationFilmListeners.recupFilm(frame, index);
                SupprimerFilmListeners.supprFilms(frame, filmSelec);
                ChangementPageListeners.ChangementPage("admin", frame);
            });
            LineBorder bordureNormale = new LineBorder(frame.getSecondeCouleur(), 1);
            LineBorder bordureSurvol = new LineBorder(Color.RED, 1);
            boutonSupprimer.setBorder(bordureNormale);
            boutonSupprimer.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boutonSupprimer.setBorder(bordureSurvol);
                }

                public void mouseExited(MouseEvent e) {
                    boutonSupprimer.setBorder(bordureNormale);
                }
            });
            boutonSupprimer.setBounds(1400, 40, 170, 40);
            boutonSupprimer.setForeground(Color.RED);
            boutonSupprimer.setBackground(frame.getMainCouleur());
            boutonSupprimer.setFont(font2);
            panelFilms.add(boutonSupprimer);



            scrollBillets.add(panelFilms, gbc);
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

        scrollPane.setBounds(50, 1, 1720, 768); // Ajustez la taille selon vos besoins

        admin.add(scrollPane);

        frame.RefreshPage();
    }

    public static void affichageEspaceAdmin2_bis(FrameBase frame, JPanel admin, Film film){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);



        String[] photo = {film.getPhoto()};

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
        titre.setText(film.getNom());
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
        realisateur.setText(film.getRealisateur());
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
        date.setDate(film.getDateSortie());
        date.setFont(font2);
        admin.add(date);

        JLabel descriptionLabel = new JLabel("Description du Film");
        descriptionLabel.setBounds(460, 200, 185, 24);
        descriptionLabel.setForeground(frame.getSecondeCouleur());
        descriptionLabel.setFont(font3);
        admin.add(descriptionLabel);

        JTextField description = new JTextField(20);
        description.setBounds(460, 225, 500, 40);
        description.setText(film.getDescription());
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
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            model.setValue(sdf.parse(film.getDuree()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        double noteTemp = film.getNote()*10;
        note.setValue((int) noteTemp);
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
        acteurs.setText(film.getActeur());
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
        synopsis.setText(film.getSynopsis());
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

        if(film.getQuatreDX() == true){
            quatreDX.setSelected(true);
            prixAdulte2Label.setText("24.99 €");
            prixEtudiant2Label.setText("19.99 €");
            prixEtudiant2Label.setBounds(290, 600, 200, 24);
            prixEnfant2Label.setText("14.99 €");
            prixEnfant2Label.setBounds(290, 630, 200, 24);
        }
        admin.add(quatreDX);

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


        JButton boutonModifierFilm = new JButton("Modifier Film");
        boutonModifierFilm.addActionListener(e -> {
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
            ModifierFilmListeners.modifFilms(frame, problemValiderFilmLabel, film.getIdFilm(), Photo, Titre, Realisateur, Date, Description, Duree, Note, Acteurs, Synopsis, QuatreDX);
        });
        boutonModifierFilm.setBounds(815, 650, 170, 50);
        boutonModifierFilm.setForeground(frame.getSecondeCouleur());
        boutonModifierFilm.setBackground(frame.getMainCouleur());
        boutonModifierFilm.setFont(font2);
        admin.add(boutonModifierFilm);



        frame.RefreshPage();
    }

    public static void affichageEspaceAdmin3(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonSuppModifCompte, JButton boutonAfficherStat){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Arial", Font.BOLD, 20);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifCompte.setForeground(frame.getSecondeCouleur());
        boutonAfficherStat.setForeground(frame.getTroisCouleur());




        JPanel scrollBillets = new JPanel();
        scrollBillets.setBounds(150, 150, 1500, 5000);
        scrollBillets.setBackground(frame.getMainCouleur());
        scrollBillets.setBorder(BorderFactory.createEmptyBorder());
        scrollBillets.setLayout(new GridBagLayout()); // Utiliser GridBagLayout pour une disposition plus flexible

        // Ajout de labels pour étirer notre zone de scroll
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 0; // Hauteur spécifique
        gbc.insets = new Insets(10, 5, 10, 5); // Espacement entre les composants

        List<Utilisateur> utilisateurs = RecuperationUtilisateursListeners.recupUsers(frame);

        for (Utilisateur utilisateur : utilisateurs) {

            JPanel panelUtilisateurs = new JPanel();
            panelUtilisateurs.setLayout(null);
            panelUtilisateurs.setBackground(frame.getMainCouleur());
            panelUtilisateurs.setSize(1700, 125);
            panelUtilisateurs.setBorder(new RoundBorder(frame.getSecondeCouleur(), 60, 2));
            panelUtilisateurs.setPreferredSize(new Dimension(1700, 125));


            if(!utilisateur.getPhotoProfil().isEmpty()){
                BufferedImage image = ConvertirImageHexa.HexToImage(utilisateur.getPhotoProfil());
                Image image2 = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIconRounded(image2));
                imageLabel.setBounds(50, 10, 70, 70);
                panelUtilisateurs.add(imageLabel);
            }
            JPanel photoProfil = new JPanel();
            photoProfil.setLayout(null);
            photoProfil.setBackground(frame.getMainCouleur());
            photoProfil.setBounds(49, 9, 72, 72);
            photoProfil.setBorder(new RoundBorder(frame.getSecondeCouleur(), 200, 1));
            panelUtilisateurs.add(photoProfil);


            JLabel PrenomUtilisateur = new JLabel(utilisateur.getPrenom());
            PrenomUtilisateur.setFont(font1);
            PrenomUtilisateur.setForeground(frame.getSecondeCouleur());
            PrenomUtilisateur.setBounds(180, 10, 800, 30);
            panelUtilisateurs.add(PrenomUtilisateur);

            JLabel NomUtilisateur = new JLabel(utilisateur.getNom());
            NomUtilisateur.setFont(font1);
            NomUtilisateur.setForeground(frame.getSecondeCouleur());
            NomUtilisateur.setBounds(190 + PrenomUtilisateur.getPreferredSize().width, 10, 800, 30);
            panelUtilisateurs.add(NomUtilisateur);

            JLabel MailUtilisateur = new JLabel(utilisateur.getMail());
            MailUtilisateur.setFont(font3);
            MailUtilisateur.setForeground(frame.getSecondeCouleur());
            MailUtilisateur.setBounds(180, 50, 800, 20);
            panelUtilisateurs.add(MailUtilisateur);

            


            if(utilisateur.getAdmin() == 0){
                JButton boutonMettreAdmin = new JButton("Mettre Admin");
                boutonMettreAdmin.addActionListener(e -> {
                    int index = utilisateur.getIdCompte();
                    Utilisateur utilisateurSelec = RecuperationUtilisateurListeners.recupUtilisateur(frame, index);
                    utilisateurSelec.setAdmin(1);
                    ModifierUtilisateurListeners.modifUtilisateur(frame, utilisateurSelec);
                    ChangementPageListeners.ChangementPage("admin", frame);
                });
                boutonMettreAdmin.setBounds(1100, 40, 170, 40);
                boutonMettreAdmin.setForeground(frame.getSecondeCouleur());
                boutonMettreAdmin.setBackground(frame.getMainCouleur());
                boutonMettreAdmin.setFont(font2);
                panelUtilisateurs.add(boutonMettreAdmin);
            }
            else if(utilisateur.getAdmin() == 1){
                JButton boutonMettreAdmin = new JButton("Enlever Admin");
                boutonMettreAdmin.addActionListener(e -> {
                    int index = utilisateur.getIdCompte();
                    Utilisateur utilisateurSelec = RecuperationUtilisateurListeners.recupUtilisateur(frame, index);
                    utilisateurSelec.setAdmin(0);
                    ModifierUtilisateurListeners.modifUtilisateur(frame, utilisateurSelec);
                    ChangementPageListeners.ChangementPage("admin", frame);
                });
                boutonMettreAdmin.setBounds(1100, 40, 170, 40);
                boutonMettreAdmin.setForeground(frame.getSecondeCouleur());
                boutonMettreAdmin.setBackground(frame.getMainCouleur());
                boutonMettreAdmin.setFont(font2);
                panelUtilisateurs.add(boutonMettreAdmin);
            }
            


            JButton boutonSupprimer = new JButton("Supprimer");
            boutonSupprimer.addActionListener(e -> {
                int index = utilisateur.getIdCompte();
                Utilisateur utilisateurSelec = RecuperationUtilisateurListeners.recupUtilisateur(frame, index);
                SupprimerUtilisateurListeners.supprUtilisateur(frame, utilisateurSelec);
                ChangementPageListeners.ChangementPage("admin", frame);
            });
            LineBorder bordureNormale = new LineBorder(frame.getSecondeCouleur(), 1);
            LineBorder bordureSurvol = new LineBorder(Color.RED, 1);
            boutonSupprimer.setBorder(bordureNormale);
            boutonSupprimer.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boutonSupprimer.setBorder(bordureSurvol);
                }

                public void mouseExited(MouseEvent e) {
                    boutonSupprimer.setBorder(bordureNormale);
                }
            });
            boutonSupprimer.setBounds(1400, 40, 170, 40);
            boutonSupprimer.setForeground(Color.RED);
            boutonSupprimer.setBackground(frame.getMainCouleur());
            boutonSupprimer.setFont(font2);
            panelUtilisateurs.add(boutonSupprimer);



            scrollBillets.add(panelUtilisateurs, gbc);
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

        scrollPane.setBounds(50, 1, 1720, 768); // Ajustez la taille selon vos besoins

        admin.add(scrollPane);

        frame.RefreshPage();

    }

    public static void affichageEspaceAdmin4(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonSuppModifCompte, JButton boutonAfficherStat){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font1 = new Font("Arial", Font.BOLD, 30);
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifCompte.setForeground(frame.getTroisCouleur());
        boutonAfficherStat.setForeground(frame.getSecondeCouleur());

        JLabel Label = new JLabel("Nombre de billets vendu par Films");
        Label.setFont(font1);
        Label.setForeground(frame.getSecondeCouleur());
        Label.setBounds(657, 40, 486, 30);
        admin.add(Label);



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Film> films = RecuperationFilmsListeners.recupFilms(frame);

        for (Film film : films) {
            int nombreBillet = 0;
            List<Seance> seances = RecuperationSeancesByIDFilmListeners.recupSeances(frame, film.getIdFilm());
            for (Seance seance : seances) {
                List<Reservation> reservations = RecuperationReservationsByIDSeance.recupReservations(frame, seance.getIdSeance());
                for (Reservation reservation : reservations) {
                    nombreBillet = nombreBillet + CompterBilletsByIDReservation.compterBillets(frame, reservation.getIdReservation());
                }
            }
            dataset.addValue(nombreBillet, "Films", film.getNom());
        }


        JFreeChart chart = ChartFactory.createBarChart(
                "",        // Titre du graphique
                "",            // Titre de l'axe des abscisses
                "",          // Titre de l'axe des ordonnées
                dataset,              // Données
                PlotOrientation.HORIZONTAL, // Orientation du graphique
                false,                 // Afficher la légende
                true,                 // Activer les tooltips
                false                 // Activer les URLs
        );

        chart.setBackgroundPaint(frame.getMainCouleur());

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(frame.getMainCouleur());
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, frame.getSecondeCouleur());

        CategoryAxis abscisse = plot.getDomainAxis();
        abscisse.setTickLabelPaint(frame.getSecondeCouleur());
        
        NumberAxis ordonnee = (NumberAxis) plot.getRangeAxis();
        ordonnee.setTickLabelPaint(frame.getSecondeCouleur());

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1500, 650));

        chartPanel.setBounds(150, 100, 1500, 650);
        admin.add(chartPanel);



        frame.RefreshPage();
    }


    public static void affichageEspaceAdmin5(FrameBase frame, JPanel admin, JButton boutonAjouterFilm, JButton boutonSuppModifFilm, JButton boutonSuppModifCompte, JButton boutonAfficherStat, JButton boutonAjouterSeance){
        admin.removeAll();
        frame.RefreshPage();
        
        Font font2 = new Font("Arial", Font.BOLD, 20);
        
        
        boutonAjouterFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifFilm.setForeground(frame.getTroisCouleur());
        boutonSuppModifCompte.setForeground(frame.getTroisCouleur());
        boutonAfficherStat.setForeground(frame.getTroisCouleur());
        boutonAjouterSeance.setForeground(frame.getSecondeCouleur());
            

        Calendar cal = Calendar.getInstance();
        JDateChooser date = new JDateChooser();
        date.setBounds(450, 25, 300, 40);
        date.setDateFormatString("yyyy-MM-dd");
        JTextField dateEditor = ((JTextField) date.getDateEditor());
        dateEditor.setForeground(frame.getSecondeCouleur());
        dateEditor.setBackground(frame.getMainCouleur());
        date.setDate(cal.getTime());
        date.setFont(font2);
        admin.add(date);

        date.getDateEditor().addPropertyChangeListener(e -> {
            affichageEspaceAdmin5_bis(frame, admin, date, date.getDate());
        });

        affichageEspaceAdmin5_bis(frame, admin, date, date.getDate());

        frame.RefreshPage();
    }


    public static void affichageEspaceAdmin5_bis(FrameBase frame, JPanel admin, JDateChooser Date, Date date){
        Component[] composants = admin.getComponents();
        for (Component composant : composants) {
            if (composant != Date) {
                admin.remove(composant);
            }
        }
        admin.revalidate();
        admin.repaint();
        
        Font font3 = new Font("Arial", Font.BOLD, 15);
        Font font4 = new Font("Arial", Font.BOLD, 10);
        

        LineBorder bordure = new LineBorder(frame.getSecondeCouleur(), 1);

        JPanel heure = new JPanel();
        heure.setBounds(0, 100, 36, 670);
        heure.setBackground(frame.getMainCouleur());
        heure.setLayout(null);
        heure.setBorder(bordure);
        admin.add(heure);

        JLabel heure1Label = new JLabel("08h30");
        heure1Label.setFont(font4);
        heure1Label.setForeground(frame.getSecondeCouleur());
        heure1Label.setBounds(3, 3, 35, 10);
        heure.add(heure1Label);

        int j = 8;
        for(int i = 0 ; i < 16 ; i++){
            if(j + 1 < 10){
                JLabel heureLabel = new JLabel("0" + (j + 1) + "h00");
                heureLabel.setFont(font4);
                heureLabel.setForeground(frame.getSecondeCouleur());
                heureLabel.setBounds(3, 27 + i*42, 35, 10);
                heure.add(heureLabel);
            }
            else if(j + 1 == 24){
                JLabel heureLabel = new JLabel("00h00");
                heureLabel.setFont(font4);
                heureLabel.setForeground(frame.getSecondeCouleur());
                heureLabel.setBounds(3, 27 + i*42, 35, 10);
                heure.add(heureLabel);
            }
            else{
                JLabel heureLabel = new JLabel((j + 1) + "h00");
                heureLabel.setFont(font4);
                heureLabel.setForeground(frame.getSecondeCouleur());
                heureLabel.setBounds(3, 27 + i*42, 35, 10);
                heure.add(heureLabel);
            }
            j++;
        }






        
        JLabel salle10Label = new JLabel("10");
        salle10Label.setFont(font3);
        salle10Label.setForeground(frame.getSecondeCouleur());
        salle10Label.setBounds(75, 80, 20, 15);
        admin.add(salle10Label);
        
        JLabel salle11Label = new JLabel("11");
        salle11Label.setFont(font3);
        salle11Label.setForeground(frame.getSecondeCouleur());
        salle11Label.setBounds(173, 80, 20, 15);
        admin.add(salle11Label);

        JLabel salle12Label = new JLabel("12");
        salle12Label.setFont(font3);
        salle12Label.setForeground(frame.getSecondeCouleur());
        salle12Label.setBounds(271, 80, 20, 15);
        admin.add(salle12Label);

        JLabel salle13Label = new JLabel("13");
        salle13Label.setFont(font3);
        salle13Label.setForeground(frame.getSecondeCouleur());
        salle13Label.setBounds(369, 80, 20, 15);
        admin.add(salle13Label);

        JLabel salle14Label = new JLabel("14");
        salle14Label.setFont(font3);
        salle14Label.setForeground(frame.getSecondeCouleur());
        salle14Label.setBounds(467, 80, 20, 15);
        admin.add(salle14Label);

        JLabel salle15Label = new JLabel("15");
        salle15Label.setFont(font3);
        salle15Label.setForeground(frame.getSecondeCouleur());
        salle15Label.setBounds(565, 80, 20, 15);
        admin.add(salle15Label);

        JLabel salle16Label = new JLabel("16");
        salle16Label.setFont(font3);
        salle16Label.setForeground(frame.getSecondeCouleur());
        salle16Label.setBounds(663, 80, 20, 15);
        admin.add(salle16Label);

        JLabel salle17Label = new JLabel("17");
        salle17Label.setFont(font3);
        salle17Label.setForeground(frame.getSecondeCouleur());
        salle17Label.setBounds(761, 80, 20, 15);
        admin.add(salle17Label);

        JLabel salle20Label = new JLabel("20");
        salle20Label.setFont(font3);
        salle20Label.setForeground(frame.getSecondeCouleur());
        salle20Label.setBounds(859, 80, 20, 15);
        admin.add(salle20Label);

        JLabel salle21Label = new JLabel("21");
        salle21Label.setFont(font3);
        salle21Label.setForeground(frame.getSecondeCouleur());
        salle21Label.setBounds(957, 80, 20, 15);
        admin.add(salle21Label);

        JLabel salle22Label = new JLabel("22");
        salle22Label.setFont(font3);
        salle22Label.setForeground(frame.getSecondeCouleur());
        salle22Label.setBounds(1055, 80, 20, 15);
        admin.add(salle22Label);

        JLabel salle23Label = new JLabel("23");
        salle23Label.setFont(font3);
        salle23Label.setForeground(frame.getSecondeCouleur());
        salle23Label.setBounds(1153, 80, 20, 15);
        admin.add(salle23Label);

        JLabel salle24Label = new JLabel("24");
        salle24Label.setFont(font3);
        salle24Label.setForeground(frame.getSecondeCouleur());
        salle24Label.setBounds(1251, 80, 20, 15);
        admin.add(salle24Label);

        JLabel salle30Label = new JLabel("30");
        salle30Label.setFont(font3);
        salle30Label.setForeground(frame.getSecondeCouleur());
        salle30Label.setBounds(1349, 80, 20, 15);
        admin.add(salle30Label);

        JLabel salle31Label = new JLabel("31");
        salle31Label.setFont(font3);
        salle31Label.setForeground(frame.getSecondeCouleur());
        salle31Label.setBounds(1447, 80, 20, 15);
        admin.add(salle31Label);

        JLabel salle32Label = new JLabel("32");
        salle32Label.setFont(font3);
        salle32Label.setForeground(frame.getSecondeCouleur());
        salle32Label.setBounds(1545, 80, 20, 15);
        admin.add(salle32Label);

        JLabel salle33Label = new JLabel("33");
        salle33Label.setFont(font3);
        salle33Label.setForeground(frame.getSecondeCouleur());
        salle33Label.setBounds(1643, 80, 20, 15);
        admin.add(salle33Label);

        JLabel salle34Label = new JLabel("34");
        salle34Label.setFont(font3);
        salle34Label.setForeground(frame.getSecondeCouleur());
        salle34Label.setBounds(1741, 80, 20, 15);
        admin.add(salle34Label);





        JPanel[] salles1 = new JPanel[8];
        
        for (int i = 0; i < 8; i++) {
            salles1[i] = new JPanel();
            salles1[i].setBounds(35 + i*98, 100, 99, 670);
            salles1[i].setBackground(frame.getMainCouleur());
            salles1[i].setLayout(null);
            salles1[i].setBorder(bordure);
            admin.add(salles1[i]);
        }

        JPanel[] salles2 = new JPanel[5];
        
        for (int i = 0; i < 5; i++) {
            salles2[i] = new JPanel();
            salles2[i].setBounds(819 + i*98, 100, 99, 670);
            salles2[i].setBackground(frame.getMainCouleur());
            salles2[i].setLayout(null);
            salles2[i].setBorder(bordure);
            admin.add(salles2[i]);
        }

        JPanel[] salles3 = new JPanel[5];
        
        for (int i = 0; i < 5; i++) {
            salles3[i] = new JPanel();
            salles3[i].setBounds(1309 + i*98, 100, 99, 670);
            salles3[i].setBackground(frame.getMainCouleur());
            salles3[i].setLayout(null);
            salles3[i].setBorder(bordure);
            admin.add(salles3[i]);
        }

        
        for(int i = 0 ; i < 8 ; i++){
            String k = String.valueOf(i);
            k = "1" + k;
            List<Seance> seances = RecuperationSeancesByIDSalleAndDateListeners.recupSeances(frame, Integer.parseInt(k), date);
            if(!seances.isEmpty()){
                for(Seance seance : seances){
                    Film film = RecuperationFilmListeners.recupFilm(frame, seance.getIdFilm());
    
                    String[] parties = seance.getHeure().split(":");
    
                    int heuresDebut = Integer.parseInt(parties[0]);
                    int minutesDebut = Integer.parseInt(parties[1]);

                    heuresDebut = heuresDebut - 8;
                    minutesDebut = minutesDebut - 30;


                    String[] parties2 = film.getDuree().split(":");

                    int heuresDuree = Integer.parseInt(parties2[0]);
                    int minutesDuree = Integer.parseInt(parties2[1]);                
                        

                    JPanel seanceFilm = new JPanel();
                    seanceFilm.setBounds(1, (heuresDebut*42) + (int)(minutesDebut*0.7), 98, (heuresDuree*42) + (int)(minutesDuree*0.7));
                    seanceFilm.setBackground(frame.getSecondeCouleur());
                    seanceFilm.setLayout(null);
                    salles1[i].add(seanceFilm);
                    
                    JLabel TitreLabel = new JLabel(film.getNom());
                    TitreLabel.setFont(font4);
                    TitreLabel.setForeground(frame.getMainCouleur());
                    TitreLabel.setBounds(0, 10, 200, 10);
                    seanceFilm.add(TitreLabel);
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++){
            String k = String.valueOf(i);
            k = "2" + k;
            List<Seance> seances = RecuperationSeancesByIDSalleAndDateListeners.recupSeances(frame, Integer.parseInt(k), date);
            if(!seances.isEmpty()){
                for(Seance seance : seances){
                    Film film = RecuperationFilmListeners.recupFilm(frame, seance.getIdFilm());
    
                    String[] parties = seance.getHeure().split(":");
    
                    int heuresDebut = Integer.parseInt(parties[0]);
                    int minutesDebut = Integer.parseInt(parties[1]);

                    heuresDebut = heuresDebut - 8;
                    minutesDebut = minutesDebut - 30;


                    String[] parties2 = film.getDuree().split(":");

                    int heuresDuree = Integer.parseInt(parties2[0]);
                    int minutesDuree = Integer.parseInt(parties2[1]);
                    
                        

                    JPanel seanceFilm = new JPanel();
                    seanceFilm.setBounds(1, (heuresDebut*42) + (int)(minutesDebut*0.7), 98, (heuresDuree*42) + (int)(minutesDuree*0.7));
                    seanceFilm.setBackground(frame.getSecondeCouleur());
                    seanceFilm.setLayout(null);
                    salles2[i].add(seanceFilm);
                    
                    JLabel TitreLabel = new JLabel(film.getNom());
                    TitreLabel.setFont(font4);
                    TitreLabel.setForeground(frame.getMainCouleur());
                    TitreLabel.setBounds(0, 10, 200, 10);
                    seanceFilm.add(TitreLabel);

                    JLabel Titre2Label = new JLabel(seance.getIdSeance() + "");
                    Titre2Label.setFont(font4);
                    Titre2Label.setForeground(frame.getMainCouleur());
                    Titre2Label.setBounds(0, 35, 200, 10);
                    seanceFilm.add(Titre2Label);
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++){
            String k = String.valueOf(i);
            k = "3" + k;
            List<Seance> seances = RecuperationSeancesByIDSalleAndDateListeners.recupSeances(frame, Integer.parseInt(k), date);
            if(!seances.isEmpty()){
                for(Seance seance : seances){
                    Film film = RecuperationFilmListeners.recupFilm(frame, seance.getIdFilm());
    
                    String[] parties = seance.getHeure().split(":");
    
                    int heuresDebut = Integer.parseInt(parties[0]);
                    int minutesDebut = Integer.parseInt(parties[1]);

                    heuresDebut = heuresDebut - 8;
                    minutesDebut = minutesDebut - 30;


                    String[] parties2 = film.getDuree().split(":");

                    int heuresDuree = Integer.parseInt(parties2[0]);
                    int minutesDuree = Integer.parseInt(parties2[1]);
                    
                        

                    JPanel seanceFilm = new JPanel();
                    seanceFilm.setBounds(1, (heuresDebut*42) + (int)(minutesDebut*0.7), 98, (heuresDuree*42) + (int)(minutesDuree*0.7));
                    seanceFilm.setBackground(frame.getSecondeCouleur());
                    seanceFilm.setLayout(null);
                    salles3[i].add(seanceFilm);
                    
                    JLabel TitreLabel = new JLabel(film.getNom());
                    TitreLabel.setFont(font4);
                    TitreLabel.setForeground(frame.getMainCouleur());
                    TitreLabel.setBounds(0, 10, 200, 10);
                    seanceFilm.add(TitreLabel);

                    JLabel Titre2Label = new JLabel(seance.getIdSeance() + "");
                    Titre2Label.setFont(font4);
                    Titre2Label.setForeground(frame.getMainCouleur());
                    Titre2Label.setBounds(0, 35, 200, 10);
                    seanceFilm.add(Titre2Label);
                }
            }
        }
        
        
        frame.RefreshPage();
    }
    
}
