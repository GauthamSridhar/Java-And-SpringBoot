package org.example.model;

import java.time.LocalDate;

public record Trainee(int id, String name, String location, LocalDate date_joined) {
}
