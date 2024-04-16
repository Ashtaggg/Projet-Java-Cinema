package C.Listeners.PageCompte;

import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Seance;

public class RecuperationSeanceListeners {
    public static Seance recupSeance(FrameBase frame, int ID){
        Seance seance = frame.seancesDAO.recupererSeanceByID(ID);
        return seance;
    }
}
