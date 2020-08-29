package com.exam.system.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long testid;
	private long examid;
	private String username;
	private String date;
	private long totalQuestion;
	private int correct;
	private int wrong;
	private String result;

	public long getTestid() {
		return testid;
	}

	public void setTestid(long testid) {
		this.testid = testid;
	}

	public long getExamid() {
		return examid;
	}

	public void setExamid(long examid) {
		this.examid = examid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(long totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
