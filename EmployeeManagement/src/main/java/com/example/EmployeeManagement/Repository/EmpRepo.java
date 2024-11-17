package com.example.EmployeeManagement.Repository;

import com.example.EmployeeManagement.model.Employee;

import java.util.List;

public interface EmpRepo {
    public Employee AddEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getEmployees();
}
