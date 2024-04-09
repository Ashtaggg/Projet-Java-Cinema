package M.Utilisateur;

import M.DAO.DAO_MYSQL_WAMP.Utilisateur.UtilisateursDAO_IMPL;
import V.FrameBase;
import V.EspaceUtilisateur.PageInscription2;

import javax.swing.*;
import java.util.Date;

public class Inscription {
    public static void suivant1(FrameBase frame, JLabel problemConnexionLabel, String prenom, String nom, String mail, Date date){
        int mailUtilise = 0;
        UtilisateursDAO_IMPL utilisateurDAO = new UtilisateursDAO_IMPL();
        mailUtilise = utilisateurDAO.emailDejaUtilise(mail);
        if(mailUtilise == 1){
            problemConnexionLabel.setText("L'adresse mail est déjà utilisé");
            problemConnexionLabel.setBounds(271, 490, 209, 24);
            problemConnexionLabel.setVisible(true);
        }
        else if(prenom.equals("")){
            problemConnexionLabel.setText("Le prenom est incomplet");
            problemConnexionLabel.setBounds(288, 490, 175, 24);
            problemConnexionLabel.setVisible(true);
        }
        else if(nom.equals("")){
            problemConnexionLabel.setText("Le nom est incomplet");
            problemConnexionLabel.setBounds(300, 490, 151, 24);
            problemConnexionLabel.setVisible(true);
        }
        else if(mail.equals("")){
            problemConnexionLabel.setText("L'adresse mail est incomplete");
            problemConnexionLabel.setBounds(270, 490, 210, 24);
            problemConnexionLabel.setVisible(true);
        }
        else{
            PageInscription2.affichagePageInscription2(frame, prenom, nom, mail, date);
        }
    }

    public static void inscrire(FrameBase frame, JLabel problemConnexionLabel, String prenom, String nom, String mail, Date date, String tel, String adresse, String mdp, String mdp2){
        if(mdp.equals("")){
            problemConnexionLabel.setText("Le mot de passe est incomplet");
            problemConnexionLabel.setBounds(268, 490, 215, 24);
            problemConnexionLabel.setVisible(true);
        }
        else if(mdp.equals(mdp2)){
            problemConnexionLabel.setText("Le mot de passe est erroné");
            problemConnexionLabel.setBounds(278, 490, 194, 24);
            problemConnexionLabel.setVisible(true);
        }
        else{
            //Créer la m"thode pour ajouter un compte dans M.DAO.DAO_MYSQL_WAMP.Utilisateur
            //Créer le compte dans la bdd
        }
    }
}
