package C.Listeners.PageAdmin;

import M.JAVA_MODEL.Global_CLASS.Film;
import V.FrameBase;

import java.util.List;

public class RecuperationFilmsListeners {
    public static List<Film> recupFilms(FrameBase frame){
        List<Film> films = frame.filmsDAO.recupererTousLesFilms();
        return films;
    }
}
