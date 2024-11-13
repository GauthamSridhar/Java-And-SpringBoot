package com.example.TaskManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="task_db")
public class Task {
    @Id//Primary
//    @GeneratedValue(strategy = GenerationType.AUTO)//Auto Increament
    private int id;
    private String name;
    private String description;
//    @JsonFormat(pattern = "dd/MMM/YYYY")
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Activity activity;
}
