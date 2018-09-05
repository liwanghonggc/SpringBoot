package com.lwh.springboot.chp4.exception;


public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户不存在");
    }
}
