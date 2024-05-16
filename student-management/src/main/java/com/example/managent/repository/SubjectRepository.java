package com.example.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managent.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}