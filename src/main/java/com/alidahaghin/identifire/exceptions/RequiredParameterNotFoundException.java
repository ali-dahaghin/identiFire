package com.alidahaghin.identifire.exceptions;

public class RequiredParameterNotFoundException extends RuntimeException {
    public RequiredParameterNotFoundException(String message) {
        super(message);
    }
}
