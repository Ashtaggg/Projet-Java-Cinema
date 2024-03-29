package src.M.JAVA_MODEL.Global_CLASS;

//Imports
import java.util.Date;

public class Utilisateur {
    private int idCompte;
    private int admin;
    private String prenom;
    private String nom;
    private String motDePasse;
    private Date dateNaissance;
    private String photoProfil;
    private String mail;
    private String telephone;
    private String adresse;
    private int genre;
    private String carteNum;
    private String carteDate;
    private int carteCCV;
    private String carteNom;

    // Constructeur
    public Utilisateur(int idCompte, int admin, String prenom, String nom, String motDePasse, Date dateNaissance,
                       String photoProfil, String mail, String telephone, String adresse, int genre, String carteNum,
                       String carteDate, int carteCCV, String carteNom) {
        this.idCompte = idCompte;
        this.admin = admin;
        this.prenom = prenom;
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.photoProfil = photoProfil;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.genre = genre;
        this.carteNum = carteNum;
        this.carteDate = carteDate;
        this.carteCCV = carteCCV;
        this.carteNom = carteNom;
    }

    // Getters et Setters
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getCarteNum() {
        return carteNum;
    }

    public void setCarteNum(String carteNum) {
        this.carteNum = carteNum;
    }

    public String getCarteDate() {
        return carteDate;
    }

    public void setCarteDate(String carteDate) {
        this.carteDate = carteDate;
    }

    public int getCarteCCV() {
        return carteCCV;
    }

    public void setCarteCCV(int carteCCV) {
        this.carteCCV = carteCCV;
    }

    public String getCarteNom() {
        return carteNom;
    }

    public void setCarteNom(String carteNom) {
        this.carteNom = carteNom;
    }
}
