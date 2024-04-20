package C.Listeners.PageAdmin;

import V.FrameBase;

public class CompterBilletsByIDReservation {
    public static int compterBillets(FrameBase frame, int ID){
        int billets = frame.billetDAO.compterTousLesBilletsByIDReservation(ID);
        return billets;
    }
}
