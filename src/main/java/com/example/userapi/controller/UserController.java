package com.example.userapi.controller;

import com.example.userapi.dto.UserDto;
import com.example.userapi.entity.User;
import com.example.userapi.service.UserServices;
import jakarta.websocket.server.PathParam;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping
    public List<UserDto> findAll(){
        return userServices.findALl();
    }

    @GetMapping("/login")
        public UserDto login(@RequestBody User user){
        return userServices.loginIn(user.getUsername(),user.getPassword());
    }

    @PostMapping
    public User add(@RequestBody User user,@RequestParam boolean isAdmin){
        return userServices.add(user,isAdmin);
    }

    @PostMapping("/deactivate/{id}")
    public User deactivate(@PathVariable long id, @RequestParam boolean isAdmin){
        return userServices.deactivate(id,isAdmin);
    }

    @PostMapping("/activate/{id}")
    public User activate(@PathVariable long id, @RequestParam boolean isAdmin){
        return userServices.activate(id, isAdmin);
    }

}
