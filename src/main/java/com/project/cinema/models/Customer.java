package com.project.cinema.models;

public class Customer {
    private static int counter = 1;

    private int customerId;
    private String name;

    public Customer(String name) {
        this.customerId = counter++;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
