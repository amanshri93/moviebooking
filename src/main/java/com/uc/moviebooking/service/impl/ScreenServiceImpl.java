package com.uc.moviebooking.service.impl;

import com.uc.moviebooking.exception.*;
import com.uc.moviebooking.models.Screen;
import com.uc.moviebooking.models.Show;
import com.uc.moviebooking.service.MovieService;
import com.uc.moviebooking.service.ScreenService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenServiceImpl implements ScreenService {
    private static Map<String, Screen> screens;
    private static Map<String, Show> shows;
    private static Map<Screen, List<Show>> screenToShowMapping;

    private MovieService movieService;

    static {
        screens = new HashMap<String, Screen>();
        shows = new HashMap<String, Show>();
        screenToShowMapping = new HashMap<Screen, List<Show>>();
    }

    public ScreenServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public void addScreen(Screen screen) throws ScreenAlreadyExist {
        if (screens.get(screen.getId()) == null) {
            screens.put(screen.getId(), screen);
        } else {
            throw new ScreenAlreadyExist();
        }
    }

    public void addShow(Show show) throws ShowAlreadyExist, ScreenNotFound, ScreenNotAvailable, MovieNotFound {
        if (shows.get(show.getId()) != null) {
            throw new ShowAlreadyExist();
        }

        validate(show);

        //synchronised on show
        if (screenAvailable(show.getScreen().getId(), show.getStartTime(), show.getEndTime())) {
            //TransactionBlock
            shows.put(show.getId(), show);

            if (screenToShowMapping.get(show.getScreen()) == null) {
                screenToShowMapping.put(show.getScreen(), new ArrayList<Show>());
            }
            screenToShowMapping.get(show.getScreen()).add(show);
        } else {
            throw new ScreenNotAvailable();
        }

    }

    private void validate(Show show) throws MovieNotFound {
        movieService.getMovie(show.getId());
    }

    public Screen getScreen(String id) throws ScreenNotFound {
        if (screens.get(id) != null) {
            return screens.get(id);
        } else {
            throw new ScreenNotFound();
        }
    }

    public Show getShow(String id) throws ShowNotFound {
        if (shows.get(id) != null) {
            return shows.get(id);
        } else {
            throw new ShowNotFound();
        }
    }


    private boolean screenAvailable(String id, final Long startTime, Long endTime) throws ScreenNotFound {
        if (screens.get(id) == null) {
            throw new ScreenNotFound();
        }
        Screen screen = screens.get(id);
        List<Show> shows = screenToShowMapping.get(screen);

        if (shows != null) {
            for (Show show : shows) {
                if ((startTime >= show.getStartTime() && startTime <= show.getEndTime()) || (endTime >= show.getStartTime() && endTime <= show.getEndTime())) {
                    return false;
                }

            }
        }
        return true;
    }
}
