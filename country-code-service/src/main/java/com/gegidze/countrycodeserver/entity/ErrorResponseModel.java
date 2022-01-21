package com.gegidze.countrycodeserver.entity;

import java.time.LocalDateTime;

public class ErrorResponseModel {

    private final String errorMessage;
    private final LocalDateTime timestamp;
    private final String path;

    public ErrorResponseModel(String errorMessage, LocalDateTime timestamp, String path) {
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
