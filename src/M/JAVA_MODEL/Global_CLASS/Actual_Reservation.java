package M.JAVA_MODEL.Global_CLASS;

public class Actual_Reservation extends Reservation {
    private Seance Actual_Reservation_Seance;

    // Constructeur
    public Actual_Reservation(int idReservation, int idCompte, int idSeance, int nombrePlace, int prixTotal, Seance actual_Reservation_Seance) {
        super(idReservation, idCompte, idSeance, nombrePlace, prixTotal);
        this.Actual_Reservation_Seance = actual_Reservation_Seance;
    }

    // Getter et Setter pour actual_Reservation_Seance
    public Seance getActual_Reservation_Seance() {
        return Actual_Reservation_Seance;
    }

    public void setActual_Reservation_Seance(Seance actual_Reservation_Seance) {
        this.Actual_Reservation_Seance = actual_Reservation_Seance;
    }
}
