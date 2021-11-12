package ru.anvarzhonov;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.anvarzhonov.repository.TypeLessonRepository;

@SpringBootTest
public class TypeLessonTest {
    @Autowired
    TypeLessonRepository typeLessonRepository;


    @Test
    public void showAll(){
        System.out.println(typeLessonRepository.findAll());
    }

    @Test
    public void updateById() {
        typeLessonRepository.updateNameById(1L, "Лекция");
    }
}
