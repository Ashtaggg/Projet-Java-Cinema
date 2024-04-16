package C.Listeners.Accueil;

import M.DAO.DAO_MYSQL_WAMP.Films.FilmsDAO_IMPL;
import M.JAVA_MODEL.Global_CLASS.Film;
import V.FrameBase;
import V.Accueil.Accueil_Films;

public class AccueilFilmsListeners {

    public static void accueilFilmsListeners(FrameBase frame, String titre) {
        FilmsDAO_IMPL filmsDAO = new FilmsDAO_IMPL();
        Film film = filmsDAO.recupererFilmByTitre(titre);
        Accueil_Films.affichageAccueil_Films(frame);
    }
}
