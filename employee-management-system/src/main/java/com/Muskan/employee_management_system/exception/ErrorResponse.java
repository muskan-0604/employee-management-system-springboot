package com.Muskan.employee_management_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime ;

    public ErrorResponse(String message , int status){
        this.message = message;
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }
}
