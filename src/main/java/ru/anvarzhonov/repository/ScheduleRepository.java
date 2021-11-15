package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.models.Auditorium;
import ru.anvarzhonov.models.Lesson;
import ru.anvarzhonov.models.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // select * from schedule s inner join auditorium a on s.id_aud=a.id_aud where a.id_aud= ?
    Schedule findByAuditorium_Id(Long auditorium_id);

    @Query("select s from Schedule s where s.lesson.id = :lesson_id")
    List<Schedule> findByLessonId(Long lesson_id);

    List<Schedule> findAllByGroupId(Long id);

}
