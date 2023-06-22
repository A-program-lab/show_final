package com.movie.show.entity;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String cityName;
    private List<Theatre> theatres;

    public City(String cityName) {
        this.cityName = cityName;
        this.theatres = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }
}
