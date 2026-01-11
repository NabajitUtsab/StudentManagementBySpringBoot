package com.example.StudentManagementBySpringBoot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    private String timestamp;
    private String error_message;
    private String details;
}
