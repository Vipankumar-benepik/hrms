//package com.vipan.hrms.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//@Component
//public class JwtUtils {
//    private static final String jwtSecret = "MySecretKey#@12345";
//
//    public String generateToken(String username) {
//        int jwtExpirationMs = 3600000;
//        return Jwts.builder()
//                .subject(username)
//                .issuedAt(new Date())
//                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public String getUsernameFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(jwtSecret).build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//    }
//
//    public boolean validateJwtToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).build().parseSignedClaims(token);
//            return true;
//        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
//
//    private static SecretKey getSigningKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret); // Decode the Base64-encoded secret
//        return Keys.hmacShaKeyFor(keyBytes); // Generate HMAC-SHA key
//    }
//}
