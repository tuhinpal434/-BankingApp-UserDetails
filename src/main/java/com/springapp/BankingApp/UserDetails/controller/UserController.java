package com.springapp.BankingApp.UserDetails.controller;

import com.springapp.BankingApp.UserDetails.VO.ResponseEntityVO;
import com.springapp.BankingApp.UserDetails.entity.User;
import com.springapp.BankingApp.UserDetails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServices;

    @GetMapping("/")
    public List<User> getAllUsers(){

        return userServices.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntityVO getUserById(@PathVariable("id") long id){
        return userServices.findUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userServices.saveUser(user);
    }
}
