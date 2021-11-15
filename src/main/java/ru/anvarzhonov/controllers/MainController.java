package ru.anvarzhonov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.anvarzhonov.repository.*;

@Controller
public class MainController {

    @Autowired
    ScheduleRepository scheduleRepo;
    @Autowired
    private LessonRepository lessonRepo;
    @Autowired
    private TypeLessonRepository typeLessonRepo;
    @Autowired
    private AuditoriumRepository auditoriumRepo;
    @Autowired
    private GroupRepository groupRepo;

    @GetMapping("/index")
    public String showIndex(Model model) {

        model.addAttribute("listSchedule",scheduleRepo.findAll());

        return "index2";
    }


}
