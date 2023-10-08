package com.example.userapi.exception;

import javax.security.auth.login.FailedLoginException;

public enum ExceptionMessage {
    User_Not_Found("user not found with this id"),
    Login_Faild("Wrong Username Or Password"),
    User_Is_Not_Active("Account is Deactivated");
    String message;
    ExceptionMessage(String message){
        this.message=message;
    }
}
