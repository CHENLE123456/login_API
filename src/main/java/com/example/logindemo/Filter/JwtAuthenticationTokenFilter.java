package com.example.logindemo.Filter;

import cn.hutool.json.JSONUtil;
import com.example.logindemo.domain.pojo.MyUserDetail;
import com.example.logindemo.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }

        //解析token
        Object user;
        try {
            Map<String, Object> claims = JwtUtil.parseJWT(token);
            user = claims.get("user");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("token失效");
        }
        MyUserDetail myUserDetail = JSONUtil.toBean(JSONUtil.parseObj(user), MyUserDetail.class);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(myUserDetail,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
