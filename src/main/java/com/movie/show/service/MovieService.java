package com.movie.show.service;


import java.util.List;


//import com.movie.show.entity.Movie;
//import com.movie.show.entity.Theatre;


public interface MovieService {
	//  List<Theatre> getTheatresInCity(String cityName);
	List<String> getTheatresInCity(String cityName);

  //  List<Theatre> getTheatresPlayingMovie(String movieName);
    List<String> getTheatresPlayingMovie(String movieName);

   // List<Movie> getMoviesPlayedInTheatre(String theatreName);
    List<String> getMoviesPlayedInTheatre(String theatreName);

   // List<Movie> getMoviesPlayedInCity(String cityName);
    List<String> getMoviesPlayedInCity(String cityName);
    
   // List<Movie> getMoviesAboveRating(double rating);
    List<String> getMoviesAboveRating(double rating);

    List<String> getShowTimes(String movieName, String theatreName);
}
