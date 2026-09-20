package com.railwatch.common.exception;

public class PnrNotFoundException extends RuntimeException {

    public PnrNotFoundException(String message) {
        super(message);
    }
}