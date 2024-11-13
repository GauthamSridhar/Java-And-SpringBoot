package com.example.TaskManagement.repository;

import com.example.TaskManagement.model.Status;
import com.example.TaskManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByStatus(Status status);
    @Query("from Task WHERE dueDate < :current AND status = 'PENDING' AND activity='ACTIVE' ")
    List<Task> findOverdueTasks(LocalDate current);
    @Query("from Task where activity='INACTIVE'")
    List<Task> findByActivity();
    @Query(value = "select * from task_db where EXTRACT(MONTH from due_date)=:month and EXTRACT(YEAR from due_date)=:year",nativeQuery = true)
    List<Task> getAllByMonthAndYear(int month,int year);

//    Task add(Task task);
//    List<Task> getAll();
//    Task getbyId(int id);
//    void delete(int id);
//    void update(int id,Task task);
//    List<Task> getbyStatus(Status status);
//    List<Task> getOverdueTask();
//    List<Task> getbyDueDate(LocalDate date);
}
