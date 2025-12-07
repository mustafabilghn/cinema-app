package com.project.cinema.models;

import java.util.ArrayList;
import java.util.List;

public class ShowTime {
    private Movie movie;
    private String time;
    private List<Seat> seats;

    public ShowTime(Movie movie, String time, int totalSeats) {
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();

        for(int i = 1; i <= totalSeats; i++){
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie(){
        return movie;
    }

    public String getTime(){
        return time;
    }

    public List<Seat> getSeats(){
        return seats;
    }

    public List<Seat> getAvailableSeats(){
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat seat : seats){
            if(!seat.isReserved()){
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }
}
