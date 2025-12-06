package com.project.cinema.models;

public class ThreeDMovie extends Movie{
    public ThreeDMovie(String title, int duration, String genre, double rating) {
        super(title, duration, genre, rating);
    }

    @Override
    public double getPrice(){
        return 220.0;
    }
}
