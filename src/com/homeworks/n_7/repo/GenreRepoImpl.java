package com.homeworks.n_7.repo;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;
import com.homeworks.n_7.services.FileService;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GenreRepoImpl implements GenreRepo {
    private FileService fileService = new FileService();
    private String genres_file_path = "src/com/homeworks/n_7/data/Genres.txt";
    private String data_prop_path = "src/com/homeworks/n_7/data/Data_prop.txt";

    @Override
    public Genre[] getAllGenres(){
        String[] lineArray = fileService.getLineArray(Paths.get(genres_file_path));
        Genre[] genres = new Genre[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            String[] split = lineArray[i].split("=");
            genres[i] = new Genre(
                    Integer.parseInt(split[0]),
                    split[1]);
        }

        return genres;
    }

    @Override
    public int getGenreNextIndex() {
        return Integer.parseInt(
                fileService.getParameter(Paths.get(data_prop_path), "genre_next_index"));
    }

    @Override
    public Genre getGenreByMame(String name) {
        Genre[] allGenres = getAllGenres();
        for (Genre genre : allGenres) {
            if (genre.getName().toLowerCase().equals(name.toLowerCase()))
                return genre;
        }

        return null;
    }

}
