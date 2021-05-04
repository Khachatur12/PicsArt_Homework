package com.homeworks.n_7.services;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;
import com.homeworks.n_7.repo.GenreRepo;
import com.homeworks.n_7.repo.GenreRepoImpl;
import com.homeworks.n_7.repo.MovieRepo;
import com.homeworks.n_7.repo.MovieRepoImpl;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MovieService {
    private MovieRepo movieRepo = new MovieRepoImpl();
    private GenreRepo genreRepo = new GenreRepoImpl();

    public MovieService() { }

    public Movie[] getAllMovies() {
        return movieRepo.getAllMovies();
    }

    public void addNewMovie(Movie movie) throws IOException {
        movieRepo.addMovie(movie);
    }

    public Movie inputMovie() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Movie movie = new Movie();
        System.out.print("input name: ");
        movie.setName(scanner.nextLine());

        System.out.print("input description: ");
        movie.setDescription(scanner.nextLine());

        System.out.print("input year: ");
        movie.setYear(scanner.nextInt());

        //set genres
        movie.setGenres(inputGenres());
        return movie;
    }

    public Genre[] inputGenres(){
        //set genres
        Scanner scanner = new Scanner(System.in);
        StringBuilder genreMessage = new StringBuilder();
        Genre[] allGenres = genreRepo.getAllGenres();
        for (Genre genre : allGenres) {
            genreMessage.append(genre.getId() + ". " + genre.getName() + "\n");
        }

        System.out.print("count of genres: ");
        int genreCount = scanner.nextInt();

        Genre[] selected = new Genre[genreCount];
        System.out.println(genreMessage);
        int index = 0;
        while (index < genreCount) {
            System.out.print("enter genre number with index " + index + ": ");
            int comm = scanner.nextInt();
            for (int j = 0; j < allGenres.length; j++) {
                if (allGenres[j].getId() == comm) {
                    selected[index] = allGenres[j];
                    ++index;
                    break;
                }
            }
        }

        return selected;
    }

    public Movie[] filterByName(Movie[] movies, String name) {
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(name);
        String[] tokens = new String[tokenizer.countTokens()];

        for (int i = 0; i < tokens.length; i++)
            tokens[i] = tokenizer.nextToken();

        for (int i = 0; i < movies.length; i++) {
            for (int j = 0; j < tokens.length; j++) {
                String s = movies[i].getName().toLowerCase();
                String t = tokens[j].toLowerCase();
                if (s.contains(t)) {
                    movies[count++] = movies[i];
                    break;
                }
            }
        }

        Movie[] newMovies = new Movie[count];
        for (int i = 0; i < count; i++) {
            newMovies[i] = movies[i];
        }

        return newMovies;
    }

    public Movie[] filterByYear(Movie[] movies, int minYear, int maxYear) {
        int count = 0;
        for (int i = 0; i < movies.length; i++) {
            int moveYear = movies[i].getYear();
            if (moveYear >= minYear && moveYear <= maxYear)
                movies[count++] = movies[i];
        }

        Movie[] newMovies = new Movie[count];
        for (int i = 0; i < count; i++) {
            newMovies[i] = movies[i];
        }

        return newMovies;
    }

    public Movie[] filterByGenre(Movie[] movies, Genre genreByName) {
        int count = 0;

        for (int i = 0; i < movies.length; i++) {
            Genre[] genres = movies[i].getGenres();
            for (int j = 0; j < genres.length; j++) {
                if (genres[j].getName().equalsIgnoreCase(genreByName.getName())) {
                    movies[count++] = movies[i];
                    break;
                }
            }
        }

        Movie[] newMovies = new Movie[count];
        for (int i = 0; i < count; i++) {
            newMovies[i] = movies[i];
        }

        return newMovies;
    }
}
