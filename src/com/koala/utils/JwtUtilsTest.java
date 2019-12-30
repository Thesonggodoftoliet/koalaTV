package com.koala.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    @Test
    void createToken() {
        String code ="645876";
        int expire = 10;
        Date now = new Date();
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withIssuer("LYF").withClaim("code",code).withExpiresAt(now).sign(algorithm);
            System.out.println("token "+token);
        }catch (JWTCreationException e){

        }
    }

    @Test
    void verifyToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb2RlIjoiNjQ1ODc2IiwiaXNzIjoiTFlGIiwiZXhwIjoxNTc3NzE1Njg4fQ.KmGT_IxPpbHS8OjXrK5kunc2NhhgDGDFk1YNp6VBF98";
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("LYF").acceptExpiresAt(120).build();
            DecodedJWT jwt = verifier.verify(token);
        }catch (JWTVerificationException e){
            System.out.println("失效");
        }
    }

    @Test
    void decodeTokenToS() {
    }
}