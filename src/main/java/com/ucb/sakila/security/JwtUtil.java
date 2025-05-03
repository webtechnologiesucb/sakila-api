package com.ucb.sakila.security;

import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "supersecreto_supersecreto_supersecreto"; // Clave de al menos 32 caracteres
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date()) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 24 horas
                .signWith(KEY, SignatureAlgorithm.HS256) // Firma con clave segura
                .compact();
    }
}