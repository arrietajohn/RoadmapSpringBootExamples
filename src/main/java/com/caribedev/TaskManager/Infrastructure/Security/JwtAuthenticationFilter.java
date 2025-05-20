package com.caribedev.TaskManager.Infrastructure.Security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Este filtro se ejecuta una vez por cada petición HTTP. Se encarga de: 1. Leer
 * el token del header Authorization. 2. Validarlo. 3. Establecer el usuario
 * autenticado en el contexto de Spring.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
   
@Override
protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
) throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        filterChain.doFilter(request, response);
        return;
    }

    String token = authHeader.substring(7);

    try {
        Claims claims = jwtTokenProvider.parseClaims(token);
        String username = claims.get("username", String.class);
        String role = claims.get("role", String.class);

        var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
        var authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);

    } catch (Exception ex) {
        SecurityContextHolder.clearContext();

        // Delegamos el error a nuestro AuthenticationEntryPoint personalizado
        authenticationEntryPoint.commence(
            request,
            response,
            new org.springframework.security.core.AuthenticationException("Token inválido o corrupto") {}
        );
    }
}


    public Claims parseClaims(String token) {
       Claims claims = Jwts.parserBuilder()
                .requireIssuer("caribedev.com")
                .setSigningKey(jwtTokenProvider.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        Object aud = claims.get("aud");

        if (aud instanceof String audStr) {
            if (!audStr.contains("web.caribedev.com")) {
                throw new JwtException("Audiencia no válida");
            }
        } else if (aud instanceof List<?> audList) {
            if (!audList.contains("movil.caribedev.com")) {
                throw new JwtException("Audiencia no válida");
            }
        }
        return claims;
    }

}
