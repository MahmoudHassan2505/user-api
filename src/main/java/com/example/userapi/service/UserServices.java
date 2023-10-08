package com.example.userapi.service;

import com.example.userapi.dto.UserDto;
import com.example.userapi.dto.UserMapper;
import com.example.userapi.entity.User;
import com.example.userapi.exception.CustomException;
import com.example.userapi.exception.ExceptionMessage;
import com.example.userapi.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;

//    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public List<User> findALl(){
        List<User> users = repository.findAll();
//        return users.stream().map((user)->userMapper.toDto(user)).collect(Collectors.toList());
        return users;
    }

    public User loginIn(String username,String password){
        User user = repository.findUserByUsernameAndPassword(username,password).orElseThrow(()->new CustomException(ExceptionMessage.Login_Faild));
        if (!user.isActive()){
            throw new CustomException(ExceptionMessage.User_Is_Not_Active);
        }
        return user;
    }

    public User add(User user){
        return repository.save(user);
    }

    public User deactivate(long id){
        User user = repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        user.setActive(false);
        return repository.save(user);
    }
    public User activate(long id){
        User user = repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        user.setActive(true);
        return repository.save(user);
    }

}
