package com.uc.moviebooking.helper;

import com.uc.moviebooking.models.*;
import com.uc.moviebooking.models.enums.SeatType;
import com.uc.moviebooking.service.impl.TierBasePricing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
    public static User user1 = new User("1", "user1");
    public static User user2 = new User("2", "user2");
    public static User user3 = new User("3", "user3");
    public static User user4 = new User("4", "user4");
    public static User user5 = new User("5", "user5");


    public static Movie movie1 = new Movie("1", "movie1");
    public static Movie movie2 = new Movie("2", "movie2");
    public static Movie movie3 = new Movie("3", "movie3");
    public static Movie movie4 = new Movie("4", "movie4");
    public static Movie movie5 = new Movie("5", "movie5");


    public static Screen screen1 = new Screen("1", "screen1", 10);
    public static Screen screen2 = new Screen("2", "screen2", 100);
    public static Screen screen3 = new Screen("3", "screen3", 5);


    private static Map<SeatType,  Integer> pricingMap = new HashMap<SeatType, Integer>() {{
        put(SeatType.Executive, 500);
        put(SeatType.Premium, 200);
        put(SeatType.Gold, 100);
    }};

    public static Show show1 = new Show("1", movie1, 1635881400L, 1635892200L, screen1, new TierBasePricing(pricingMap)); //7:30 to 10:30
    public static Show show2 = new Show("2", movie1, 1635883200L, 1635894000L, screen2, new TierBasePricing(pricingMap)); // 8:00 to 11:00
    public static Show show3 = new Show("3", movie2, 1635883200L, 1635894000L, screen1, new TierBasePricing(pricingMap)); // 8:00 to 11:00



    public static List<Seat> seats = new ArrayList<Seat>() {{
        add(new Seat(4, SeatType.Gold));
        add(new Seat(2, SeatType.Premium));
        add(new Seat(1, SeatType.Executive));
    }};

    public static Booking booking1 = new Booking("1", user1, show1, seats);
    public static Booking booking2 = new Booking("2", user2, show1, seats);
    public static Booking booking3 = new Booking("3", user3, show2, seats);
    public static Booking booking4 = new Booking("4", user1, show2, seats);


}
