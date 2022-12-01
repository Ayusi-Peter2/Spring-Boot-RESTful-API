package com.example.RestDemo.controller;

import com.example.RestDemo.entity.User;
import com.example.RestDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "users")
public class UserController {
    //Expose GET
    //Expose PUT
    //Expose DELETE
    //POST
    @Autowired
    UserService userService;

    //To update the user,we use @PutMapping
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            if (userService.findUserById(id)) {
                User user1 = userService.findUser(id);
                user1.setName(user.getName());
                userService.updateUser(user1);
                return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");
            } else {

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

            }
        } catch (Exception e) {
            log.error("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to update the user");
        }

    }

    @GetMapping(path = "/")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.status(HttpStatus.OK).body("My home page is working");
    }


    @GetMapping("/create")
    public ResponseEntity<?> getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all headers");
        try {
            List<User> usersList = userService.viewUsers();
//log.info(" Created "+usersList.get(0).getName());
            if (usersList == null) {
                return new ResponseEntity<>("Empty list", headers, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(("Error occurred while fetching all users " + e.getMessage()));
            return new ResponseEntity("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
            //ResponseEntity.status(HttpStatus.OK).headers()
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Deleting a user record");
        try {
            if (userService.findUserById(id)) {
                userService.deleteUserById(id);
                ResponseEntity<String> responseEntity = new ResponseEntity<String>("User deleted successfully", header, HttpStatus.NOT_FOUND);
                return responseEntity;
            } else {
                //to include headers when using static ResponseEntity,headers must come immediately after httpStatus
                //Like this //return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body("User not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (NumberFormatException e) {
            log.error("Error occurred " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only numbers are accepted ");
        } catch (Exception e) {
            log.error("Error occurred " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only numbers are accepted");
        }
      /*  try {
            userService.deleteUserById(id).;
           }
        catch(Exception e)
        {
            log.error("Unable to delete user with specified id "+id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete the user");
        }*/
    }

    @GetMapping("/users1")
    public ResponseEntity<String> createUser() {
        try {
            User n = new User("Moses", "moses@gmail.com", "77777777", 1);
            User user = userService.createUser(n);
            return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating the user " + e.getMessage());
            return new ResponseEntity<>("User not created :", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
