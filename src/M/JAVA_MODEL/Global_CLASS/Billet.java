package M.JAVA_MODEL.Global_CLASS;

public class Billet {
    private int idBillet;
    private int idReservation;
    private int numeroPlace;
    private String typeBillet;

    // Constructeur
    public Billet(int idBillet, int idReservation, int numeroPlace, String typeBillet) {
        this.idBillet = idBillet;
        this.idReservation = idReservation;
        this.numeroPlace = numeroPlace;
        this.typeBillet = typeBillet;
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
}

