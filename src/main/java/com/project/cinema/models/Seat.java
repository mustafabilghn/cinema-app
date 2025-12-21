package com.project.cinema.models;

public class Seat implements Bookable {
    private int seatNumber;
    private boolean isReserved;

    public Seat(int seatNumber){
        this.seatNumber = seatNumber;
        this.isReserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public void reserve(){
        this.isReserved = true;
        System.out.println("Seat " + seatNumber + " has been reserved.");
    }

    @Override
    public String toString(){
        return "Seat " + seatNumber;
    }
}
