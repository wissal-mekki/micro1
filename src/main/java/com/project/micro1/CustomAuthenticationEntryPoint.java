package com.project.micro1;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
   /*
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(JsonPOJOBuilder)
                .put("timestamp",DateGenerator.getDate())
                .put("status", 403)
                .put("message", "Access denied")
                .build());
    }*/

     @Override
     public void commence(HttpServletRequest request, HttpServletResponse response,
                          AuthenticationException authException) throws IOException, ServletException {
         response.getWriter().print("You need to login first in order to perform this action.");
     }
}