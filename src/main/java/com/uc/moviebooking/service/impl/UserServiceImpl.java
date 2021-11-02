package com.uc.moviebooking.service.impl;

import com.uc.moviebooking.exception.UserAlreadyExistException;
import com.uc.moviebooking.exception.UserNotFound;
import com.uc.moviebooking.models.User;
import com.uc.moviebooking.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private static Map<String, User> users;

    static {
        users = new HashMap<String, User>();
    }

    public void registerUser(User user) throws UserAlreadyExistException { //Can generate id in this function
        if (users.get(user.getId()) == null) {
            users.put(user.getId(), user);
        } else {
            throw new UserAlreadyExistException();
        }
    }

    public User getUser(String id) throws UserNotFound {
        if (users.get(id) != null) {
            return users.get(id);
        } else {
            throw new UserNotFound();
        }
    }

    public List<User> listUsers() {
        return (List<User>) users.values();
    }
}
