package com.example.TaskManagement.service;

import com.example.TaskManagement.EXCEPTION.RecordNotFoundException;
import com.example.TaskManagement.model.Activity;
import com.example.TaskManagement.model.Status;
import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TraineeServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceimpl taskService;

    @Test
    void getTaskById() {

        // Given
        var id = 1;
        var invalidId = 100;
        Task task = new Task(1,"ijdsnfdijn","ofjnsjnf", LocalDate.now(), Status.PENDING, Activity.ACTIVE);

        // When
        Mockito.when(taskRepository.findById(id))
                .thenReturn(Optional.of(task));

        Mockito.when(taskRepository.findById(invalidId))
                .thenThrow(new RecordNotFoundException("Task with ID "+invalidId+ " Not Found"));

        Assertions.assertDoesNotThrow(()->taskService.getbyId(id));

        Assertions.assertThrows(RecordNotFoundException.class,()->taskService.getbyId(invalidId));


    }
}

