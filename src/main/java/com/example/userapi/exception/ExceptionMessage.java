package com.example.userapi.exception;

public enum ExceptionMessage {
    User_Not_Found("user not found with this id");

    String message;
    ExceptionMessage(String message){
        this.message=message;
    }
}
