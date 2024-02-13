package com.example.socialnetwork.exceptions;

public class InvalidRequestArgumentException extends RuntimeException {

    public InvalidRequestArgumentException(String message) {
        super(message);
    }

    public InvalidRequestArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
