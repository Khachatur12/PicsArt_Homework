package com.homeworks.n_7.models;

import java.util.Arrays;

public class Movie {
    private int id = -1;
    private String name = "";
    private String description = "";
    private int year = 0;
    private Genre[] genres = new Genre[0];
    private Actors[] actors = new Actors[0];

    public Movie() {
    }

    public Movie(int id, String name, String description, int year) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
    }

    public Movie(int id, String name, String description, int year, Genre[] genres) {
        this(id, name, description, year);
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", genres=" + Arrays.toString(genres) +
                ", year=" + year +
                ", description=" + description;
    }
}
