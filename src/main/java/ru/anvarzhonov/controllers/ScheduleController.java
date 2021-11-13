package ru.anvarzhonov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.models.*;
import ru.anvarzhonov.repository.*;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private SubjectRepository subjectRepository;


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
        List<Subject> listSubjects = subjectRepository.findAll();


        model.addAttribute("schedule", new Schedule());
        model.addAttribute("listLesson", listLessons);
        model.addAttribute("listTypeLesson", listTypeLesson);
        model.addAttribute("listAud", listAuditoriums);
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("listSubjects", listSubjects);

        return "scheduleForm";
    }

    @PostMapping("/schedule/save")
    public String saveSchedule(@ModelAttribute Schedule schedule) {
        scheduleRepository.save(schedule);

        return "redirect:/schedule";
    }

    @GetMapping("/schedule/edit/{id}")
    public String editSchedule(@PathVariable(value = "id") Long id, Model model) {
        Schedule schedule = scheduleRepository.findById(id).get();

        List<Lesson> listLessons = lessonRepository.findAll();
        List<TypeLesson> listTypeLesson = typeLessonRepository.findAll();
        List<Auditorium> listAuditoriums = auditoriumRepository.findAll();
        List<Group> listGroups = groupRepository.findAll();
        List<Subject> listSubjects = subjectRepository.findAll();


        model.addAttribute("listLesson", listLessons);
        model.addAttribute("listTypeLesson", listTypeLesson);
        model.addAttribute("listAud", listAuditoriums);
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("schedule", schedule);
        model.addAttribute("listSubjects", listSubjects);

        return "scheduleForm";
    }
    @GetMapping("/schedule/delete/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id, Model model) {
        scheduleRepository.deleteById(id);
        return "redirect:/schedule";
    }




}
