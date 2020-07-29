package com.Springboot.EAMS.exception;

public class NullBodyException extends RuntimeException{

    public NullBodyException() {
    }

    public NullBodyException(String message) {

        super(message);
    }
}