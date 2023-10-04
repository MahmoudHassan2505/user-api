package com.example.userapi.service;

import com.example.userapi.entity.User;
import com.example.userapi.exception.CustomException;
import com.example.userapi.exception.ExceptionMessage;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;

    public List<User> findALl(){
        return repository.findAll();
    }

    public User add(User user){
        return repository.save(user);
    }

    public User deactivate(long id){
        repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        User user = repository.findById(id).get();
        user.setActive(false);
        return repository.save(user);
    }
    public User activate(long id){
        repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        User user = repository.findById(id).get();
        user.setActive(true);
        return repository.save(user);
    }
}
