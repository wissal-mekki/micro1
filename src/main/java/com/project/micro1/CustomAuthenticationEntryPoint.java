package com.project.micro1;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


     @Override
     public void commence(HttpServletRequest request, HttpServletResponse response,
                          AuthenticationException authException) throws IOException, ServletException {
         response.getWriter().print("You need to login first in order to perform this action.");
     }
}
