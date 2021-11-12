package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anvarzhonov.models.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
