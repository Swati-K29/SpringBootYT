package com.example.demo.Repository;

import com.example.demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByDeptNameIgnoreCase(String name);

}
