package M.JAVA_MODEL.Global_CLASS;

public class Billet {
    private int idBillet;
    private int idReservation;
    private int numeroPlace;
    private String typeBillet;
    private double prix;

    // Constructeur
    public Billet(int idBillet, int idReservation, int numeroPlace, String typeBillet, double prix) {
        this.idBillet = idBillet;
        this.idReservation = idReservation;
        this.numeroPlace = numeroPlace;
        this.typeBillet = typeBillet;
        this.prix = prix;
    }


    // Getters et Setters
    public int getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(int idBillet) {
        this.idBillet = idBillet;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }


    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public String getTypeBillet() {
        return typeBillet;
    }

    public void setTypeBillet(String typeBillet) {
        this.typeBillet = typeBillet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

