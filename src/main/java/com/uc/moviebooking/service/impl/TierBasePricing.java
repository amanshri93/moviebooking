package com.uc.moviebooking.service.impl;

import com.uc.moviebooking.models.Booking;
import com.uc.moviebooking.models.Seat;
import com.uc.moviebooking.models.enums.SeatType;
import com.uc.moviebooking.service.PricingStrategy;

import java.util.Map;

public class TierBasePricing implements PricingStrategy {
    private Map<SeatType, Integer> pricingMap;

    public TierBasePricing(Map<SeatType, Integer> pricingMap) {
        this.pricingMap = pricingMap;
    }

    public int getPrice(Booking booking) {
        int price = 0;
        for (Seat seat: booking.getSeats()) {
            price = price + seat.getCount() * pricingMap.get(seat.getSeatType());
        }
        return price;
    }
}
