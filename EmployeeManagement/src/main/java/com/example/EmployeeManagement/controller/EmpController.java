package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    private EmpService employeeService;

    @PostMapping
    public Employee AddEmp(@RequestBody Employee employee) {
        return employeeService.AddEmployees(employee);

    }

    @GetMapping
    public List<Employee> GetAllEmps(){
        return employeeService.getEmployee();
    }
    @GetMapping("/{id}")
    public Employee GetById(@PathVariable int id){
        return employeeService.getEmployeeByid(id);
    }
}
