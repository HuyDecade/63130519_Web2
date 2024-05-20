package com.example.managent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.managent.model.Student;
import com.example.managent.service.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "students/form";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}