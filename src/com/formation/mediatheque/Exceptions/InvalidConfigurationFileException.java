package com.formation.mediatheque.Exceptions;

public class InvalidConfigurationFileException extends Exception{
    public InvalidConfigurationFileException(String message){
        super(message);
    }
    public InvalidConfigurationFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
