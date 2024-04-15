package M.Utilisateur;

import C.Listeners.ChangementPageListeners;
import M.DAO.DAO_MYSQL_WAMP.Utilisateur.UtilisateursDAO_IMPL;
import M.JAVA_MODEL.Global_CLASS.Utilisateur;
import V.FrameBase;


import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Connexion {
    public static void connexionToUser(FrameBase frame, JLabel problemConnexionLabel, String mail, String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(password.getBytes());

            StringBuilder hashHex = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hashHex.append('0');
                hashHex.append(hex);
            }
            password = hashHex.toString();
        } catch (NoSuchAlgorithmException error) {
            System.out.println(error);
        }

        UtilisateursDAO_IMPL utilisateurDAO = new UtilisateursDAO_IMPL();
        int mailUtilise = 0;
        Utilisateur user = null;
        mailUtilise = utilisateurDAO.emailDejaUtilise(mail);
        if(mailUtilise == 1){
            user = utilisateurDAO.recupererUtilisateurByEmail(mail);
        }

        /*System.out.println("idCompte : " + user.getIdCompte());
        System.out.println("admin : " + user.getAdmin());
        System.out.println("prenom : " + user.getPrenom());
        System.out.println("nom : " + user.getNom());
        System.out.println("motDePasse : " + user.getMotDePasse());
        System.out.println("dateNaissance : " + user.getDateNaissance());
        System.out.println("photoProfil : " + user.getPhotoProfil());
        System.out.println("mail : " + user.getMail());
        System.out.println("telephone : " + user.getTelephone());
        System.out.println("adresse : " + user.getAdresse());
        System.out.println("genre : " + user.getGenre());
        System.out.println("carteNum : " + user.getCarteNum());
        System.out.println("carteDate : " + user.getCarteDate());
        System.out.println("carteCCV : " + user.getCarteCCV());
        System.out.println("carteNom : " + user.getCarteNom());*/

        if(user == null){
            problemConnexionLabel.setVisible(true);
        }
        else if(!password.equals(user.getMotDePasse())){
            problemConnexionLabel.setVisible(true);
        }
        else{
            problemConnexionLabel.setVisible(false);
            frame.userActuel = user;
            ChangementPageListeners.ChangementPage("compte", frame);
        }
    }
}
