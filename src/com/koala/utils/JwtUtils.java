package com.koala.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

/**
 * 对Token的管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public class JwtUtils {
    /**
      *根据UserId创建Token.
      * @param userid int
      * @return java.lang.String
      **/
    public static String createToken(int userid){
        try{
            Calendar calendar = Calendar.getInstance();
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withIssuer("LYF").withClaim("userid",userid).withClaim("time",calendar.getTimeInMillis()).sign(algorithm);
            System.out.println("token"+token);
            return token;
        }catch (JWTCreationException e){

        }
        return null;
    }

    /**
      *隐藏验证码.
      * @param code String
      * @return java.lang.String
      **/
    public static String createToken(String code){
        try {
            Calendar calendar = Calendar.getInstance();
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withIssuer("LYF").withClaim("code",code).withClaim("time",calendar.getTimeInMillis()).sign(algorithm);
            return token;
        }catch (JWTCreationException e){

        }
        return null;

    }

    /**
      *验证Token 失败返回0.
      * @param token String
      * @return int
      **/
    public static int verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("LYF").build();
            DecodedJWT jwt = verifier.verify(token);
            return 1;
        }catch (JWTVerificationException e){

        }
        return 0;
    }

    /**
      *Token反解码成UserId.
      * @param token String
      * @return int
      **/
    public static int decodeToken(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            Claim claim = jwt.getClaim("userid");
            return claim.asInt();
        }catch (JWTDecodeException e){

        }
        return -1;
    }
}
