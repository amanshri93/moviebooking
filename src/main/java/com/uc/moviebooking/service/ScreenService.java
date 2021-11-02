package com.uc.moviebooking.service;

import com.uc.moviebooking.exception.*;
import com.uc.moviebooking.models.Screen;
import com.uc.moviebooking.models.Show;

public interface ScreenService {
    public void addScreen(Screen screen) throws ScreenAlreadyExist;

    public void addShow(Show show) throws ShowAlreadyExist, ScreenNotFound, ScreenNotAvailable, MovieNotFound;

    public Screen getScreen(String id) throws ScreenNotFound;

    public Show getShow(String id) throws ShowNotFound;
}
