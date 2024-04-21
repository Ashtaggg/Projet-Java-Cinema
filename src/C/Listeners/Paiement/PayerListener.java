package C.Listeners.Paiement;

//Imports Fichiers
import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Billet;
import M.JAVA_MODEL.Global_CLASS.Reservation;

//Imports Librairies
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;*/


//int idBillet, int idReservation, int numeroPlace, String typeBillet, double prix

public class PayerListener {
    public static int Payer(FrameBase frame){
        System.out.println("Paiement effectué");
        int nbBilletcréé = 0;
        int nbResaOK = 0;
        //On a besoin de tout les éléments de la réservation
        //On a aussi besoin de la seance et de toutes ses informations
        for (int i =0; i<frame.nombreReservationsPanier; i++)
        {
            try {
                frame.reservationsDAO.ajouterReservation(frame.reservationActuelle.get(i));
                Reservation reservationAct = frame.reservationsDAO.recupererDerniereReservation();
                for (int j = 0; j<frame.reservationActuelle.get(i).getNbTicketNormal(); j++)
                {

                    Billet billet = new Billet(0, reservationAct.getIdReservation(), frame.reservationActuelle.get(i).getNumPlaces().get(nbBilletcréé), "Adulte", 10.99*frame.reservationActuelle.get(i).getPromo());

                    frame.billetDAO.ajouterBillet(billet);
                    nbBilletcréé++;
                }
                for (int j = 0; j<frame.reservationActuelle.get(i).getNbTicketJeune(); j++)
                {
                    Billet billet = new Billet(0, reservationAct.getIdReservation(), frame.reservationActuelle.get(i).getNumPlaces().get(nbBilletcréé), "Etudiant", 8.79*frame.reservationActuelle.get(i).getPromo());

                    frame.billetDAO.ajouterBillet(billet);
                    nbBilletcréé++;
                }
                for (int j = 0; j<frame.reservationActuelle.get(i).getNbTicketAdo(); j++)
                {
                    Billet billet = new Billet(0, reservationAct.getIdReservation(), frame.reservationActuelle.get(i).getNumPlaces().get(nbBilletcréé), "Enfant", 6.59*frame.reservationActuelle.get(i).getPromo());

                    frame.billetDAO.ajouterBillet(billet);
                    nbBilletcréé++;
                }
                if(nbBilletcréé == frame.reservationActuelle.get(i).getNombrePlace())
                {
                    nbResaOK++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(nbResaOK == frame.nombreReservationsPanier)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
