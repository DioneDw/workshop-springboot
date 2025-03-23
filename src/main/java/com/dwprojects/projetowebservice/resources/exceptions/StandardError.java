package com.dwprojects.projetowebservice.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Generated;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;

    private Integer status;
    private String error;
    private String message;
    private String path;

    @Generated
    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    @Generated
    public Instant getTimestamp() {
        return timestamp;
    }
    @Generated
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    @Generated
    public Integer getStatus() {
        return status;
    }
    @Generated
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Generated
    public String getError() {
        return error;
    }
    @Generated
    public void setError(String error) {
        this.error = error;
    }
    @Generated
    public String getMessage() {
        return message;
    }
    @Generated
    public void setMessage(String message) {
        this.message = message;
    }
    @Generated
    public String getPath() {
        return path;
    }
    @Generated
    public void setPath(String path) {
        this.path = path;
    }
}
