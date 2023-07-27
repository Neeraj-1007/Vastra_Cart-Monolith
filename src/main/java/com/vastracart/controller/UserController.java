package com.vastracart.controller;


import com.vastracart.service.serviceInt.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Login")
public class UserController {

    @Autowired
    UserServiceInt userServiceInt;
}
