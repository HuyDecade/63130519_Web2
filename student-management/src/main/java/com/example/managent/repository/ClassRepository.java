package com.example.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managent.model.Classes;

public interface ClassRepository extends JpaRepository<Classes, Long> {
}