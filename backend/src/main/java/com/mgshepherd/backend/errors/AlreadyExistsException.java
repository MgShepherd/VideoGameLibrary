package com.mgshepherd.backend.errors;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends HttpException {
    public AlreadyExistsException(String name) {
        super(name + " already exists in the database", HttpStatus.CONFLICT);
    }
}
