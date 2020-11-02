package com.codelin.controller.system.basic;

import com.codelin.bean.Department;
import com.codelin.bean.RespBean;
import com.codelin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ISheep
 * @create 2020/11/1 18:47
 */

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    // 一次性拿到所有的部门数据(部门数据一般不会很多,如果很多,|建议使用懒加载),使用递归
    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department department) {
        departmentService.addDep(department);
        if (department.getResult() == 1) {
            return RespBean.ok("添加成功", department);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespBean.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
