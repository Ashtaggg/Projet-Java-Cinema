package M.JAVA_MODEL.Global_CLASS;


import java.util.ArrayList;
import java.util.List;
//Imports

public class Reservation {
    private int idReservation;
    private int idCompte;
    private int idSeance;
    private int nombrePlace;
    private int nbTicketNormal;
    private int nbTicketJeune;
    private int nbTicketAdo;
    private List<Integer> numPlaces = new ArrayList<Integer>();
    private double Promo;
    private double prixTotal;

    // Constructeurs
    public Reservation(int idReservation, int idCompte, int idSeance, int nombrePlace, double prixTotal) {
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

    public int getNbTicketNormal() {
        return nbTicketNormal;
    }

    public void setNbTicketNormal(int nbTicketNormal) {
        this.nbTicketNormal = nbTicketNormal;
    }

    public int getNbTicketJeune() {
        return nbTicketJeune;
    }

    public void setNbTicketJeune(int nbTicketJeune) {
        this.nbTicketJeune = nbTicketJeune;
    }

    public int getNbTicketAdo() {
        return nbTicketAdo;
    }

    public void setNbTicketAdo(int nbTicketAdo) {
        this.nbTicketAdo = nbTicketAdo;
    }

    public List<Integer> getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(List<Integer> numPlaces) {
        this.numPlaces = numPlaces;
    }

    public double getPromo() {
        return Promo;
    }

    public void setPromo(double promo) {
        Promo = promo;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
