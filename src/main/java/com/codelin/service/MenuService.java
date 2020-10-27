package com.codelin.service;

import com.codelin.bean.Hr;
import com.codelin.bean.Menu;
import com.codelin.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/26 13:53
 */

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    // getPrincipal()当前登录的用户对象,再强制转型,再获取id
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    // @Cacheable 因为菜单项是几乎不变的，每次都请求不划算，做成缓存
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
