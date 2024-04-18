package M.Utilisateur;

import C.Listeners.ChangementPageListeners;
import M.DAO.DAO_MYSQL_WAMP.Utilisateur.UtilisateursDAO_IMPL;
import V.FrameBase;

import javax.swing.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validation {
    public static void valider(FrameBase frame, JLabel problemValidationLabel, String photo, String Prenom, String Nom, String Mail, String Tel, Date Date, String Adresse, String Mdp, String Mdp2, String CarteNum, String CarteDate, String CarteCCV, String CarteNom){
        
        int mailUtilise = 0;
        UtilisateursDAO_IMPL utilisateurDAO = new UtilisateursDAO_IMPL();
        if(!Mail.equals(frame.userActuel.getMail())){
            mailUtilise = utilisateurDAO.emailDejaUtilise(Mail);
        }
        if(mailUtilise == 1){
            problemValidationLabel.setText("L'adresse mail est déjà utilisé");
            problemValidationLabel.setBounds(271, 270, 209, 24);
            problemValidationLabel.setVisible(true);
        }
        else{
            if(Prenom.equals("")){
                problemValidationLabel.setText("Le prenom est incomplet");
                problemValidationLabel.setBounds(288, 270, 175, 24);
                problemValidationLabel.setVisible(true);
            }
            else if(Nom.equals("")){
                problemValidationLabel.setText("Le nom est incomplet");
                problemValidationLabel.setBounds(300, 270, 151, 24);
                problemValidationLabel.setVisible(true);
            }
            else if(Mail.equals("")){
                problemValidationLabel.setText("L'adresse mail est incomplete");
                problemValidationLabel.setBounds(270, 270, 210, 24);
                problemValidationLabel.setVisible(true);
            }
            else if(!Mdp.equals(Mdp2)){
                problemValidationLabel.setText("Le mot de passe est erroné");
                problemValidationLabel.setBounds(278, 270, 194, 24);
                problemValidationLabel.setVisible(true);
            }
            else if(CarteNum.length() != 16 && CarteNum.length() != 19){
                problemValidationLabel.setText("Les chiffres de la carte banquaire sont erronés");
                problemValidationLabel.setBounds(209, 270, 332, 24);
                problemValidationLabel.setVisible(true);
            }
            else if(Integer.parseInt(CarteCCV) < 100 || Integer.parseInt(CarteCCV) > 999){
                problemValidationLabel.setText("Le CCV de la carte banquaire est erroné");
                problemValidationLabel.setBounds(233, 270, 284, 24);
                problemValidationLabel.setVisible(true);
            }
            else{
                problemValidationLabel.setText("");
                problemValidationLabel.setBounds(375, 270, 327, 24);
                problemValidationLabel.setVisible(true);
                frame.userActuel.setPhotoProfil(photo);
                frame.userActuel.setPrenom(Prenom);
                frame.userActuel.setNom(Nom);
                frame.userActuel.setMail(Mail);
                frame.userActuel.setTelephone(Tel);
                frame.userActuel.setDateNaissance(Date);
                frame.userActuel.setAdresse(Adresse);
                if(!Mdp.equals("")){
                    try {
                        MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
                        byte[] hashBytes = digest.digest(Mdp.getBytes());
            
                        StringBuilder hashHex = new StringBuilder();
                        for (byte hashByte : hashBytes) {
                            String hex = Integer.toHexString(0xff & hashByte);
                            if (hex.length() == 1) hashHex.append('0');
                            hashHex.append(hex);
                        }
                        Mdp = hashHex.toString();
                    } catch (NoSuchAlgorithmException error) {
                        System.out.println(error);
                    }
                    frame.userActuel.setMotDePasse(Mdp);
                }
                if(CarteNum.length() == 19){
                    CarteNum = CarteNum.replaceAll("\\s", "");
                }
                frame.userActuel.setCarteNum(CarteNum);
                frame.userActuel.setCarteDate(CarteDate);
                frame.userActuel.setCarteCCV(Integer.parseInt(CarteCCV));
                frame.userActuel.setCarteNom(CarteNom);
    
                utilisateurDAO.modifierUtilisateur(frame.userActuel);
    
                ChangementPageListeners.ChangementPage("compte", frame);
            }
        }
    }
}
