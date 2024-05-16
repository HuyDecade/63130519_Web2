package com.example.managent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managent.model.Score;
import com.example.managent.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    public Optional<Score> findById(Long id) {
        return scoreRepository.findById(id);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteById(Long id) {
        scoreRepository.deleteById(id);
    }
}