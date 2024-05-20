package com.example.managent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managent.model.Classes;
import com.example.managent.repository.ClassRepository;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Classes> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<Classes> getClassById(Long id) {
        return classRepository.findById(id);
    }

    public void addClass(Classes aClass) {
        classRepository.save(aClass);
    }

    public void updateClass(Classes aClass) {
        Optional<Classes> optionalClass = classRepository.findById(aClass.getId());
        if (optionalClass.isPresent()) {
            Classes existingClass = optionalClass.get();
            existingClass.setCode(aClass.getCode());
            existingClass.setName(aClass.getName());
            existingClass.setTeacher(aClass.getTeacher());
            existingClass.setDepartment(aClass.getDepartment());
            // Update other fields as necessary
            classRepository.save(existingClass);
        }
    }

    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }
}