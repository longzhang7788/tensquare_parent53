package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * Created by aheadx on 2020/4/18.
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1ODcxNzQ1ODYsImV4cCI6MTU4NzE3NDY0Niwicm9sZSI6ImFkbWluIn0._mOMbAPchBpHqTm3jq5nKVudqNR3cKutnY0HVjYjBU8")
                .getBody();
        System.out.println("用户id: "+claims.getId());
        System.out.println("用户名："+claims.getSubject());
        System.out.println("登录时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色："+claims.get("role"));

    }
}
