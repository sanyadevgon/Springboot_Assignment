package com.Springboot.EAMS.exception;


public class EamsException extends RuntimeException{

    public EamsException() {
    }

    public EamsException(String message) {
        super(message);
    }
}