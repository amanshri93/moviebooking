package com.uc.moviebooking.service;

import com.uc.moviebooking.exception.UserAlreadyExistException;
import com.uc.moviebooking.exception.UserNotFound;
import com.uc.moviebooking.models.User;

import java.util.List;

public interface UserService {
    public void registerUser(User user) throws UserAlreadyExistException;

    public User getUser(String id) throws UserNotFound;

    public List<User> listUsers();
}
