package com.project.cinema;

import com.project.cinema.models.TwoDMovie;
import com.project.cinema.models.Movie;

public class App 
{
    public static void main( String[] args )
    {
        Movie movie = new TwoDMovie("Interstellar", 250, "fiction", 8.5);
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Price: " + movie.getPrice());
    }
}
