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

import com.example.managent.model.Subject;
import com.example.managent.service.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String listSubjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjects/form";
    }

    @PostMapping("/add")
    public String addSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Optional<Subject> subject = subjectService.getSubjectById(id);
        if (subject.isPresent()) {
            model.addAttribute("subject", subject.get());
            return "subjects/form";
        } else {
            return "redirect:/subjects";
        }
    }

    @PostMapping("/edit/{id}")
    public String editSubject(@PathVariable("id") long id, @ModelAttribute("subject") Subject subject) {
        subject.setId(id);
        subjectService.updateSubject(id, subject);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") long id) {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
}