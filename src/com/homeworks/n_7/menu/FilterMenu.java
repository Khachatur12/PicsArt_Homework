package com.homeworks.n_7.menu;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;
import com.homeworks.n_7.services.GenreService;
import com.homeworks.n_7.services.MovieService;

import java.util.Scanner;

public class FilterMenu extends Menu {
    private MovieService movieService;
    private GenreService genreService;
    private Movie[] movies;

    public FilterMenu(Movie[] movies, MovieService movieService, GenreService genreService) {
        super("\n0: back\n1: Filter by name\n2: Filter by genre\n3: Filter by year\n4: Filter by between year\n\nCommand number: ");
        this.movies = movies;
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @Override
    protected void repeat() {
        while (isActive) {
            System.out.println("_______________________________________________________________________");
            System.out.println();
            for (Movie movie : movies) {
                System.out.println(movie);
            }

            System.out.print(message);
            String comm = scanner.next();

            switch (comm) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    System.out.print("Name to filter: ");
                    Scanner s = new Scanner(System.in);
                    String name = s.nextLine();
                    movies = movieService.filterByName(movies, name);
                    break;
                case "2":
                    System.out.print("input genre: ");
                    Scanner s2 = new Scanner(System.in);
                    Genre genreByName = genreService.getGenreByName(s2.nextLine());
                    if (genreByName != null)
                        movies = movieService.filterByGenre(movies, genreByName);
                    else
                        System.out.println("we do not have such a genre");
                    break;
                case "3":
                    System.out.print("Year to filter: ");
                    int year = scanner.nextInt();
                    movies = movieService.filterByYear(movies, year, year);
                    break;
                case "4":
                    System.out.print("Min year: ");
                    int minYear = scanner.nextInt();
                    System.out.print("Max year: ");
                    int maxYear = scanner.nextInt();
                    movies = movieService.filterByYear(movies, minYear, maxYear);
                    break;
                default:
                    System.out.println("Invalid command: " + comm);
            }
        }
    }
}
