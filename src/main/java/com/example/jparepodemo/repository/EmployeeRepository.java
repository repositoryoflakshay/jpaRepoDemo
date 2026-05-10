package com.example.jparepodemo.repository;

import com.example.jparepodemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // Provides free CRUD methods... No need for implementation class
}
