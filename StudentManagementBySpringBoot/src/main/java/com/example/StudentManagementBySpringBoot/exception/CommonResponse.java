package com.example.StudentManagementBySpringBoot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
//@AllArgsConstructor
public class CommonResponse {

    private String timestamp;
    private String error_message;
    private String details;

    public CommonResponse(String timestamp, String error_message, String details) {
        this.timestamp = timestamp;
        this.error_message = error_message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
