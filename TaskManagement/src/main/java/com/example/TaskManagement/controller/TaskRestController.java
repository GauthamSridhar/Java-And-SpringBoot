package com.example.TaskManagement.controller;

import com.example.TaskManagement.model.Status;
import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
//@RequestMapping("/api/v1/task")
public class TaskRestController {
    @Autowired
    private TaskService taskService;

    @GetMapping("get/{id}")
    public Task getByID(@PathVariable("id") int id)
    {
        return taskService.getbyId(id);
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task){
        taskService.addTask(task);
        return task;
    }

    @GetMapping("/get")
    public List<Task> getAll(){
        return taskService.getTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> getStatus(@PathVariable("status")Status status){
        return taskService.getStatus(status);
    }
    @GetMapping("/over")
    public List<Task> getOverdue(){
        return taskService.getOverdueTasks(LocalDate.now());
    }

    @GetMapping("/date")
    public List<Task> getDuDate(){
        return taskService.getbyDueDates();
    }

    @PutMapping("/del/{id}")
    public void deleteByID(@PathVariable("id") int id){
        taskService.deletebyid(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id,@RequestBody Task task){
        taskService.Update(id,task);
    }

    @GetMapping("/del")
    public List<Task> getAct(){
        return taskService.getbyActivity();
    }
    @GetMapping("/mthYr/{month}/year/{year}")
    public List<Task> getmnthyr(@PathVariable("month") int month,@PathVariable("year") int year){
        return taskService.getByMonthYr(month, year);
    }
}
