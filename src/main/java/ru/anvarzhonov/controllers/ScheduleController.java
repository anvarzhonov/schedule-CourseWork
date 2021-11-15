package ru.anvarzhonov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.models.*;
import ru.anvarzhonov.repository.*;

import java.util.List;

@Controller
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    private final LessonRepository lessonRepository;
    private final TypeLessonRepository typeLessonRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final GroupRepository groupRepository;
    private final SubjectRepository subjectRepository;

    public ScheduleController(ScheduleRepository scheduleRepository,
                              LessonRepository lessonRepository,
                              TypeLessonRepository typeLessonRepository,
                              AuditoriumRepository auditoriumRepository,
                              GroupRepository groupRepository,
                              SubjectRepository subjectRepository) {
        this.scheduleRepository = scheduleRepository;
        this.lessonRepository = lessonRepository;
        this.typeLessonRepository = typeLessonRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.groupRepository = groupRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/schedule")
    public String listSchedule(Model model) {
        List<Schedule> listSchedule = scheduleRepository.findAll();
        model.addAttribute("listSchedule", listSchedule);
        return "schedule/schedule";
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

        return "schedule/scheduleForm";
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


        model.addAttribute("schedule", schedule);
        model.addAttribute("listLesson", listLessons);
        model.addAttribute("listTypeLesson", listTypeLesson);
        model.addAttribute("listAud", listAuditoriums);
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("listSubjects", listSubjects);

        return "schedule/scheduleForm";
    }

    @GetMapping("/schedule/delete/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id, Model model) {
        scheduleRepository.deleteById(id);
        return "redirect:/schedule";
    }


}
