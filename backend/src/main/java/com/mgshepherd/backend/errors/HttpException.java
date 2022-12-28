package com.mgshepherd.backend.errors;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    protected final HttpStatus status;

    public HttpException(String name, HttpStatus status) {
        super(name);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
