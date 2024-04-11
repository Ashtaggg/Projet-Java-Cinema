package C.Listeners.Page_ReservationSeance;

//Import fichiers
import V.FrameBase;
import C.Listeners.ChangementPageListeners;

//Import librairies


public class ReservationSeanceListeners {
    public static void ValiderReservation(FrameBase frame, int nbTicketNormal, int nbTicketJeune, int nbTicketAdo, int CodePromo){
        frame.reservationActuelle.setNbTicketNormal(nbTicketNormal);
        frame.reservationActuelle.setNbTicketJeune(nbTicketJeune);
        frame.reservationActuelle.setNbTicketAdo(nbTicketAdo);
        frame.reservationActuelle.setNombrePlace(nbTicketNormal+nbTicketJeune+nbTicketAdo);
        frame.reservationActuelle.setPromo(CodePromo);
        frame.reservationActuelle.setPrixTotal(frame.reservationActuelle.getNbTicketNormal() * (15.50*CodePromo) + frame.reservationActuelle.getNbTicketJeune() * (9.90*CodePromo) + frame.reservationActuelle.getNbTicketAdo() * (6.50*CodePromo));
        System.out.println("Nombre de ticket normal : " + frame.reservationActuelle.getNbTicketNormal());
        System.out.println("Nombre de ticket jeune : " + frame.reservationActuelle.getNbTicketJeune());
        System.out.println("Nombre de ticket ado : " + frame.reservationActuelle.getNbTicketAdo());
        System.out.println("Prix total : " + frame.reservationActuelle.getPrixTotal());
        ChangementPageListeners changementPageListeners = new ChangementPageListeners();
        changementPageListeners.ChangementPage("reservation_seance_place", frame);
    }
}
