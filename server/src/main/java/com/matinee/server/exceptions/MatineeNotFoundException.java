package com.matinee.server.exceptions;

import org.springframework.http.HttpStatus;


public class MatineeNotFoundException extends MatineeBaseException {

    public static String errorType = "not-found";

    public MatineeNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND);
        this.setDetail(message);
        this.setType(this.createErrorType(errorType));
    }
}
