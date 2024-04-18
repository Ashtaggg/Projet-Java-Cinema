package M.JAVA_MODEL.Global_CLASS;

//Imports
import java.util.Date;

public class Film {
    private int idFilm;
    private String nom;
    private double prix;
    private Date dateSortie;
    private String photo;
    private String duree;
    private String description;
    private double note;
    private boolean quatreDX;
    private String realisateur;
    private String acteur;
    private String synopsis;

    // Constructeur
    public Film(int idFilm, String nom, double prix, Date dateSortie, String photo, String duree, String description,
                double note, boolean quatreDX, String realisateur, String acteur, String synopsis) {
        this.idFilm = idFilm;
        this.nom = nom;
        this.prix = prix;
        this.dateSortie = dateSortie;
        this.photo = photo;
        this.duree = duree;
        this.description = description;
        this.note = note;
        this.quatreDX = quatreDX;
        this.realisateur = realisateur;
        this.acteur = acteur;
        this.synopsis = synopsis;
    }

    // Getters et Setters
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public boolean getQuatreDX() {
        return quatreDX;
    }

    public void setQuatreDX(boolean quatreDX) {
        this.quatreDX = quatreDX;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
