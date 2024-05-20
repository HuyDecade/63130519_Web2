package com.example.managent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managent.model.Subject;
import com.example.managent.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(Long id, Subject subjectDetails) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setCode(subjectDetails.getCode());
            subject.setName(subjectDetails.getName());
            subject.setCredits(subjectDetails.getCredits());
            subjectRepository.save(subject);
        }
    }

    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
}