package com.springboot.restful.Controller;

import com.springboot.restful.Domain.Entity.Book;
import com.springboot.restful.Exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/illegalArgumentResponse")
    public void throwException(){
        throw new IllegalArgumentException();
    }
    @GetMapping("/ResourceNotFount")
    public void throwException2(){
        Book book = new Book(1,"test","book for test");
//        assert book instanceof Map<String, Object>;
//        throw new ResourceNotFoundException();
    }
}


