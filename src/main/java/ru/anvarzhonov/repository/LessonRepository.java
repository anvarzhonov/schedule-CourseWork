package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.models.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {

    // JPQL
//    @Query(value = "select l from Lesson l where l.name = ?1")
//    Lesson getLessonByName( String name);
//
//    Lesson findByNameContaining(String name);


}
