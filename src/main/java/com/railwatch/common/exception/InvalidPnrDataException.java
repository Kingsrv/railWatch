package com.railwatch.common.exception;

public class InvalidPnrDataException extends RuntimeException {

    public InvalidPnrDataException(String message) {
        super(message);
    }
}