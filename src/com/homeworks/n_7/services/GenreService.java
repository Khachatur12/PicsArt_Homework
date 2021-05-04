package com.homeworks.n_7.services;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.repo.GenreRepo;
import com.homeworks.n_7.repo.GenreRepoImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class GenreService {
    private FileService fileService = new FileService();
    private GenreRepo genreRepo = new GenreRepoImpl();
    private String genres_file_path = "src/com/homeworks/n_7/data/Genres.txt";
    private String data_prop_path = "src/com/homeworks/n_7/data/Data_prop.txt";


    public void addNewGenre(Genre genre) throws IOException {
        fileService.write(
                Paths.get(genres_file_path),
                genre.getId() + "=" + genre.getName() + "\n",
                StandardOpenOption.APPEND);

        fileService.setParameter(
                Paths.get(data_prop_path),
                "genre_next_index",
                String.valueOf(genre.getId() + 1));
    }

    public void inputNewGenre() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Genre genre = new Genre();
        Genre[] allGenres = genreRepo.getAllGenres();

        System.out.print("input genre name: ");
        genre.setName(scanner.nextLine());

        //Check
        for (Genre g : allGenres)
            if (g.getName().equalsIgnoreCase(genre.getName()))
                throw new IllegalArgumentException("This genre already exists");

        genre.setId(genreRepo.getGenreNextIndex());
        addNewGenre(genre);
    }

    public Genre getGenreByName(String name) {
        return genreRepo.getGenreByMame(name);
    }
}
