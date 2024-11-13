package org.example.Service;

import org.example.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);
    Trainee getTraineeById(int id);
    List<Trainee> getAllTrainees();
    void deleteTraineeById(int id);
}

