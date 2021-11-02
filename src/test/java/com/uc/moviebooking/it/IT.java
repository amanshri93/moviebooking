package com.uc.moviebooking.it;

import com.uc.moviebooking.exception.*;
import com.uc.moviebooking.helper.Factory;
import com.uc.moviebooking.service.BookingService;
import com.uc.moviebooking.service.MovieService;
import com.uc.moviebooking.service.ScreenService;
import com.uc.moviebooking.service.UserService;
import com.uc.moviebooking.service.impl.BookingServiceImpl;
import com.uc.moviebooking.service.impl.MovieServiceImpl;
import com.uc.moviebooking.service.impl.ScreenServiceImpl;
import com.uc.moviebooking.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IT {

    private UserService userService;
    private MovieService movieService;
    private ScreenService screenService;
    private BookingService bookingService;

    @Before
    public void before() {
        userService = new UserServiceImpl();
        movieService = new MovieServiceImpl();
        screenService = new ScreenServiceImpl(movieService);
        bookingService = new BookingServiceImpl(userService, screenService);
    }


    @Test
    public void e2e() throws UserAlreadyExistException, MovieAlreadyExist, ScreenAlreadyExist, MovieNotFound, ScreenNotAvailable, ShowAlreadyExist, ScreenNotFound, BookingAlreadyExist, ShowNotFound, UserNotFound, BookingNotAvailable {
        userService.registerUser(Factory.user1);
        userService.registerUser(Factory.user2);
        userService.registerUser(Factory.user3);

        movieService.addMovie(Factory.movie1);
        movieService.addMovie(Factory.movie2);
        movieService.addMovie(Factory.movie3);

        screenService.addScreen(Factory.screen1);
        screenService.addScreen(Factory.screen2);

        screenService.addShow(Factory.show1);
        screenService.addShow(Factory.show2);
        Exception exception = assertThrows(ScreenNotAvailable.class, () -> screenService.addShow(Factory.show3));

        System.out.println(bookingService.book(Factory.booking1));
        exception = assertThrows(BookingNotAvailable.class, () -> bookingService.book(Factory.booking2));
        System.out.println(bookingService.book(Factory.booking3));
        System.out.println(bookingService.book(Factory.booking4));


        System.out.println(bookingService.getUserHistory(Factory.user1));
    }
}
