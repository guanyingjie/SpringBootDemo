package com.springboot.restful.Mybatis.Controller;

import com.springboot.restful.Mybatis.Bean.User;
import com.springboot.restful.Mybatis.Service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/query")
    public List<User>query(){
        return userService.findAllUsers();
    }

    @GetMapping("/{name}")
    public User findByName(String name){
        return userService.findUserByName(name);
    }

    @PostMapping("/insert")
    public List<User>insert(){
         userService.insertService();
         return userService.findAllUsers();
    }

    @DeleteMapping("/delete")
    public String delete(){
        userService.deleteUser(3);
        return "ok";
    }


}
