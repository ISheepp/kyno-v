package com.codelin.controller.system.basic;

import com.codelin.bean.Menu;
import com.codelin.bean.RespBean;
import com.codelin.bean.Role;
import com.codelin.service.MenuService;
import com.codelin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/29 16:09
 */

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    // 查询所有菜单
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // 查询相应角色的菜单id
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    // 根据rid删除所有mid再插入新的mid
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
