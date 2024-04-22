package C.Listeners.PageAdmin;

import V.FrameBase;

public class CompterFilmListeners {
    public static int compterFilms(FrameBase frame){
        int films = frame.filmsDAO.compterTousLesFilms();
        return films;
    }
}
