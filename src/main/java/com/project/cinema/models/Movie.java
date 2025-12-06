package com.project.cinema.models;

public abstract class Movie {
    private String title;
    private int duration;
    private String genre;
    private double rating;

    public Movie(String title, int duration, String genre, double rating) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ", " + duration + " min, Rating: " + rating + ")";
    }

    public abstract double getPrice();
}
