package com.homeworks.n_7.repo;

import com.homeworks.n_7.models.Genre;
import com.homeworks.n_7.models.Movie;
import com.homeworks.n_7.services.FileService;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MovieRepoImpl implements MovieRepo {
    private FileService fileService = new FileService();
    public String movie_file_path = "src/com/homeworks/n_7/data/Movies.txt";
    public String movie_info_path = "src/com/homeworks/n_7/data/Data_prop.txt";
    public String movie_genres_path = "src/com/homeworks/n_7/data/Movie_Genres.txt";
    public String genre_file_path = "src/com/homeworks/n_7/data/Genres.txt";

    @Override
    public Movie[] getAllMovies() {
        String[] movieLines = fileService.getLineArray(Paths.get(movie_file_path));
        Movie[] movies = new Movie[movieLines.length];

        for (int i = 0; i < movies.length; i++) {
            movies[i] = convert(movieLines[i]);
            setMovieGenres(movies[i]);
        }

        return movies;
    }

    @Override
    public void addMovie(Movie movie) throws IOException {
        movie.setId( Integer.parseInt(
                fileService.getParameter(Paths.get(movie_info_path), "movies_next_index")));

        String separation = getMovieElementSeparation();
        StringBuilder movieStr = new StringBuilder();
        movieStr.append(movie.getId());
        movieStr.append(separation);
        movieStr.append(movie.getName());
        movieStr.append(separation);
        movieStr.append(movie.getDescription());
        movieStr.append(separation);
        movieStr.append(movie.getYear());
        movieStr.append("\n");

        fileService.write(Paths.get(movie_file_path), movieStr.toString(), StandardOpenOption.APPEND);
        fileService.setParameter(Paths.get(movie_info_path), "movies_next_index", String.valueOf(movie.getId() + 1));

        //adding information about movie genres to file
        addMovieGenresToFile(movie);
    }

    @Override
    public void addMovieGenresToFile(Movie movie) throws IOException {
        String separation = getMovieGenresSeparation();
        StringBuilder movieStr = new StringBuilder();

        for (Genre genre : movie.getGenres()) {
            fileService.write(
                    Paths.get(movie_genres_path),
                    movie.getId() + separation + genre.getId() + "\n",
                    StandardOpenOption.APPEND);
        }

    }

    @Override
    public void setMovieGenres(Movie movie) {
        String[] lineArray = fileService.getLineArray(Paths.get(movie_genres_path));
        Genre[] genres = new Genre[lineArray.length];
        int genresCount = 0;

        for (String line : lineArray) {
            String[] split = line.split(",");
            if (split[0].equals( String.valueOf(movie.getId()) )){
                genres[genresCount] = new Genre(
                        Integer.parseInt(split[1]),
                        fileService.getParameter(Paths.get(genre_file_path), split[1]));

                ++genresCount;
            }
        }
        Genre[] movieGenres = new Genre[genresCount];
        for (int i = 0; i < genresCount; i++) {
            movieGenres[i] = genres[i];
        }
        movie.setGenres(movieGenres);
    }

    private Movie convert(String info) {
        String movie_separation = getMovieElementSeparation();

        String[] split = info.split(movie_separation);
        return new Movie(
                Integer.parseInt(split[0]),
                split[1],
                split[2],
                Integer.parseInt(split[3])
        );
    }

    private String getMovieElementSeparation() {
        return fileService.getParameter(Paths.get(movie_info_path), "movie_element_separation");
    }

    private String getMovieGenresSeparation(){
        return fileService.getParameter(Paths.get(movie_info_path), "movie_genres_separation");
    }
}
