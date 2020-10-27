package com.codelin.config;

import com.codelin.bean.Menu;
import com.codelin.bean.Role;
import com.codelin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/27 9:39
 * 这个类的功能：根据根据用户请求的地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher(); //url匹配工具
    @Override
    // Collection：当前请求需要的角色
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 拿到当前请求的地址
        String url = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            // 第一个参数是规则
            if (antPathMatcher.match(menu.getUrl(), url)) {
                // 如果匹配上了
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str); // 传递的是一个数组
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN"); // 表示凡是没有匹配上的要登录之后再访问
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
