package org.example.Service;

import org.example.model.Trainee;
import org.example.Repository.TraineeRepoImpl;
import org.example.Repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepoImpl traineeRepository;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        Optional<Trainee> traineeOptional=traineeRepository.getTrainee(trainee.id());
        if(traineeOptional.isPresent()){
            throw new RuntimeException("Book Exists");
        }
        else {
        return traineeRepository.save(trainee);
    }
    }

    @Override
    public Trainee getTraineeById(int id) {
        Optional<Trainee> trainee = traineeRepository.getTrainee(id);
        if (trainee.isPresent()) {
            return trainee.get();
        }
        else {
            throw new RuntimeException("Trainee Does not Exist");
        }
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepository.getAllTrainees();

    }

    @Override
    public void deleteTraineeById(int id) {
        Optional<Trainee> trainee = traineeRepository.getTrainee(id);
        if (trainee.isPresent()) {
            traineeRepository.deleteTrainee(id);
        }
        else {
            throw new RuntimeException("Trainee Does not Exist");
        }

    }
}

