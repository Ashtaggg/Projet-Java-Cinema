package M.JAVA_MODEL.Global_CLASS;

public class Salle {
    private int idSalle;
    private int nombrePlace;
    private int etage;
    private boolean quatreDX;

    // Constructeur
    public Salle(int idSalle, int nombrePlace, int etage, boolean quatreDX) {
        this.idSalle = idSalle;
        this.nombrePlace = nombrePlace;
        this.etage = etage;
        this.quatreDX = quatreDX;
    }

    // Getters et Setters
    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public boolean getQuatreDX() {
        return quatreDX;
    }

    public void setQuatreDX(boolean quatreDX) {
        this.quatreDX = quatreDX;
    }
}
