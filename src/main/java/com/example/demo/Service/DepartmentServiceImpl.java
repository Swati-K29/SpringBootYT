package com.example.demo.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository deptRepository;
    @Override
    public Department saveDepartment(Department department) {
        return deptRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return deptRepository.findAll();
    }

    @Override
    public Department getDeptById(Integer id) {
        return deptRepository.findById(id).get();
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptRepository.deleteById(id);
    }

    @Override
    public Department updateDept(Integer id, Department dept) {
        Department deptDB = deptRepository.findById(id).get();
        if(Objects.nonNull(dept.getDeptAddress())
        && !"".equalsIgnoreCase(dept.getDeptAddress())){
            deptDB.setDeptAddress(dept.getDeptAddress());
        }
        if(Objects.nonNull(dept.getDeptName())
                && !"".equalsIgnoreCase(dept.getDeptName())){
            deptDB.setDeptName(dept.getDeptName());
        }
        if(Objects.nonNull(dept.getDeptCode())
                && !"".equalsIgnoreCase(dept.getDeptCode())){
            deptDB.setDeptCode(dept.getDeptCode());
        }
        return deptRepository.save(deptDB);
    }

    @Override
    public Department getDeptByName(String name) {
        return deptRepository.findByDeptNameIgnoreCase(name);
    }
}
