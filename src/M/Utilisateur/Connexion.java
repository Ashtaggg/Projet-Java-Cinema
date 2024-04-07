package M.Utilisateur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Connexion {
    public void connexionToUser(String mail, String password){
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

        System.out.println("Mail : " + mail);
        System.out.println("MdP : " + password);
        System.out.println("Connexion...");


        //Vérifier si un compte existe avec l'email             --> Créer toutes les méthodes dans le DAO.DAO_MYSQL_WAMP.Utilisateur
        //Si oui alors voir si le sha256 du mdp correspond
        //Sinon retourner dans le MainAlexis puis dans le testAffichageAlexis pour afficher une erreur (peut-être avec return 0)
    }
}
