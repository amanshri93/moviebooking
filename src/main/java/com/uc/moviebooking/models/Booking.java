package com.uc.moviebooking.models;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<Seat> seats;
    private int price;

    public Booking(String id, User user, Show show, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", show=" + show +
                ", seats=" + seats +
                ", price=" + price +
                '}';
    }
}
