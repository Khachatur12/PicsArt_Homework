package com.homeworks.n_7.repo;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public interface MovieRepo {
    Movie[] getAllMovies();

    void addMovie(Movie movie) throws IOException;

    void addMovieGenresToFile(Movie movie) throws IOException;

    void setMovieGenres(Movie movie);
}
