package C.Listeners.PageCompte;

import V.FrameBase;
import M.JAVA_MODEL.Global_CLASS.Film;

public class RecuperationFilmListeners {
    public static Film recupFilm(FrameBase frame, int ID){
        Film film = frame.filmsDAO.recupererFilmByID(ID);
        return film;
    }
}
