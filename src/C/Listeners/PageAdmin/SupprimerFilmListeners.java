package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Film;
import V.FrameBase;

public class SupprimerFilmListeners {
    public static void supprFilms(FrameBase frame, Film film){
        frame.filmsDAO.supprimerFilm(film);
    }
}
