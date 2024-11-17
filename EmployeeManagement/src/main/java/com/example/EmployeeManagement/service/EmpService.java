package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.model.Employee;

import java.util.List;

public interface EmpService {
    public Employee AddEmployees(Employee employee);
    public Employee getEmployeeByid(int id);
    public List<Employee> getEmployee();
}
