package com.codelin.service;

import com.codelin.bean.Employee;
import com.codelin.bean.RespPageBean;
import com.codelin.mapper.EmployeeMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ISheep
 * @create 2020/11/3 10:42
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    // 处理数字的format，计算结果保留两位小数
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployByPage(Integer page, Integer size, String keyword) {
        // TODO: 2020/11/3 不理解
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployByPage(page, size, keyword);
        Long total = employeeMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        // 处理合同的日期：起始日期相减
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month =
                (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        return employeeMapper.insertSelective(employee);
    }

    public Integer maxWorkID() {
        return employeeMapper.getMaxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }
}
