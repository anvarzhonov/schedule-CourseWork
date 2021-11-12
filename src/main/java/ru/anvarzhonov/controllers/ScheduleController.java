package ru.anvarzhonov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.models.*;
import ru.anvarzhonov.repository.*;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private TypeLessonRepository typeLessonRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private GroupRepository groupRepository;


    @GetMapping("/schedule")
    public String listSchedule(Model model) {
        List<Schedule> listSchedule = scheduleRepository.findAll();
        model.addAttribute("listSchedule", listSchedule);
        return "schedule";
    }

    @GetMapping("/schedule/new")
    public String showScheduleNewForm(Model model) {
        List<Lesson> listLessons = lessonRepository.findAll();
        List<TypeLesson> listTypeLesson = typeLessonRepository.findAll();
        List<Auditorium> listAuditoriums = auditoriumRepository.findAll();
        List<Group> listGroups = groupRepository.findAll();


        model.addAttribute("schedule", new Schedule());
        model.addAttribute("listLesson", listLessons);
        model.addAttribute("listTypeLesson", listTypeLesson);
        model.addAttribute("listAud", listAuditoriums);
        model.addAttribute("listGroups", listGroups);


        return "scheduleForm";
    }




}
