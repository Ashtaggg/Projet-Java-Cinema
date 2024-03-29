package src.M.JAVA_MODEL.Global_CLASS;

//Imports
import java.util.Date;

public class Seance {
    private int idSeance;
    private int idFilm;
    private int idSalle;
    private Date date;
    private String heure;
    private int placeDisponible;

    // Constructeur
    public Seance(int idSeance, int idFilm, int idSalle, Date date, String heure, int placeDisponible) {
        this.idSeance = idSeance;
        this.idFilm = idFilm;
        this.idSalle = idSalle;
        this.date = date;
        this.heure = heure;
        this.placeDisponible = placeDisponible;
    }

    // Getters et Setters
    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getPlaceDisponible() {
        return placeDisponible;
    }

    public void setPlaceDisponible(int placeDisponible) {
        this.placeDisponible = placeDisponible;
    }
}
