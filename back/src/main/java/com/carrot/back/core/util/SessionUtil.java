package com.carrot.back.core.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class SessionUtil {

    public static String getSessionId() {
        // 현재 로그인 된 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof Jwt jwt) {
            return (String) jwt.getClaims().get("sub");
        } else {
            return "system";
        }
    }
}
