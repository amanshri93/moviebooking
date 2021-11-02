package com.uc.moviebooking.service.impl;

import com.uc.moviebooking.exception.*;
import com.uc.moviebooking.models.*;
import com.uc.moviebooking.service.BookingService;
import com.uc.moviebooking.service.ScreenService;
import com.uc.moviebooking.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingServiceImpl implements BookingService {
    private static Map<String, Booking> bookings;
    private static Map<User, List<Booking>> userBookingHistory;
    private static Map<Show, List<Booking>> showToBookingMap;

    private UserService userService;
    private ScreenService screenService;

    static {
        bookings = new HashMap<String, Booking>();
        userBookingHistory = new HashMap<User, List<Booking>>();
        showToBookingMap = new HashMap<Show, List<Booking>>();
    }

    public BookingServiceImpl(UserService userService, ScreenService screenService) {
        this.userService = userService;
        this.screenService = screenService;
    }

    public int book(Booking booking) throws BookingAlreadyExist, ShowNotFound, UserNotFound, ScreenNotFound, BookingNotAvailable {
        if (bookings.get(booking.getId()) != null) {
            throw new BookingAlreadyExist();
        }

        validate(booking);

        int price = booking.getShow().getPricingStrategy().getPrice(booking);
        //Synchronised on show
        if (getAvailability(booking)) {
            //transactional block
            booking.setPrice(price);
            bookings.put(booking.getId(), booking);
            if (userBookingHistory.get(booking.getUser()) == null) {
                userBookingHistory.put(booking.getUser(), new ArrayList<Booking>());
            }
            userBookingHistory.get(booking.getUser()).add(booking);

            if (showToBookingMap.get(booking.getShow()) == null) {
                showToBookingMap.put(booking.getShow(), new ArrayList<Booking>());
            }
            showToBookingMap.get(booking.getShow()).add(booking);
        } else {
            throw new BookingNotAvailable();
        }
        return price;
    }

    private void validate(Booking booking) throws UserNotFound, ScreenNotFound, ShowNotFound {
        userService.getUser(booking.getUser().getId());
        screenService.getShow(booking.getShow().getId());
        screenService.getScreen(booking.getShow().getScreen().getId());
    }

    public boolean getAvailability(Booking booking) throws ScreenNotFound, UserNotFound, ShowNotFound {
        validate(booking);
        Screen screen = screenService.getScreen(booking.getShow().getScreen().getId());
        int bookedSeat = getBookedSeat(booking.getShow());
        int maxSeat = screen.getSeats();
        int seatbooking = 0;

        for (Seat seat: booking.getSeats()) {
            seatbooking = seatbooking + seat.getCount();
        }

        return bookedSeat + seatbooking <= maxSeat;
    }

    private int getBookedSeat(Show show) {
        List<Booking> bookings = showToBookingMap.get(show);
        int booked = 0;
        if (bookings != null) {
            for (Booking booking : bookings) {
                List<Seat> seats = booking.getSeats();
                for (Seat seat : seats) {
                    booked = booked + seat.getCount();
                }
            }
        }
        return booked;
    }

    public List<Booking> getUserHistory(User user) {
        return userBookingHistory.get(user);
    }
}
