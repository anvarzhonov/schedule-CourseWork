package ru.anvarzhonov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.anvarzhonov.models.Group;
import ru.anvarzhonov.repository.*;

@Controller
public class MainController {

    @Autowired
    ScheduleRepository scheduleRepo;

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/schedule/{id}")
    public String showIndex(@PathVariable("id") Long id, Model model) {
        model.addAttribute("listSchedule",scheduleRepo.findAllByGroupId(id));
        model.addAttribute("group", groupRepository.findNameGroupById(id));
        return "index2";
    }

    @GetMapping("/homepage")
    public String homePage(Model model) {
        model.addAttribute("groups", groupRepository.findAll());

        return "homePage";
    }




}
