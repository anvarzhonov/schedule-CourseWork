package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.anvarzhonov.models.TypeLesson;

import javax.transaction.Transactional;

public interface TypeLessonRepository extends JpaRepository<TypeLesson, Long> {

    @Modifying
    @Transactional
    @Query ("update TypeLesson t set t.nameType = :name where t.id = :id")
    void updateNameById(Long id, String name);
}
