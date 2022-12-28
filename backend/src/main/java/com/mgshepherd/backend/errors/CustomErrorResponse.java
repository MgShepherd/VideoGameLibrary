package com.mgshepherd.backend.errors;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private final HttpStatus status;
    private final String error;

    public CustomErrorResponse() { this(HttpStatus.INTERNAL_SERVER_ERROR, ""); }

    public CustomErrorResponse(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
