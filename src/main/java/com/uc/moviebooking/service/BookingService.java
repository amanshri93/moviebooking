package com.uc.moviebooking.service;

import com.uc.moviebooking.exception.*;
import com.uc.moviebooking.models.Booking;
import com.uc.moviebooking.models.User;

import java.util.List;

public interface BookingService {
    public int book(Booking booking) throws BookingAlreadyExist, ShowNotFound, UserNotFound, ScreenNotFound, BookingNotAvailable;

    public boolean getAvailability(Booking booking) throws ShowNotFound, ScreenNotFound, UserNotFound;

    public List<Booking> getUserHistory(User user);
}
