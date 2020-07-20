package com.springboot.restful.Exception;

import com.springboot.restful.Controller.ExceptionController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@ControllerAdvice(assignableTypes = ExceptionController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleAppException(BaseException ex, HttpServletRequest request) {
        ErrorResponse representation = new ErrorResponse(ex, request.getRequestURI());
        return new ResponseEntity<>(representation, new HttpHeaders(), ex.getError().getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> ResourceNotFound(BaseException ex,HttpServletRequest request){
        ErrorResponse response = new ErrorResponse(ex,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }




//    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("params fault"));
//    ErrorResponse ResourceNotFount = new ErrorResponse(new ResourceNotFoundException("Resource not found"));
//
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
//        if(e instanceof IllegalArgumentException){
//            return ResponseEntity.status(400).body(illegalArgumentResponse);
//        }
//        else if(e instanceof ResourceNotFoundException){
//            return  ResponseEntity.status(404).body(ResourceNotFount);
//        }
//        else{
//            return null;
//        }
//    }

}
