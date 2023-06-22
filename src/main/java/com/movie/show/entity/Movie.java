package com.movie.show.entity;

import java.util.List;


public class Movie {
    private String movieName;
    private String actors;
    private double movieRating;
    private String movieStarting;
    private String movieEnd;

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName, String actors, double movieRating, String movieStarting, String movieEnd) {
        this.movieName = movieName;
        this.actors = actors;
        this.movieRating = movieRating;
        this.movieStarting = movieStarting;
        this.movieEnd = movieEnd;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieStarting() {
        return movieStarting;
    }

    public void setMovieStarting(String movieStarting) {
        this.movieStarting = movieStarting;
    }

    public String getMovieEnd() {
        return movieEnd;
    }

    public void setMovieEnd(String movieEnd) {
        this.movieEnd = movieEnd;
    }
}
