package com.example.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}