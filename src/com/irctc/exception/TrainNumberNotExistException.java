package com.irctc.exception;

public class TrainNumberNotExistException extends Exception{
    String message;

    public TrainNumberNotExistException(String message){
        super(message);
        this.message=message;
    }
}
