package com.example.managent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.managent.model.Score;
import com.example.managent.service.ScoreService;

import java.util.List;

@Controller
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/list")
    public String listScores(Model model) {
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);
        return "scores/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("score", new Score());
        return "scores/form";
    }

    @PostMapping("/add")
    public String addScore(@ModelAttribute("score") Score score) {
        score.setTotalScore(score.getMidtermScore() + score.getFinalScore() + score.getBonusScore());
        scoreService.saveScore(score);
        return "redirect:/scores/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Score score = scoreService.getScoreById(id).orElseThrow(() -> new IllegalArgumentException("Invalid score Id:" + id));
        model.addAttribute("score", score);
        return "scores/form";
    }

    @PostMapping("/edit/{id}")
    public String editScore(@PathVariable("id") Long id, @ModelAttribute("score") Score score) {
        score.setId(id);
        score.setTotalScore(score.getMidtermScore() + score.getFinalScore() + score.getBonusScore());
        scoreService.saveScore(score);
        return "redirect:/scores/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteScore(@PathVariable("id") Long id) {
        scoreService.deleteScore(id);
        return "redirect:/scores/list";
    }
}