package com.springboot.restful.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Helloworld {
    @GetMapping("/helloworld")
    public String Helloworld() throws InterruptedException{
        Thread.sleep(1000);
        return "ok";
    }
}
