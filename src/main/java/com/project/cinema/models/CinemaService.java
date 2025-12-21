package com.project.cinema.models;

import java.util.ArrayList;
import java.util.List;

public class CinemaService {

    private List<Booking> bookings;

    public CinemaService() {
        this.bookings = new ArrayList<>();
    }

    public void reserveSeat(Customer customer, ShowTime showTime, int seatNumber) {
        List<Seat> seats = showTime.getSeats();

        if (seatNumber < 1 || seatNumber > seats.size()) {
            System.out.println("[WARN] Invalid seat number: " + seatNumber);
            return;
        }

        Seat seat = seats.get(seatNumber - 1);

        if (seat.isReserved()) {
            System.out.println("[WARN] Seat " + seatNumber + " is already reserved.");
            return;
        }

        List<Seat> reservedSeats = new ArrayList<>();
        reservedSeats.add(seat);

        Booking booking = new Booking(customer, showTime.getMovie(), showTime, reservedSeats);
        bookings.add(booking);

        System.out.println("[INFO] Booking successful! Booking ID: " + booking.getBookingId());
    }

    public void reserveSeats(Customer customer, ShowTime showTime, List<Integer> seatNumbers) {
        List<Seat> reservedSeats = new ArrayList<>();

        for(int seatNumber : seatNumbers){
            if(seatNumber < 1 || seatNumber > showTime.getSeats().size()){
                System.out.println("[WARN] Invalid seat number: " + seatNumber);
                continue;
            }

            Seat seat = showTime.getSeats().get(seatNumber - 1);

            if(seat.isReserved()){
                System.out.println("[WARN] Seat " + seatNumber + " is already reserved.");
                continue;
            }

            reservedSeats.add(seat);
        }

        if(reservedSeats.isEmpty()){
            System.out.println("[WARN] No seats reserved. Booking not created.");
            return;
        }

        Booking booking = new Booking(
            customer,
            showTime.getMovie(),
            showTime,
            reservedSeats
        );

        bookings.add(booking);

        System.out.println("[INFO] Booking successful! Booking ID: " + booking.getBookingId());
    }

    public void printAvailableSeats(ShowTime showTime) {
        List<Seat> availableSeats = showTime.getAvailableSeats();

        System.out.println(
                "[INFO] Available seats for " + showTime.getMovie().getTitle() + " at " + showTime.getTime() + ":");

        for (Seat seat : availableSeats) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        
        System.out.println();
    }

    public void printBookingHistory() {
        if (bookings.isEmpty()) {
            System.out.println("[INFO] No bookings found.");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println(booking);
            System.out.println("----------------------------");
        }
    }
}
