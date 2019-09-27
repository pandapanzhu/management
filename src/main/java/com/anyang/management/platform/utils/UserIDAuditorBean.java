package com.anyang.management.platform.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 从springSecurity中，拿到登录人信息
 * 主要是需要放在createBy 和modifyBy字段中
 */
@Configuration
@Component
public class UserIDAuditorBean implements AuditorAware<String> {
    public Optional<String> getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return null;
        }
        Object principal = ctx.getAuthentication().getPrincipal();
        if (principal.getClass().isAssignableFrom(String.class)) {
            return Optional.of(principal.toString()) ;
        } else {
            return null;
        }
    }
}