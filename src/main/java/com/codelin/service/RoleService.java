package com.codelin.service;

import com.codelin.bean.Menu;
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

}
