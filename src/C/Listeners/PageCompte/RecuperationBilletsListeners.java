package C.Listeners.PageCompte;

import M.JAVA_MODEL.Global_CLASS.Billet;
import V.FrameBase;

import java.util.List;

public class RecuperationBilletsListeners {
    public static List<Billet> recupBillets(FrameBase frame){
        List<Billet> billetsUser = frame.billetDAO.recupererBilletsByID_Compte(frame);
        return billetsUser;
    }
}
