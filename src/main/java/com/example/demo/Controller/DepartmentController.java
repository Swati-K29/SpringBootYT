package com.example.demo.Controller;

import com.example.demo.Entity.Department;
import com.example.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.DefaultPersistenceDelegate;
import java.util.List;

@RestController
public class DepartmentController
{   @Autowired
    private DepartmentService deptService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department dept){
         return deptService.saveDepartment(dept);
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return deptService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDeptById(@PathVariable Integer id){
        return deptService.getDeptById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDeptById(@PathVariable Integer id){
        deptService.deleteDeptById(id);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDept(@PathVariable("id") Integer id,
                                 @RequestBody Department dept){
        return deptService.updateDept(id,dept);
    }

    @GetMapping("departments/name/{name}")
    public Department getDeptByName(@PathVariable String name){
        return deptService.getDeptByName(name);
    }
}
