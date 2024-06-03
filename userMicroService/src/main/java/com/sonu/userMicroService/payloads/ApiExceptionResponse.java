package com.sonu.userMicroService.payloads;

import org.springframework.http.HttpStatus;

public class ApiExceptionResponse {

    private String message;
    private Boolean success;
    private HttpStatus httpStatus;

    public ApiExceptionResponse() {
    }

    public ApiExceptionResponse(String message, Boolean success, HttpStatus httpStatus) {
        this.message = message;
        this.success = success;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    
}
