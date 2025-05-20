package com.caribedev.TaskManager.Infrastructure.Security;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, 
    HttpServletResponse response, 
    AuthenticationException authException) 
    throws IOException, ServletException {
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        var errorResponse = new HashMap<String, String>();
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "Unauthorized");
        errorResponse.put("status", String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
        response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));

    }

}
