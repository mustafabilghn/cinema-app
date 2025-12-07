package com.project.cinema.models;

public class Seat {
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

    public void reserve(){
        this.isReserved = true;
    }
}
