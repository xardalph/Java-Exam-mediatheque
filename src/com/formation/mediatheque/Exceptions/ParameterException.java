package com.formation.mediatheque.Exceptions;

public class ParameterException extends Exception {
    public ParameterException(String message) { super(message);}

    public ParameterException(String message, Throwable cause) {super(message, cause);}
}
