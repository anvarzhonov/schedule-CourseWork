package ru.anvarzhonov;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.anvarzhonov.models.Lesson;
import ru.anvarzhonov.models.Schedule;
import ru.anvarzhonov.repository.LessonRepository;
import ru.anvarzhonov.repository.ScheduleRepository;

import java.util.List;

@SpringBootTest
class MainTests {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private LessonRepository lessonRepository;

	@Test
	public void saveLesson () {
		Lesson lesson = Lesson.builder()
				.beginLesson("10:50")
				.endLesson("14:20")
				.build();

		lessonRepository.save(lesson);
	}
	@Test
	public void findAll() {
		List<Schedule> all = scheduleRepository.findAll();

		System.out.println(all);
	}

	@Test
	public void findById() {
		Schedule byAuditorium_id = scheduleRepository.findByAuditorium_Id(5L);
		System.out.println(byAuditorium_id);
	}

//	@Test
//	public void getLessonByName() {
//
//		System.out.println(lessonRepository.getLessonByName("Математика"));
//	}
//
//	@Test
//	public void printFindLessonByNameContaining () {
//
//		System.out.println(lessonRepository.findByNameContaining("Р"));
//	}

	@Test
	public void ll() {
		List<Schedule> byLessonId = scheduleRepository.findByLessonId(1L);
		System.out.println(byLessonId);
	}

}
