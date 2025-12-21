package com.project.cinema;

import com.project.cinema.models.TwoDMovie;

import java.util.Arrays;

import com.project.cinema.models.CinemaService;
import com.project.cinema.models.Customer;
import com.project.cinema.models.Movie;
import com.project.cinema.models.ShowTime;

public class App 
{
    public static void main( String[] args )
    {
        CinemaService cinemaService = new CinemaService();
        Customer customer = new Customer("Mustafa");
        Movie movie = new TwoDMovie("Inception", 148, "Sci-Fi", 8.8);
        ShowTime showTime = new ShowTime(movie,"18:00", 10);

        cinemaService.printAvailableSeats(showTime);
        cinemaService.reserveSeats(customer, showTime, Arrays.asList(3, 5, 7));   
        cinemaService.printAvailableSeats(showTime);
        cinemaService.printBookingHistory();
    }
}
