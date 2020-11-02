package com.codelin.service;

import com.codelin.bean.Role;
import com.codelin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/10/29 16:10
 */

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;


    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
