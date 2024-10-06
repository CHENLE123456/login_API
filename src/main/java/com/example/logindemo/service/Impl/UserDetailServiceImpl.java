package com.example.logindemo.service.Impl;

import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.domain.pojo.MyUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //模拟一个从数据库中查到的用户 userName:test password:123456 加密为:$2a$10$HLuJqCLQsnTMmrhDw1KSguoeIewvrdvBCS7I27XfNzFtt7bvZdUHC
        User user = new User("test", "$2a$10$HLuJqCLQsnTMmrhDw1KSguoeIewvrdvBCS7I27XfNzFtt7bvZdUHC");
        return new MyUserDetail(user);
    }
}
