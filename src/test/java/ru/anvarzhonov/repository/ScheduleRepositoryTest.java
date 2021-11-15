package ru.anvarzhonov.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.anvarzhonov.models.Schedule;

import java.util.List;

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

    @Test
    public void findAllByIdGroup() {
        List<Schedule> allByGroupId = scheduleRepository.findAllByGroupId(2L);
        System.out.println(allByGroupId);
    }
}