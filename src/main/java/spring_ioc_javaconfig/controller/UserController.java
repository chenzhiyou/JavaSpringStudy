package spring_ioc_javaconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_ioc_javaconfig.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public void getUser(){
        userService.getUser();
    }
}
