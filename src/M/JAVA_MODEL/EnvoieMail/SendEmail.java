import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void EnvoieMail() {
        // Paramètres SMTP de Gmail
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "votreadresse@gmail.com";
        String password = "votremotdepasse";

        // Propriétés pour la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Créer une session
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Créer un message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinataire@example.com"));
            message.setSubject("Sujet de l'e-mail");
            message.setText("Contenu de l'e-mail");

            // Envoyer le message
            Transport.send(message);

            System.out.println("E-mail envoyé avec succès.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
