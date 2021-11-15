package ru.anvarzhonov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.models.Group;
import ru.anvarzhonov.repository.GroupRepository;

@Controller
@RequestMapping("/groups")
public class GroupsController {
    private final GroupRepository repository;

    public GroupsController(GroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("groups", repository.findAll());
        return "groups/groups";
    }

    @GetMapping("/new")
    public String showScheduleNewForm(Model model) {
        model.addAttribute("group", new Group());

        return "groups/groups-form";
    }

    @PostMapping("/save")
    public String saveSchedule(@ModelAttribute Group group) {
        repository.save(group);

        return "redirect:/groups";
    }

    @GetMapping("/edit/{id}")
    public String editSchedule(@PathVariable(value = "id") Long id, Model model) {
        Group group = repository.findById(id).get();
        model.addAttribute("group", group);

        return "groups/groups-form";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/groups";
    }
}
