package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Seance;
import V.FrameBase;

import java.util.List;

public class RecuperationSeancesByIDFilmListeners {
    public static List<Seance> recupSeances(FrameBase frame, int ID){
        List<Seance> seances = frame.seancesDAO.recupererToutesLesSeancesByIDFilm(ID);
        return seances;
    }
}
