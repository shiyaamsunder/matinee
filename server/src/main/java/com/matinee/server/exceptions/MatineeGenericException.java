package com.matinee.server.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class MatineeGenericException extends ErrorResponseException {

    public MatineeGenericException(String message, HttpStatus httpStatus) {
        super(httpStatus);
        this.setDetail(message);
    }
}
