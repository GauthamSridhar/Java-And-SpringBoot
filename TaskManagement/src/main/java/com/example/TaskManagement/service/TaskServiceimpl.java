package com.example.TaskManagement.service;

import com.example.TaskManagement.EXCEPTION.NullException;
import com.example.TaskManagement.EXCEPTION.RecordNotFoundException;
import com.example.TaskManagement.model.Activity;
import com.example.TaskManagement.model.Status;
import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceimpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Task addTask(Task task) {
//        task.setActivity(Activity.ACTIVE);
        if(task.getName()==null || task.getName().isEmpty() || task.getDescription()==null ||task.getDescription().isEmpty() || task.getDueDate()==null || task.getDueDate().equals(" ")||task.getStatus()==null){
            throw  new NullException("No Field Can be Null Or Have Blank Space");
        }
        return taskRepository.save(task);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Task> getTasks() {
        List<Task> taskList=taskRepository.findAll();
        return taskList.stream().filter(t->t.getActivity()==Activity.ACTIVE).collect(Collectors.toList());
    }

    @Override
    public Task getbyId(int id) {

        return taskRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Task with ID "+id+ " Not Found"));

    }

    @Override
    public void deletebyid(int id) {
        taskRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Task with ID "+id+ " Not Found"));
        Task task=getbyId(id);
        task.setActivity(Activity.INACTIVE);
        taskRepository.save(task);
    }

    @Override
    public void Update(int id, Task task) {
        taskRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Task with ID "+id+ " Not Found"));
        Task task1 =getbyId(id);
        if(task.getName()!=null && !task.getName().isEmpty()){
            task1.setName(task.getName());
        }
        else {
            throw new NullException("Null and Blank Value Not Allowed for Name Field");
        }
        if(task.getDueDate()!=null && !(task.getDueDate().equals(" "))){
            task1.setDueDate(task.getDueDate());
        }
        else {
            throw new NullException("Null and Blank Value Not Allowed for Due Date Field");
        }
        if(task.getDescription()!=null && !(task.getDescription().isEmpty())){
            task1.setDescription(task.getDescription());
        }
        else {
            throw new NullException("Null and Blank Value Not Allowed for Description Field");
        }
        if(task.getStatus()!=null && !(task.getStatus().equals(" "))){
            task1.setStatus(task.getStatus());
        }
        else {
            throw new NullException("Null and Blank Value Not Allowed for Status Field");
        }

        taskRepository.save(task1);
    }

    @Override
    public List<Task> getStatus(Status status) {
        List<Task> taskList=taskRepository.findByStatus(status);
        return taskList.stream().filter(t->t.getActivity()==Activity.ACTIVE).collect(Collectors.toList());
    }


    @Override
    public List<Task> getOverdueTasks(LocalDate current) {
        return taskRepository.findOverdueTasks(current);
    }

    @Override
    public List<Task> getbyDueDates() {
        List<Task> taskList =taskRepository.findAll();
        return taskList.stream().filter(t->t.getActivity()==Activity.ACTIVE).sorted(Comparator.comparing(t->t.getDueDate())).collect(Collectors.toList());
    }

    @Override
    public List<Task> getbyActivity() {
        return taskRepository.findByActivity();
    }

    @Override
    public List<Task> getByMonthYr(int month, int year) {
        return taskRepository.getAllByMonthAndYear(month, year);
    }
}
