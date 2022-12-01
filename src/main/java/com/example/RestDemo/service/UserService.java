package com.example.RestDemo.service;

import com.example.RestDemo.entity.User;
import com.example.RestDemo.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j

public class UserService {

    // business logic

    //createUser
    //updateUser
    //viewUsers
    //deleteusers
//@Autowired
    // JdbcTemplate jdbcTemplate;
    @Autowired
    UserRepo userRepo;

    public User createUser(User user) {
      //  try {
            //Validations before saving to the Db
            //save to db
            //send an email

            //Ist Option with raw sql statements
//You can have sql statement
            // String sql="INSERT INTO Users(name,password,username) VALUES (?,?,?)";
            //jdbcTemplate.update(sql,new Object[]{user.getName(),user.getPassword(),user.getUsername()});

            //2nd option user of userRepo
            userRepo.save(user);
            return user;

       // } catch (Exception e) {
         //   log.error("Error occurred while creating the user ", e.getLocalizedMessage());
           // return null;
        //}
    }

    public void updateUser(User user) {
        //try {
            log.info("Received an update request for " + user.getUsername());
            //Another option is writing SQL statement
            // String sql="UPDATE User set name=?,..... where id=?"
            // jdbcTemplate.update(sql,new Object[]{user.getName(),user.getPassword()});
            userRepo.save(user);
         //   return "Success";

      //  } catch (Exception e) {
       //     log.error("Update error occurred ", e.getLocalizedMessage());
       //     return null;
     //   }
    }

    public List<User> viewUsers() {
        List<User> us = new ArrayList<>();

       // try {

            return (List<User>) userRepo.findAll();

       // } catch (Exception e) {
      //      return null;
      //  }
    }

    public void deleteUserById(long id) {
       // try {
            //userRepo.delete(user);
            userRepo.deleteById(id);

           // return "Deleted";
       // } catch (Exception e) {
         //   log.error("Error occurred while deleting " + e.getMessage());
           // return "Error occurred while deleting";
      //  }
    }

    public boolean findUserById(Long id) {
        if (userRepo.findById(id) == null) {
            return false;
        } else {
            return true;
        }
    }
    public User findUser(Long id) {

      User user =userRepo.findById(id).get();
            return user;
    }

}
