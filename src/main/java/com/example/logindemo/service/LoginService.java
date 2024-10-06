package com.example.logindemo.service;

import com.example.logindemo.domain.Entity.User;
import com.example.logindemo.result.Result;

public interface LoginService {
    Result login(User user);
}
