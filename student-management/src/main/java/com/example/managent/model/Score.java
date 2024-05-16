package com.example.managent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes aClass;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private double midtermScore;

    private double finalScore;

    private double bonusScore;

    private double totalScore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classes getaClass() {
		return aClass;
	}

	public void setaClass(Classes aClass) {
		this.aClass = aClass;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public double getMidtermScore() {
		return midtermScore;
	}

	public void setMidtermScore(double midtermScore) {
		this.midtermScore = midtermScore;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	public double getBonusScore() {
		return bonusScore;
	}

	public void setBonusScore(double bonusScore) {
		this.bonusScore = bonusScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

    // Getters and setters
    
}