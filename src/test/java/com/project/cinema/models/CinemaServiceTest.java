package com.project.cinema.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CinemaServiceTest {

    @Test
    void reserveSeat_shouldReserveSeatAndCreateBooking() {
        CinemaService cinemaService = new CinemaService();
        Customer customer = new Customer("John Doe");
        Movie movie = new TwoDMovie("Inception", 148, "Sci-Fi", 8.8);
        ShowTime showTime = new ShowTime(movie, "18:00", 10);

        cinemaService.reserveSeat(customer, showTime, 3);

        Seat seat = showTime.getSeats().get(2);
        assertTrue(seat.isReserved(), "Seat should be marked as reserved.");

        assertEquals(1, cinemaService.getBookings().size(), "There should be one booking created.");
    }

    @Test
    void reserveSeat_shouldNotCreateBookingIfSeatAlreadyReserved() {
        CinemaService cinemaService = new CinemaService();
        Customer customer = new Customer("John Doe");
        Movie movie = new TwoDMovie("Inception", 148, "Sci-Fi", 8.8);
        ShowTime showTime = new ShowTime(movie, "18:00", 10);

        cinemaService.reserveSeat(customer, showTime, 3);
        cinemaService.reserveSeat(customer, showTime, 3);

        assertEquals(1, cinemaService.getBookings().size(), "There should be only one booking created.");
    }

    @Test
    void reserveSeat_shouldNotCreateBookingForInvalidSeatNumber(){
        CinemaService cinemaService = new CinemaService();
        Customer customer = new Customer("John Doe");
        Movie movie = new TwoDMovie("Inception", 148, "Sci-Fi", 8.8);
        ShowTime showTime = new ShowTime(movie, "18:00", 10);

        cinemaService.reserveSeat(customer, showTime, 0);

        assertEquals(0, cinemaService.getBookings().size(),
                "There should be no bookings created for invalid seat number.");
    }
}
