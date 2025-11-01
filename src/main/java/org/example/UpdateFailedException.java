package org.example;

public class UpdateFailedException extends RuntimeException {
    public UpdateFailedException(String message){
        super(message);
    }
}
