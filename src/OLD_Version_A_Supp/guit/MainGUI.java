package src.OLD_Version_A_Supp.guit;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Film {
    private String title;
    private String description;
    private String schedule;
    private double ticketPrice;

    public Film(String title, String description, String schedule, double ticketPrice) {
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

class CinemaPanel extends JPanel {
    private List<Film> films;

    public CinemaPanel(List<Film> films) {
        this.films = films;
        setLayout(new GridLayout(films.size(), 1));

        for (Film film : films) {
            JPanel filmPanel = new JPanel(new BorderLayout());
            filmPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            JLabel titleLabel = new JLabel(film.getTitle());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            filmPanel.add(titleLabel, BorderLayout.NORTH);

            JTextArea detailsArea = new JTextArea();
            detailsArea.append("Description: " + film.getDescription() + "\n");
            detailsArea.append("Schedule: " + film.getSchedule() + "\n");
            detailsArea.append("Ticket Price: $" + film.getTicketPrice() + "\n");
            filmPanel.add(detailsArea, BorderLayout.CENTER);

            add(filmPanel);
        }
    }
}

public class MainGUI {
    public static void main(String[] args) {
        // Création des films
        List<Film> films = new ArrayList<>();
        films.add(new Film("Film 1", "Description 1", "Schedule 1", 10.50));
        films.add(new Film("Film 2", "Description 2", "Schedule 2", 12.00));
        films.add(new Film("Film 3", "Description 3", "Schedule 3", 9.99));

        // Création de la fenêtre principale
        JFrame frame = new JFrame("Cinema Site");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Ajout du panneau de cinéma à la fenêtre principale
        frame.getContentPane().add(new JScrollPane(new CinemaPanel(films)));

        // Affichage de la fenêtre
        frame.setVisible(true);
    }
}
