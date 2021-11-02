package com.uc.moviebooking.service;

import com.uc.moviebooking.models.Booking;

public interface PricingStrategy {
    public int getPrice(Booking booking);

}
