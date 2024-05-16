package com.example.managent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.managent.model.Classes;
import com.example.managent.service.ClassService;

@Controller
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public String listClasses(Model model) {
        List<Classes> classes = classService.getAllClasses();
        model.addAttribute("classes", classes);
        return "class/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("class", new Classes());
        return "class/form";
    }

    @PostMapping("/add")
    public String addClass(@ModelAttribute("class") Classes aClass) {
        classService.addClass(aClass);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Optional<Classes> aClass = classService.getClassById(id);
        if (aClass.isPresent()) {
            model.addAttribute("class", aClass.get());
            return "class/form";
        } else {
            return "redirect:/classes";
        }
    }

    @PostMapping("/edit/{id}")
    public String editClass(@PathVariable("id") long id, @ModelAttribute("class") Classes classes) {
    	classes.setId(id);
        classService.updateClass( classes);
        return "redirect:/classes";
    }

    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable("id") long id) {
        classService.deleteClassById(id);
        return "redirect:/classes";
    }
}