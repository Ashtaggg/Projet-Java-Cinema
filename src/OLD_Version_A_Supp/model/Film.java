package src.OLD_Version_A_Supp.model;

public class Film {
    private int id;
    private String title;
    private String description;
    private String schedule;
    private double ticketPrice;

    public Film() {
        // Constructeur par défaut
    }

    public Film(int id, String title, String description, String schedule, double ticketPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.ticketPrice = ticketPrice;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
