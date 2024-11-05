package com.carrot.back.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // 현재 로그인 된 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof Jwt jwt) {
            return Optional.of((String) jwt.getClaims().get("sub")); // 또는 다른 적절한 claim 키
        } else {
            return Optional.of("system"); // 기본값으로 시스템 사용자 설정
        }
    }
}
