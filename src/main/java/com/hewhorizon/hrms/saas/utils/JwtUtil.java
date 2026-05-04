package com.hewhorizon.hrms.saas.utils;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public Jwt getJwt() {
        return (Jwt) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public Long getTenantId() {
        Jwt jwt = getJwt();
        return jwt.getClaim("tenantId");
    }

    public Long getUserId() {
        Jwt jwt = getJwt();
        return jwt.getClaim("userId");
    }

    public String getSubject() {
        return getJwt().getSubject();
    }
}