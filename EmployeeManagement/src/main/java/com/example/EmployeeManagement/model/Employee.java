package com.example.EmployeeManagement.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Employee {
    private int id;
    private String name;
    private String department;
}
