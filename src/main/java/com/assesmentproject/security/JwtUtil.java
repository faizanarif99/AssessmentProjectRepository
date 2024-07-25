package com.assesmentproject.security;

import com.assesmentproject.utils.Constants;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken( UserDetails userDetails ) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY)
                .compact();
    }

    public String extractUsername( String token ) {
        return extractClaims(token).getBody().getSubject();
    }

    public boolean validateToken( String token, UserDetails userDetails ) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired( String token ) {
        final Date expirationDate = extractClaims(token).getBody().getExpiration();
        return expirationDate.before(new Date());
    }

    private Jws<Claims> extractClaims( String token ) {
        return Jwts.parser().setSigningKey(Constants.SECRET_KEY).parseClaimsJws(token);
    }
}
