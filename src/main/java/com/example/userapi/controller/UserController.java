package com.example.userapi.controller;

import com.example.userapi.dto.UserDto;
import com.example.userapi.entity.User;
import com.example.userapi.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping
    public List<User> findAll(){
        return userServices.findALl();
    }

    @GetMapping("/login")
        public User login(@RequestBody User user){
        return userServices.loginIn(user.getUsername(),user.getPassword());
    }

    @PostMapping
    public User add(@RequestBody User user){
        return userServices.add(user);
    }

    @PostMapping("/deactivate/{id}")
    public User deactivate(@PathVariable long id){
        return userServices.deactivate(id);
    }

    @PostMapping("/activate/{id}")
    public User activate(@PathVariable long id){
        return userServices.activate(id);
    }

}


//password shouldn't return in api