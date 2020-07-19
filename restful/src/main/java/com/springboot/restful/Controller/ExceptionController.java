package com.springboot.restful.Controller;

import com.springboot.restful.Exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/illegalArgumentResponse")
    public void throwException(){
        throw new IllegalArgumentException();
    }
    @GetMapping("/ResourceNotFount")
    public void throwException2(){
        throw new ResourceNotFoundException();
    }
}


