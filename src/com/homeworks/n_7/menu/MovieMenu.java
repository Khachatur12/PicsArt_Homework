package com.homeworks.n_7.menu;

import com.homeworks.n_7.models.Movie;
import com.homeworks.n_7.repo.GenreRepo;
import com.homeworks.n_7.repo.GenreRepoImpl;
import com.homeworks.n_7.services.GenreService;
import com.homeworks.n_7.services.MovieService;

import java.io.IOException;

public class MovieMenu extends Menu {
    private MovieService movieService = new MovieService();
    private GenreService genreService = new GenreService();

    public MovieMenu() {
        super("\n0: exit\n1: Get all Movies\n2: Add new movie\n3: Add new genre\n4: Filter\n\nCommand number: ");
    }

    @Override
    public void repeat() {
        while (isActive) {
            System.out.println("_______________________________________________________________________");
            System.out.print(message);
            String comm = scanner.next();


            switch (comm) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    Movie[] allMovies = movieService.getAllMovies();
                    for (Movie movie : allMovies) {
                        System.out.println(movie);
                    }
                    break;
                case "2":
                    try {
                        movieService.addNewMovie(movieService.inputMovie());
                    } catch (Exception e) {
                        System.out.println("Something went wrong(");
                    }
                    break;
                case "3":
                    try {
                        genreService.inputNewGenre();
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Something went wrong(");
                    }
                    break;
                case "4":
                    Menu subMenu = new FilterMenu(movieService.getAllMovies(), movieService, genreService);
                    subMenu.start();
                    break;
                default:
                    System.out.println("Invalid command: " + comm);
            }
        }
    }
}
