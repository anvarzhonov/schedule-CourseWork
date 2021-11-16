package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anvarzhonov.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findNameGroupById(Long id);
}
