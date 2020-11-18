package com.codelin.service;

import com.codelin.bean.Hr;
import com.codelin.bean.Menu;
import com.codelin.mapper.MenuMapper;
import com.codelin.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/26 13:53
 */

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    // getPrincipal()当前登录的用户对象,再强制转型,再获取id
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    // @Cacheable 因为菜单项是几乎不变的，每次都请求不划算，做成缓存
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        // todo 不理解length
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result == mids.length;
    }
}
