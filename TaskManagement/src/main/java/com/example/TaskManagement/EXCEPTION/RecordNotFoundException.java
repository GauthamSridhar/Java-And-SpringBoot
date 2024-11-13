package com.example.TaskManagement.EXCEPTION;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String message){
        super(message);
    }
}

