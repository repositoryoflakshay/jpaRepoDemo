package com.example.jparepodemo.controller;

import com.example.jparepodemo.entity.Employee;
import com.example.jparepodemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId) {
        return employeeService.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee with id " + employeeId + " not found"));
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.save(employee);
        return updateEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee addEmployee = employeeService.save(employee);
        return addEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Optional<Employee> tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee not found");
        }
        else
            employeeService.deleteById(employeeId);
        return "Employee with employeeId "+employeeId+" has been deleted";
    }
}
