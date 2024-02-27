package edu.school21.chat.models;

public class NotSavedSubEntityException extends RuntimeException {
    public NotSavedSubEntityException (String message){
        super(message);
    }
}
