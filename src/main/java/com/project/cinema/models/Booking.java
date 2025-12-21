package com.project.cinema.models;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {

    private static int bookingCounter = 1;

    private int bookingId;
    private Customer customer;
    private Movie movie;
    private ShowTime showTime;
    private List<Seat> reservedSeats;
    private LocalDateTime bookingTime;

    public Booking(Customer customer, Movie movie, ShowTime showTime, List<Seat> reservedSeats) {
        this.bookingId = bookingCounter++;
        this.customer = customer;
        this.movie = movie;
        this.showTime = showTime;
        this.reservedSeats = reservedSeats;
        this.bookingTime = LocalDateTime.now();

        for (Seat seat : reservedSeats) {
            seat.reserve();
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public double getTotalPrice() {
        return movie.getPrice() * reservedSeats.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n========= BOOKING SUMMARY =========\n");
        sb.append("Booking ID : ").append(bookingId).append("\n");
        sb.append("Customer   : ").append(customer.getName()).append("\n");
        sb.append("Movie      : ").append(movie.getTitle()).append("\n");
        sb.append("ShowTime   : ").append(showTime.getTime()).append("\n");
        sb.append("Seats      : ");

        for (Seat seat : reservedSeats) {
            sb.append(seat.getSeatNumber()).append(" ");
        }

        sb.append("\nDate       : ")
                .append(bookingTime).append("\n");
        sb.append("Total      : ")
                .append(getTotalPrice()).append(" TL\n");
        sb.append("==================================\n");

        return sb.toString();
    }
}
