package com.example.TaskManagement.service;

import com.example.TaskManagement.model.Status;
import com.example.TaskManagement.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    List<Task> getTasks();
    Task getbyId(int id);
    void deletebyid(int id);
    void Update(int id,Task task);
    List<Task> getStatus(Status status);
    List<Task> getOverdueTasks(LocalDate current);
    List<Task> getbyDueDates();
    List<Task> getbyActivity();
    List<Task> getByMonthYr(int month,int year);
}
