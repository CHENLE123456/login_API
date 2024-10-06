package com.example.logindemo.controller;

import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.result.Result;
import com.example.logindemo.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name = "登录接口")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result login(@RequestBody User user){
        return loginService.login(user);
    }
}
