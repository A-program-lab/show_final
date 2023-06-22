package com.movie.show.controller;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.show.entity.Movie;
import com.movie.show.entity.Theatre;
import com.movie.show.service.MovieService;


@RestController
public class MovieController {
    private MovieService movieService;

  @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @GetMapping("/theatres")
//    public List<Theatre> getTheatresInCity(@RequestParam("city") String cityName) {
//        return movieService.getTheatresInCity(cityName);
//    }
  @GetMapping("/theatres/{city}")
//  public List<Theatre> getTheatresInCity(@PathVariable("city") String cityName) {
  public List<String> getTheatresInCity(@PathVariable("city") String cityName) {
      return movieService.getTheatresInCity(cityName);
  }

  
//  @GetMapping("/theatres/movies")
//  public List<Theatre> getTheatresPlayingMovie(@RequestParam("movie") String movieName) {
//      return movieService.getTheatresPlayingMovie(movieName);
 // }
  
  @GetMapping("/theatres/movies/{movie}")
 // public List<Theatre> getTheatresPlayingMovie(@PathVariable("movie") String movieName) {
	  public List<String> getTheatresPlayingMovie(@PathVariable("movie") String movieName) {
      return movieService.getTheatresPlayingMovie(movieName);
  }


//    @GetMapping("/movies/theatres")
//    public List<Movie> getMoviesPlayedInTheatre(@RequestParam("theatre") String theatreName) {
//        return movieService.getMoviesPlayedInTheatre(theatreName);
//    }
  
  @GetMapping("/movies/theatres/{theatre}")
//  public List<Movie> getMoviesPlayedInTheatre(@PathVariable("theatre") String theatreName) {
  public List<String> getMoviesPlayedInTheatre(@PathVariable("theatre") String theatreName) {
      return movieService.getMoviesPlayedInTheatre(theatreName);
  }

//    @GetMapping("/movies/city")
//    public List<Movie> getMoviesPlayedInCity(@RequestParam("city") String cityName) {
//        return movieService.getMoviesPlayedInCity(cityName);
//    }
    
    @GetMapping("/movies/city/{city}")
//  public List<Movie> getMoviesPlayedInCity(@PathVariable("city") String cityName) {
    public List<String> getMoviesPlayedInCity(@PathVariable("city") String cityName) {
        return movieService.getMoviesPlayedInCity(cityName);
    }

//    @GetMapping("/movies/rating")
//    public List<Movie> getMoviesAboveRating(@RequestParam("rating") double rating) {
//        return movieService.getMoviesAboveRating(rating);
//    }
    
    @GetMapping("/movies/rating/{rating}")
    //public List<Movie> getMoviesAboveRating(@PathVariable("rating") double rating) {
    public List<String> getMoviesAboveRating(@PathVariable("rating") double rating) {
        return movieService.getMoviesAboveRating(rating);
    }

//    @GetMapping("/movies/showtimes")
//    public List<String> getShowTimes(@RequestParam("movie") String movieName,
//                                     @RequestParam("theatre") String theatreName) {
//        return movieService.getShowTimes(movieName, theatreName);
//    }
    
    @GetMapping("/movies/showtimes/{movie}/{theatre}")
    public List<String> getShowTimes(@PathVariable("movie") String movieName,
                                     @PathVariable("theatre") String theatreName) {
        return movieService.getShowTimes(movieName, theatreName);
    }
}
