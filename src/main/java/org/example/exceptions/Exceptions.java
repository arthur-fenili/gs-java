package org.example.exceptions;

 public class Exceptions extends RuntimeException {
    public Exceptions(String message) {
        super(message);
    }
}

 class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

