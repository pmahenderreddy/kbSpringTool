package com.mahi.first_rest_api;

import java.util.List;

public class Question {
	public Question() {
		super();
	}

	public Question(String id, String question, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.question = question;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	private String id;
	private String question;
	private List<String> options;
	private String correctAnswer;

	public String getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", options=" + options + ", correctAnswer="
				+ correctAnswer + "]";
	}
}
