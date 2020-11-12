package com.codelin.mapper;

import com.codelin.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer i);

    // TODO: 2020/11/2 未使用sql代替存储过程
    void addDep(Department department);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithoutChildren();
}