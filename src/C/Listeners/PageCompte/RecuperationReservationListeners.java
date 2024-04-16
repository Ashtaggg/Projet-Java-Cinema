package C.Listeners.PageCompte;

import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Reservation;

public class RecuperationReservationListeners {
    public static Reservation recupReservation(FrameBase frame, int ID){
        Reservation reservation = frame.reservationsDAO.recupererReservationByID(ID);
        return reservation;
    }
}
