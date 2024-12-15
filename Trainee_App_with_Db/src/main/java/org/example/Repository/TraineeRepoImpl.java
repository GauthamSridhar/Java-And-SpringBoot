package org.example.Repository;

import org.example.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TraineeRepoImpl implements TraineeRepository {
    @Autowired
    Connection connection;

    @Override
    public Trainee save(Trainee trainee) {
        String sql = "insert into trainee(name,location,date_joined) values('%s', '%s', '%s')".formatted(trainee.name(), trainee.location(), trainee.date_joined().toString());
        try {
            Statement statement = connection.createStatement();
            int rowcount = statement.executeUpdate(sql);
            System.out.println(rowcount + " rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainee;
    }

    @Override
    public Optional<Trainee> getTrainee(int id) {

        String sql = "Select * from trainee where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();

                return Optional.of(new Trainee(id, name, location, joinedDate));
            } else {
                // Handle the case where no trainee is found
                return Optional.empty();
            }

        } catch (SQLException e) {
            // Ideally, log the exception or handle it appropriately
            throw new RuntimeException("Error retrieving trainee with id " + id, e);
        }
    }

    @Override
    public List<Trainee> getAllTrainees() {

        String sql = "Select * from trainee";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Trainee> trainees = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String location = resultSet.getString("Location");
                LocalDate joinedDate = resultSet.getDate("Date_Joined").toLocalDate();
                Trainee trainee = new Trainee(id, name, location, joinedDate);
                trainees.add(trainee);
            }
            return trainees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTrainee(int id) {

        String sql = "delete from trainee where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
