package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Reservation;
import V.FrameBase;

import java.util.List;

public class RecuperationReservationsByIDSeance {
    public static List<Reservation> recupReservations(FrameBase frame, int ID){
        List<Reservation> reservations = frame.reservationsDAO.recupererToutesLesReservationsByIDSeance(ID);
        return reservations;
    }
}
