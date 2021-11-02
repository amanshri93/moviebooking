package com.uc.moviebooking.service.impl;

import com.uc.moviebooking.exception.MovieAlreadyExist;
import com.uc.moviebooking.exception.MovieNotFound;
import com.uc.moviebooking.models.Movie;
import com.uc.moviebooking.service.MovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieServiceImpl implements MovieService {
    private static Map<String, Movie> movies;

    static {
        movies = new HashMap<String, Movie>();
    }

    public void addMovie(Movie movie) throws MovieAlreadyExist {
        if (movies.get(movie.getId()) == null) {
            movies.put(movie.getId(), movie);
        } else {
            throw new MovieAlreadyExist();
        }

    }

    public Movie getMovie(String id) throws MovieNotFound {
        if (movies.get(id) != null) {
            return movies.get(id);
        } else {
            throw new MovieNotFound();
        }
    }

    public List<Movie> listMovies() {
        return (List<Movie>) movies.values();
    }
}
