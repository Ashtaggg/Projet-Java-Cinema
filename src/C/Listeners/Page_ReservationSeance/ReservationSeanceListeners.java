package C.Listeners.Page_ReservationSeance;

//Import fichiers
import V.FrameBase;
import C.Listeners.ChangementPageListeners;

//Import librairies


public class ReservationSeanceListeners {
    public static void ValiderReservation(FrameBase frame, int nbTicketNormal, int nbTicketJeune, int nbTicketAdo, double CodePromo){
        int sizeLR = frame.reservationActuelle.size();
        frame.reservationActuelle.get(sizeLR-1).setNbTicketNormal(nbTicketNormal);
        frame.reservationActuelle.get(sizeLR-1).setNbTicketJeune(nbTicketJeune);
        frame.reservationActuelle.get(sizeLR-1).setNbTicketAdo(nbTicketAdo);
        frame.reservationActuelle.get(sizeLR-1).setNombrePlace(nbTicketNormal + nbTicketJeune + nbTicketAdo);
        frame.reservationActuelle.get(sizeLR-1).setPromo(CodePromo);
        frame.reservationActuelle.get(sizeLR-1).setPrixTotal(nbTicketNormal * (10.99*CodePromo) + nbTicketJeune * (8.79*CodePromo) + nbTicketAdo * (6.59*CodePromo));
        System.out.println("Taille de la liste de reservation : " + sizeLR);
        System.out.println("Nombre de ticket normal : " + frame.reservationActuelle.get(sizeLR-1).getNbTicketNormal());
        System.out.println("Nombre de ticket jeune : " + frame.reservationActuelle.get(sizeLR-1).getNbTicketJeune());
        System.out.println("Nombre de ticket ado : " + frame.reservationActuelle.get(sizeLR-1).getNbTicketAdo());
        System.out.println("Prix total : " + frame.reservationActuelle.get(sizeLR-1).getPrixTotal());
        ChangementPageListeners.ChangementPage("reservation_seance_place", frame);
    }
}
