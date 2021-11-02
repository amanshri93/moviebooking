package com.uc.moviebooking.service;

import com.uc.moviebooking.exception.MovieAlreadyExist;
import com.uc.moviebooking.exception.MovieNotFound;
import com.uc.moviebooking.models.Movie;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie) throws MovieAlreadyExist;

    public Movie getMovie(String id) throws MovieNotFound;

    public List<Movie> listMovies();

}
