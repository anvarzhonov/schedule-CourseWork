package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
