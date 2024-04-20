package C;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import V.FrameBase;
import V.Accueil.Accueil_Films;
import V.FilmInfo.DateSéances;;


public class MainAnthony {

    public static void main(String[] ags)
    {

        FrameBase frame = new FrameBase();
        DateSéances.affichageDateSeances(frame);
    }
}

