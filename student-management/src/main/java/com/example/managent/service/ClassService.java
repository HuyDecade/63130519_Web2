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

    public void addClass(Classes classes) {
        classRepository.save(classes);
    }

    public void updateClass(Classes classes) {
        classRepository.save(classes);
    }

    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }

	public void deleteClassById(long id) {
		// TODO Auto-generated method stub
		
	}
}