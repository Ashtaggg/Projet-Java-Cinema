package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Seance;
import V.FrameBase;

import java.util.List;
import java.util.Date;

public class RecuperationSeancesByIDSalleAndDateListeners {
    public static List<Seance> recupSeances(FrameBase frame, int ID, Date date){
        List<Seance> seances = frame.seancesDAO.recupererToutesLesSeancesByIDSalleAndDate(ID, date);
        return seances;
    }
}
