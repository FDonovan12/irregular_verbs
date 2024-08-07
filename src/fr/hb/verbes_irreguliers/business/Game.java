package fr.hb.verbes_irreguliers.business;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Long id;
	private int numberOfQuestion;
	private int score;
	private int currentQuestion = 0;
	private List<Question> questions = new ArrayList<Question>();
	private static Long count = 0L;
	
	public Game(int numberOfQuestion) {
		this.id = count++;
		this.numberOfQuestion = numberOfQuestion;
		this.score = 0;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getCurrentQuestion() {
		return currentQuestion;
	}
	
	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public Question getQuestion() {
		return questions.get(currentQuestion);
	}
	
	public void incrementCurrentQuestion() {
		currentQuestion++;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void doResponse(String preterit, String pastParticiple) {
		Question question = this.getQuestion();
		question.doResponse(preterit, pastParticiple);
	}
}
