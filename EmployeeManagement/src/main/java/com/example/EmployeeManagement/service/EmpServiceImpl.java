package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.Repository.EmpRepo;
import com.example.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpRepo employeeRepository;

    @Override
    public Employee AddEmployees(Employee employee) {
        return employeeRepository.AddEmployee(employee);
    }

    @Override
    public Employee getEmployeeByid(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.getEmployees();
    }
}
