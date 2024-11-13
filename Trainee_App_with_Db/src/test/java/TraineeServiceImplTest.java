import org.example.model.Trainee;
import org.example.Repository.TraineeRepoImpl;
import org.example.Service.TraineeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TraineeServiceImplTest {

    @InjectMocks
    private TraineeServiceImpl traineeService;

    @Mock
    private TraineeRepoImpl traineeRepository;

    // Test for getAllTrainees()
    @Test
    public void testGetAllTrainees() {
        // Given
        List<Trainee> trainees = new ArrayList<>();
        trainees.add(new Trainee(1, "John Doe", "New York", LocalDate.of(2023, 1, 15)));
        trainees.add(new Trainee(2, "Jane Smith", "Los Angeles", LocalDate.of(2023, 2, 20)));

        // When
        when(traineeRepository.getAllTrainees()).thenReturn(trainees);

        // Then
        assertEquals(trainees, traineeService.getAllTrainees());
        verify(traineeRepository, times(1)).getAllTrainees();
    }

    // Test for getTraineeById()
    @Test
    public void testGetTraineeById() {
        // Given
        Trainee trainee = new Trainee(1, "John Doe", "New York", LocalDate.of(2023, 1, 15));

        // When
        when(traineeRepository.getTrainee(1)).thenReturn(Optional.of(trainee));

        // Then
        assertEquals(trainee, traineeService.getTraineeById(1));
        verify(traineeRepository, times(1)).getTrainee(1);
    }

    // Test for saveTrainee()
    @Test
    public void testSaveTrainee() {
        // Given
        Trainee trainee = new Trainee(1, "John Doe", "New York", LocalDate.of(2023, 1, 15));

        // When
        when(traineeRepository.getTrainee(1)).thenReturn(Optional.empty());
        when(traineeRepository.save(trainee)).thenReturn(trainee);

        // Then
        assertEquals(trainee, traineeService.saveTrainee(trainee));
        verify(traineeRepository, times(1)).save(trainee);
    }

    // Test for deleteTrainee()
    @Test
    public void testDeleteTrainee() {
        // Given
        Trainee trainee = new Trainee(1, "John Doe", "New York", LocalDate.of(2023, 1, 15));

        // When
        when(traineeRepository.getTrainee(1)).thenReturn(Optional.of(trainee));
        doNothing().when(traineeRepository).deleteTrainee(1);

        // Then
        assertDoesNotThrow(() -> {
            traineeService.deleteTraineeById(1);
        });
        verify(traineeRepository, times(1)).deleteTrainee(1);
    }

}

