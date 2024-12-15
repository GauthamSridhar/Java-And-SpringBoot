package org.example.Repository;

import org.example.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository {
    public Trainee save(Trainee trainee);
    public Optional<Trainee> getTrainee(int id);
    public List<Trainee> getAllTrainees();
    public void deleteTrainee(int id);
}
