package com.stackroute.user.service;

import com.stackroute.user.domain.User;
import com.stackroute.user.exceptions.NullValuesPassed;
import com.stackroute.user.exceptions.UserAlreadyExists;
import com.stackroute.user.exceptions.UserDoesNotExists;

import com.stackroute.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//added new after error
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    private User user;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExists, NullValuesPassed {

        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExists("User already exists");
        }
        if(user.getName() == null && user.getComment() == null){
            throw new NullValuesPassed("Null values passed");
        }
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public User getUserById(int UserId) throws UserDoesNotExists {
        if(userRepository.existsById(UserId)){
            return userRepository.findById(UserId).get();
        }
        else{
            throw new UserDoesNotExists("User does not exists");
        }

    }

    @Override
    public User updateUser(User user)throws UserDoesNotExists {

        if (userRepository.existsById(user.getId())) {
            userRepository.findById(user.getId()).get();
            user.setId(user.getId());
            if (user.getName() != null && user.getName() != "") {
                user.setName(user.getName());
            }
            if (user.getComment() != null && user.getComment() != "") {
                user.setComment(user.getComment());
            }
            userRepository.save(user);
            return user;
        } else {
            throw new UserDoesNotExists("User does not exits");
        }
    }

    @Override
    public User deleteUser(int userId) throws UserDoesNotExists {

              if (userRepository.existsById(userId)) {
                User deletedUser = getUserById(userId); //storing the User to be deleted in a variable
                userRepository.deleteById(userId);
                return deletedUser;
            } else {
                throw new UserDoesNotExists("User does not exits");
            }



    }


}
