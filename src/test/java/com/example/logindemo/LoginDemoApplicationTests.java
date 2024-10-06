package com.example.logindemo;

import cn.hutool.json.JSONUtil;
import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.domain.pojo.MyUserDetail;
import com.example.logindemo.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import java.util.Objects;

@SpringBootTest
class LoginDemoApplicationTests {



    @Test
    void testPWd() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        $2a$10$HLuJqCLQsnTMmrhDw1KSguoeIewvrdvBCS7I27XfNzFtt7bvZdUHC
        System.out.println(passwordEncoder.matches("123456","$2a$10$HLuJqCLQsnTMmrhDw1KSguoeIewvrdvBCS7I27XfNzFtt7bvZdUHC"));
    }

    @Test
    void testToken(){
        Map<String, Object> claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjgyMjE3MDIsInVzZXIiOnsidXNlciI6eyJ1c2VyTmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IiQyYSQxMCRITHVKcUNMUXNuVE1tcmhEdzFLU2d1b2VJZXd2cmR2QkNTN0kyN1hmTnpGdHQ3YnZaZFVIQyJ9LCJlbmFibGVkIjp0cnVlLCJwYXNzd29yZCI6IiQyYSQxMCRITHVKcUNMUXNuVE1tcmhEdzFLU2d1b2VJZXd2cmR2QkNTN0kyN1hmTnpGdHQ3YnZaZFVIQyIsInVzZXJuYW1lIjoidGVzdCIsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImF1dGhvcml0aWVzIjpudWxsLCJhY2NvdW50Tm9uTG9ja2VkIjp0cnVlfX0.tOjfoiL5et-z5u__qMRnNinaSE937aE_UHtu_NBUkMU");
        System.out.println(claims.get("user"));
        MyUserDetail user = JSONUtil.toBean(JSONUtil.parseObj(claims.get("user")), MyUserDetail.class);
        System.out.println(user);
    }

}
