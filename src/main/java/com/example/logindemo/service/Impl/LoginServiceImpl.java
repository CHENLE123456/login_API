package com.example.logindemo.service.Impl;

import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.domain.pojo.MyUserDetail;
import com.example.logindemo.result.Result;
import com.example.logindemo.service.LoginService;
import com.example.logindemo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        Object principal = authenticate.getPrincipal();
        MyUserDetail userDetail = (MyUserDetail) principal;
        //输出用户信息
        log.info(userDetail.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("user",userDetail);
        String token = JwtUtil.createJWT(map);
        //输出token
        log.info(token);
        //返回token
        return Result.ok(token);
    }
}
