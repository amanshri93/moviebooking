package com.uc.moviebooking.models;

public class Screen {
    private String id;
    private String name;
    private int seats;

    public Screen(String id, String name, int seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
