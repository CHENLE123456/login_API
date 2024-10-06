package com.example.logindemo.controller;

import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name = "首页接口")
public class HelloController {

    @GetMapping("/Hello")
    @Operation(summary = "首页")
    public String login(){
        return "Hello world";
    }
}
