package com.example.managent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managent.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}