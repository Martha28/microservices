package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.User;
import com.stackroute.MuzixApplication.exceptions.NullValuesPassed;
import com.stackroute.MuzixApplication.exceptions.UserAlreadyExists;
import com.stackroute.MuzixApplication.exceptions.UserDoesNotExists;


import java.util.List;

public interface UserService {

    public User saveUser(User user) throws UserAlreadyExists, NullValuesPassed;

    public List<User> getAllUsers();

    public User getUserById(int userId) throws UserDoesNotExists;

    public User updateUser(User user) throws UserDoesNotExists;

    public User deleteUser(int id)throws UserDoesNotExists;
}

