package C.Listeners.PageCompte;

import C.Listeners.ChangementPageListeners;
import V.FrameBase;

public class DeconnexionListeners {
    public static void deconnexion(FrameBase frame){
        frame.userActuel = null;
        ChangementPageListeners.ChangementPage("compte", frame);
    }
}
