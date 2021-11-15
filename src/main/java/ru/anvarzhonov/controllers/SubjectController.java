package ru.anvarzhonov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.models.Subject;
import ru.anvarzhonov.repository.SubjectRepository;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectRepository repository;

    public SubjectController(SubjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("subjects", repository.findAll());
        return "subject/subject";
    }

    @GetMapping("/new")
    public String showScheduleNewForm(Model model) {
        model.addAttribute("subject", new Subject());

        return "subject/subject-form";
    }

    @PostMapping("/save")
    public String saveSchedule(@ModelAttribute Subject subject) {
        repository.save(subject);

        return "redirect:/subject";
    }

    @GetMapping("/edit/{id}")
    public String editSchedule(@PathVariable(value = "id") Long id, Model model) {
        Subject subject = repository.findById(id).get();
        model.addAttribute("subject", subject);

        return "subject/subject-form";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/subject";
    }
}
