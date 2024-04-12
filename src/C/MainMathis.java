package C;

import V.testAffichageMathis;
import V.TestEnfFrameBase;
import V.Reservation.Reservation_Seance;
import V.Reservation.Reservation_Seance_Place;
import V.Reservation.Recap_Reservation;
import V.Panier.Panier;

import V.FrameBase;

import java.awt.Color;

public class MainMathis {

    //Variables
    
    public static void main(String[] ags)
    {
        //testAffichageMathis test = new testAffichageMathis();
        //test.affichage((new Color(250, 250, 250)), (new Color(0, 19, 77)), (new Color(0, 0, 0)));
        FrameBase frame = new FrameBase();
        //TestEnfFrameBase.affichertestEnfFrameBase(frame);
        Reservation_Seance.affichageReservation_Seance(frame);
        //Reservation_Seance_Place.affichageReservation_Seance_Place(frame);
        //Recap_Reservation.afficherRecapreservation(frame);
        //Panier.affichagePanier(frame);
    }
}
