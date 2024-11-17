package com.example.EmployeeManagement.Repository;

import com.example.EmployeeManagement.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpRepoImpl implements EmpRepo{
    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee AddEmployee(Employee employee) {
        Employee employee1=new Employee();
        employee1.setId(employee.getId());
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employees.add(employee1);
        return employee1;
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if(employee.getId()==id)
                return employee;
        }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}
