package com.project.cinema;

import com.project.cinema.models.TwoDMovie;
import com.project.cinema.models.Movie;
import com.project.cinema.models.ThreeDMovie;

public class App 
{
    public static void main( String[] args )
    {
        Movie m1 = new TwoDMovie("Interstellar", 250, "fiction", 8.5);
        Movie m2 = new ThreeDMovie("Avatar", 162, "Fantasy", 7.8);

        System.out.println("Movie: " + m1.getTitle() + ", Price: " + m1.getPrice());
        System.out.println("Movie: " + m2.getTitle() + ", Price: " + m2.getPrice());
    }
}
