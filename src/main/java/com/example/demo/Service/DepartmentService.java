package com.example.demo.Service;

import com.example.demo.Entity.Department;

import java.util.List;

public interface DepartmentService
{
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDeptById( Integer id);

    void deleteDeptById(Integer id);

    Department updateDept(Integer id, Department dept);

    Department getDeptByName( String name);
}
