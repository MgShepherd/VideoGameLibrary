package com.mgshepherd.backend.errors;

import org.springframework.http.HttpStatus;

public class InvalidJSONException extends HttpException {
    public InvalidJSONException() {
        super("Supplied JSON does not have correct format", HttpStatus.BAD_REQUEST);
    }
}
