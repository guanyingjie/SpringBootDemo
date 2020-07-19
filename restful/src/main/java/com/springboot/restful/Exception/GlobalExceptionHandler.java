package com.springboot.restful.Exception;

import com.springboot.restful.Controller.ExceptionController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = ExceptionController.class)
public class GlobalExceptionHandler {

    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("params fault"));
    ErrorResponse ResourceNotFount = new ErrorResponse(new ResourceNotFoundException("Resource not found"));

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if(e instanceof IllegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }
        else if(e instanceof ResourceNotFoundException){
            return  ResponseEntity.status(404).body(ResourceNotFount);
        }
        else{
            return null;
        }
    }

}
