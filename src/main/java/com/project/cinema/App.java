package com.project.cinema;

import com.project.cinema.models.TwoDMovie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.cinema.models.CinemaService;
import com.project.cinema.models.Customer;
import com.project.cinema.models.Movie;
import com.project.cinema.models.ShowTime;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CinemaService cinemaService = new CinemaService();

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);

        Movie movie = new TwoDMovie("Inception", 148, "Sci-Fi", 8.8);
        ShowTime showTime = new ShowTime(movie, "18:00", 50);

        boolean running = true;

        while (running) {
            System.out.println("\n===== CINEMA MENU =====");
            System.out.println("1. View Movie Details");
            System.out.println("2. View ShowTime Details");
            System.out.println("3. View Available Seats");
            System.out.println("4. Reserve Seat(s)");
            System.out.println("5. View Booking History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Movie: " + movie.getTitle());
                    break;

                case 2:
                    System.out.println("ShowTime:" + showTime.getTime());
                    break;

                case 3:
                    cinemaService.printAvailableSeats(showTime);
                    break;

                case 4:
                    scanner.nextLine();

                    System.out.print("Enter seat numbers to reserve (comma separated): ");
                    String input = scanner.nextLine();

                    String[] parts = input.split(",");
                    List<Integer> seatNumbers = new ArrayList<>();

                    for (String part : parts) {
                        seatNumbers.add(Integer.parseInt(part.trim()));
                    }

                    cinemaService.reserveSeats(customer, showTime, seatNumbers);
                    break;

                case 5:
                    cinemaService.printBookingHistory();
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
