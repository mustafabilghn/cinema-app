package com.project.cinema.models;

public class TwoDMovie extends Movie {
    public TwoDMovie(String title, int duration, String genre, double rating) {
        super(title, duration, genre, rating);
    }

    @Override
    public double getPrice(){
        return 120.0;
    }
}
