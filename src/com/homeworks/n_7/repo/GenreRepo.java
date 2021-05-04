package com.homeworks.n_7.repo;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;

public interface GenreRepo {
    Genre[] getAllGenres();

    int getGenreNextIndex();

    Genre getGenreByMame(String name);
}
