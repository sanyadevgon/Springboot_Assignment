package com.Springboot.EAMS.exception;

public class DublicateDetailsException extends  RuntimeException {

    public DublicateDetailsException() {
    }

    public DublicateDetailsException(String message) {

        super(message);
    }
}
