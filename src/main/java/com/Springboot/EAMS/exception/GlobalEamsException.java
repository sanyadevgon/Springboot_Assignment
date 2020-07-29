package com.Springboot.EAMS.exception;


public class GlobalEamsException extends RuntimeException{

    public GlobalEamsException() {
    }

    public GlobalEamsException(String message) {

        super(message);
    }
}