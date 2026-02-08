package com.matinee.server.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

public class MatineeBaseException extends ErrorResponseException {

    public MatineeBaseException(HttpStatusCode status) {
        super(status);
        super.setInstance(null);
    }

    public URI createErrorType(String errorTypeEndpoint){
        return URI.create("http://localhost:8080/matinee/api/v1/errors/" + errorTypeEndpoint);
    }
}
