package com.stackroute.user.Controller;

import com.stackroute.user.domain.User;
import com.stackroute.user.exceptions.NullValuesPassed;
import com.stackroute.user.exceptions.UserAlreadyExists;
import com.stackroute.user.exceptions.UserDoesNotExists;
import com.stackroute.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "User Service ", description = "Users")
public class UserController {


    private UserService userService;
    private User user;
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @ApiOperation(value = "posts Users")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successfully posted")
            }
    )
    @PostMapping("User")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExists, NullValuesPassed {
        ResponseEntity responseEntity;
        User savedUser =userService.saveUser(user);
        responseEntity= new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Gets all Users")
    @GetMapping("User")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @ApiOperation(value = "updates the Users")
    @PutMapping("User")
    public ResponseEntity<?> updateUser(@RequestBody User user)throws UserDoesNotExists {
        ResponseEntity responseEntity;
        User updatedUser = userService.updateUser(user);
        responseEntity= new ResponseEntity<User>(updatedUser, HttpStatus.CREATED);
        return responseEntity;
    }


    @DeleteMapping("User/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int userId) throws UserDoesNotExists {
        ResponseEntity responseEntity;
        User User = userService.deleteUser(userId);
        responseEntity= new ResponseEntity<User>(User, HttpStatus.CREATED);
        return responseEntity;
    }
}
