package com.movie.show.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.movie.show.entity.City;
import com.movie.show.entity.Movie;
import com.movie.show.entity.Theatre;

import jakarta.annotation.PostConstruct;



@Service
public class MovieServiceImpl implements MovieService {
    private List<City> cities;

    @Value("${movie.file.path}")
    private String moviefilePath;

    public MovieServiceImpl() {
        cities = new ArrayList<>();
    }
    @PostConstruct
 private void loadMoviesFromCSV() {

        try (BufferedReader reader = new BufferedReader(new FileReader(moviefilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    String cityName = data[0].trim();
                    String theatreName = data[1].trim();
                    String movieName = data[2].trim();
                    String actors = data[3].trim();
                    double movieRating = Double.parseDouble(data[4].trim());
                    String movieStarting = data[5].trim();
                    String movieEnd = data[6].trim();

                    City city = findOrCreateCity(cityName);
                    city.getTheatres().add(new Theatre(cityName, theatreName, movieName, actors, movieRating, movieStarting, movieEnd));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    private City findOrCreateCity(String cityName) {
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        City newCity = new City(cityName);
        cities.add(newCity);
        return newCity;
    }

//    @Override
//  public List<Theatre> getTheatresInCity(String cityName) {
//      List<Theatre> theatres = new ArrayList<>();
//      for (City city : cities) {
//          if (city.getCityName().equalsIgnoreCase(cityName)) {
//         theatres.addAll(city.getTheatres());
//         // 	theatres.addAll(theatres);
//          		
//              break;
//          }
//      }
//      return theatres;
//  }

    @Override
    public List<String> getTheatresInCity(String cityName) {
        List<String> theatreNames = new ArrayList<>();
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                for (Theatre theatre : city.getTheatres()) {
                    theatreNames.add(theatre.getTheatreName());
                }
                break;
            }
        }
        return theatreNames;
    }
    

    
    public List<String> getTheatresPlayingMovie(String movieName) {
        List<String> theatreNames = new ArrayList<>();
        for (City city : cities) {
            for (Theatre theatre : city.getTheatres()) {
                if (theatre.getMovieName().equalsIgnoreCase(movieName)) {
                    theatreNames.add(theatre.getTheatreName());
                }
            }
        }
        return theatreNames;
    }
    
//    @Override
//    public List<Movie> getMoviesPlayedInTheatre(String theatreName) {
//        List<Movie> movies = new ArrayList<>();
//        for (City city : cities) {
//            for (Theatre theatre : city.getTheatres()) {
//                if (theatre.getTheatreName().equalsIgnoreCase(theatreName)) {
//                    movies.add(new Movie(theatre.getMovieName()));
//                }
//            }
//        }
//        return movies;
//    }
    
    
    @Override
    public List<String> getMoviesPlayedInTheatre(String theatreName) {
        List<String> movieNames = new ArrayList<>();
        for (City city : cities) {
            for (Theatre theatre : city.getTheatres()) {
                if (theatre.getTheatreName().equalsIgnoreCase(theatreName)) {
                    movieNames.add(theatre.getMovieName());
                }
            }
        }
        return movieNames;
    }

//    @Override
//    public List<Movie> getMoviesPlayedInCity(String cityName) {
//        List<Movie> movies = new ArrayList<>();
//        for (City city : cities) {
//            if (city.getCityName().equalsIgnoreCase(cityName)) {
//                for (Theatre theatre : city.getTheatres()) {
//                 movies.add(new Movie(theatre.getMovieName()));
//                //	 Movie movie = new Movie(city.getCityName());
////                    theatre.setActors(theatre.getActors());// Set the actors property
////                    theatre.setMovieRating(theatre.getMovieRating());
////                    theatre.setMovieStarting(theatre.getMovieStarting());
////                    theatre.setMovieEnd(theatre.getMovieEnd());
// //                  movies.add(movie);
//                }
//                break;
//            }
//        }
//        return movies;
//    }
    
    @Override
    public List<String> getMoviesPlayedInCity(String cityName) {
        List<String> movieNames = new ArrayList<>();
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName)) {
                for (Theatre theatre : city.getTheatres()) {
                    movieNames.add(theatre.getMovieName());
                }
                break;
            }
        }
        return movieNames;
    }

//    @Override
//    public List<Movie> getMoviesAboveRating(double rating) {
//        List<Movie> movies = new ArrayList<>();
//        for (City city : cities) {
//            for (Theatre theatre : city.getTheatres()) {
//                if (theatre.getMovieRating() > rating) {
//                    movies.add(new Movie(theatre.getMovieName()));
//                }
//            }
//        }
//        System.out.println();
//        return movies;
//    }
    
//    @Override
//    public List<Movie> getMoviesAboveRating(double rating) {
//        List<Movie> movies = new ArrayList<>();
//        for (City city : cities) {
//            for (Theatre theatre : city.getTheatres()) {
//                if (theatre.getMovieRating() > rating) {
//                    Movie movie = new Movie(theatre.getMovieName());
//                    movie.setActors(theatre.getActors());// Set the actors property
//                    movie.setMovieRating(theatre.getMovieRating());
//                    movie.setMovieStarting(theatre.getMovieStarting());
//                    movie.setMovieEnd(theatre.getMovieEnd());
//                    movies.add(movie);
//                }
//            }
//        }
//      
//        return movies;
//    }
    
    @Override
    public List<String> getMoviesAboveRating(double rating) {
        List<String> movieNames = new ArrayList<>();
        for (City city : cities) {
            for (Theatre theatre : city.getTheatres()) {
                if (theatre.getMovieRating() > rating) {
                    movieNames.add(theatre.getMovieName());
                }
            }
        }
        return movieNames;
    }
   

    @Override
    public List<String> getShowTimes(String movieName, String theatreName) {
        List<String> showTimes = new ArrayList<>();
        for (City city : cities) {
            for (Theatre theatre : city.getTheatres()) {
                if (theatre.getMovieName().equalsIgnoreCase(movieName) && theatre.getTheatreName().equalsIgnoreCase(theatreName)) {
                    showTimes.add(theatre.getMovieStarting() + " - " + theatre.getMovieEnd());
                }
            }
        }
        return showTimes;
    }
}
