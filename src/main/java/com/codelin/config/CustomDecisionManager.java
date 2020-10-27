package com.codelin.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author ISheep
 * @create 2020/10/27 10:00
 * 从上一个MyFilter类中找到角色后再进入这个类
 * 判断当前用户是否具备访问的权限
 */

@Component
public class CustomDecisionManager implements AccessDecisionManager {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    // Collection里保存需要的角色，authentication里保存的是用户的角色
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                // 判断有没有登录
                if (authentication instanceof AnonymousAuthenticationToken) {
                    // 如果当前用户是匿名实例，说明没登陆
                    throw new AccessDeniedException("尚未登录，请登录");
                } else {
                    return;
                }
            }
            // 获取当前登录用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }
}
