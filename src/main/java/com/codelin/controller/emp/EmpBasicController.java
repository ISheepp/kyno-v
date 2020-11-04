package com.codelin.controller.emp;

import com.codelin.bean.Employee;
import com.codelin.bean.RespBean;
import com.codelin.bean.RespPageBean;
import com.codelin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ISheep
 * @create 2020/11/3 10:11
 */

@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    // 员工数据量大，分页处理
    // 默认第一个，每页10条记录
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size, String keyword) {
        return employeeService.getEmployByPage(page, size, keyword);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

}
