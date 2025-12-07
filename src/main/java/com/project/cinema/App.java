package com.project.cinema;

import com.project.cinema.models.TwoDMovie;
import com.project.cinema.models.Movie;
import com.project.cinema.models.ShowTime;
import com.project.cinema.models.ThreeDMovie;

public class App 
{
    public static void main( String[] args )
    {
        Movie m1 = new TwoDMovie("Interstellar", 250, "fiction", 8.5);
        Movie m2 = new ThreeDMovie("Avatar", 162, "Fantasy", 7.8);

        System.out.println("Movie: " + m1.getTitle() + ", Price: " + m1.getPrice());
        System.out.println("Movie: " + m2.getTitle() + ", Price: " + m2.getPrice());

        ShowTime show1 = new ShowTime(m1, "18:00", 10);
        ShowTime show2 = new ShowTime(m2, "20:00", 10);

        System.out.println("ShowTime for " + show1.getMovie().getTitle() + " at " + show1.getTime());
        System.out.println("Available Seats: " + show1.getAvailableSeats().size());
        show1.getSeats().get(0).reserve();
        System.out.println("Available Seats:" + show1.getAvailableSeats().size());

        System.out.println("ShowTime for " + show2.getMovie().getTitle() + " at " + show2.getTime());
        System.out.println("Available Seats: " + show2.getAvailableSeats().size());
    }
}
