package com.stackroute.user.service;

import com.stackroute.user.domain.User;
import com.stackroute.user.exceptions.NullValuesPassed;
import com.stackroute.user.exceptions.UserAlreadyExists;
import com.stackroute.user.exceptions.UserDoesNotExists;


import java.util.List;

public interface UserService {

    public User saveUser(User user) throws UserAlreadyExists, NullValuesPassed;

    public List<User> getAllUsers();

    public User getUserById(int userId) throws UserDoesNotExists;

    public User updateUser(User user) throws UserDoesNotExists;

    public User deleteUser(int id)throws UserDoesNotExists;
}

