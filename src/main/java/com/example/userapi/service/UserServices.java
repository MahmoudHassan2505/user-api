package com.example.userapi.service;
import com.example.userapi.dto.UserDto;
import com.example.userapi.dto.UserMapper;
import com.example.userapi.entity.User;
import com.example.userapi.exception.CustomException;
import com.example.userapi.exception.ExceptionMessage;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findALl(){
        List<User> users = repository.findAll();
        return users.stream().map((user)->userMapper.toDTO(user)).collect(Collectors.toList());

    }

    public UserDto loginIn(String username,String password){
        User user = repository.findUserByUsernameAndPassword(username,password).orElseThrow(()->new CustomException(ExceptionMessage.Login_Faild));
        if (!user.isActive()){
            throw new CustomException(ExceptionMessage.User_Is_Not_Active);
        }
        return userMapper.toDTO(user);
    }

    public User add(User user,boolean isAdmin){
        if(!isAdmin){
            throw new CustomException(ExceptionMessage.User_Is_Not_Admin);
        }
        if (repository.countUsersByUsername(user.getUsername())!=0){
            throw new CustomException(ExceptionMessage.Name_Already_Exist);

        }
        return repository.save(user);
    }

    public User deactivate(long id,boolean isAdmin){
        User user = repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        if(!isAdmin){
            throw new CustomException(ExceptionMessage.User_Is_Not_Admin);
        }
        user.setActive(false);
        return repository.save(user);
    }
    public User activate(long id,boolean isAdmin){
        User user = repository.findById(id).orElseThrow(()->new CustomException(ExceptionMessage.User_Not_Found));
        if(!isAdmin){
            throw new CustomException(ExceptionMessage.User_Is_Not_Admin);
        }
        user.setActive(true);
        return repository.save(user);
    }

}
