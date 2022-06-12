package com.nihilo.Diamond.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtil {
    public JwtUtil() {
    }

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user, HttpServletRequest request) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        return access_token;
      }

     public String jwtDecoder(String authorizationHeader){
         String token = authorizationHeader.substring("Bearer ".length());
         Algorithm algorithm= Algorithm.HMAC256(secret.getBytes());
         JWTVerifier verifier= JWT.require(algorithm).build();
         DecodedJWT decodedJWT= verifier.verify(token);
         return decodedJWT.getSubject();
     }



}
