package org.example;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String message){
        super(message);
    }
}
