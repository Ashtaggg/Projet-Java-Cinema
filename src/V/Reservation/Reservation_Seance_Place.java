package V.Reservation;

//Imports Fichiers
import V.FrameBase;

//Imports Librairies
// Importation des librairies
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.w3c.dom.Text;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Reservation_Seance_Place {
    public static ArrayList<Integer> places = new ArrayList<Integer>();
    public static ArrayList<Integer> numplacesReservees = new ArrayList<Integer>();
    
    public static void affichageReservation_Seance_Place(FrameBase frame){
        for (int i=0; i<frame.reservationActuelle.getNbTicketNormal(); i++){
            places.add(1);
        }
        for (int i=0; i<frame.reservationActuelle.getNbTicketJeune(); i++){
            places.add(2);
        }
        for (int i=0; i<frame.reservationActuelle.getNbTicketAdo(); i++){
            places.add(3);
        }

        
    }
    
}
