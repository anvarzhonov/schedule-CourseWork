package ru.anvarzhonov.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.anvarzhonov.models.Schedule;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void saveAll() {


        Schedule schedule = Schedule.builder()
                .weekdayId(2L)
                .build();

    }
}