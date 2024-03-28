package src.OLD_Version_A_Supp.model;

public class Reservation {
    private int id;
    private int filmId;
    private int clientId;
    private int numberOfTickets;

    public Reservation() {
        // Constructeur par défaut
    }

    public Reservation(int id, int filmId, int clientId, int numberOfTickets) {
        this.id = id;
        this.filmId = filmId;
        this.clientId = clientId;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
