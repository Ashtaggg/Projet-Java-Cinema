package src.M.JAVA_MODEL.Global_CLASS;

//Imports

public class Reservation {
    private int idReservation;
    private int idCompte;
    private int idSeance;
    private int nombrePlace;
    private int prixTotal;

    // Constructeur
    public Reservation(int idReservation, int idCompte, int idSeance, int nombrePlace, int prixTotal) {
        this.idReservation = idReservation;
        this.idCompte = idCompte;
        this.idSeance = idSeance;
        this.nombrePlace = nombrePlace;
        this.prixTotal = prixTotal;
    }

    // Getters et Setters
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }
}
