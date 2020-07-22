package com.springboot.restful.Controller;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class Helloworld {
    @GetMapping("/helloworld")
    public String Helloworld() throws InterruptedException{
        Thread.sleep(1000);
        return "ok";
    }

    @GetMapping("/admin/oldLogin")
    public String oldLogin(Model model){
        return "OldLogin";
    }

    @GetMapping("/admin/login")
    public String Login(Model model){
        return "Login";
    }
}
