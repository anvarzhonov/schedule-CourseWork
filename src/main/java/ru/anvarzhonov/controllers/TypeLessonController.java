package ru.anvarzhonov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.models.*;
import ru.anvarzhonov.repository.TypeLessonRepository;

import java.util.List;

@Controller
@RequestMapping("/type-lesson")
public class TypeLessonController {
    @Autowired
    private TypeLessonRepository repository;

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("typeLessons", repository.findAll());
        return "type_lesson/type_lesson";
    }

    @GetMapping("/new")
    public String showScheduleNewForm(Model model) {
        model.addAttribute("typeLesson", new TypeLesson());

        return "type_lesson/type_lesson-form";
    }

    @PostMapping("/save")
    public String saveSchedule(@ModelAttribute TypeLesson typeLesson) {
        repository.save(typeLesson);

        return "redirect:/type-lesson";
    }

    @GetMapping("/edit/{id}")
    public String editSchedule(@PathVariable(value = "id") Long id, Model model) {
        TypeLesson typeLesson = repository.findById(id).get();
        model.addAttribute("typeLesson", typeLesson);

        return "type_lesson/type_lesson-form";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/type-lesson";
    }

}
