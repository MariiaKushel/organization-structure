package com.mariiakushel.task.controller;

import com.mariiakushel.task.enumeration.UserRole;
import com.nimbusds.jose.shaded.json.JSONArray;
import org.springframework.security.oauth2.jwt.Jwt;

public class Jwts {
    public static final Jwt EMPLOYEE_JWT;
    public static final Jwt HEAD_JWT;
    public static final Jwt DIRECTOR_JWT;
    public static final Jwt ADMIN_JWT;

    static {
        EMPLOYEE_JWT = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "all")
                .claim("employee_id", 1L)
                .claim("user_name", "100000001")
                .claim("authorities", new JSONArray().appendElement(UserRole.ROLE_EMPLOYEE.name()))
                .build();
        HEAD_JWT = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "all")
                .claim("employee_id", 1L)
                .claim("user_name", "100000001")
                .claim("authorities", new JSONArray().appendElement(UserRole.ROLE_HEAD.name()))
                .build();
        DIRECTOR_JWT = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "all")
                .claim("employee_id", 1L)
                .claim("user_name", "100000001")
                .claim("authorities", new JSONArray().appendElement(UserRole.ROLE_DIRECTOR.name()))
                .build();
        ADMIN_JWT = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("scope", "all")
                .claim("employee_id", 1L)
                .claim("user_name", "100000001")
                .claim("authorities", new JSONArray().appendElement(UserRole.ROLE_ADMIN.name()))
                .build();
    }
}
