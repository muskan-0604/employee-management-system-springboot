package com.Muskan.employee_management_system.specification;


import com.Muskan.employee_management_system.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionResponseEntity (EmployeeNotFoundException exception){
       ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value()) ;
        return new  ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeAlreadyExists.class)
    public ResponseEntity<ErrorResponse> alreadyExistsResponseEntity (EmployeeAlreadyExists exists){
       ErrorResponse errorResponse = new ErrorResponse(exists.getMessage() , HttpStatus.CONFLICT.value());
       return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
}
