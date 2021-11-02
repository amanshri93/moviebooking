package com.uc.moviebooking.models;

import com.uc.moviebooking.models.enums.SeatType;

public class Seat {
    private int count;
    private SeatType seatType;

    public Seat(int count, SeatType seatType) {
        this.count = count;
        this.seatType = seatType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "count=" + count +
                ", seatType=" + seatType +
                '}';
    }
}
