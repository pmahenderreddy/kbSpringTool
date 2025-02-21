package com.mahi.first_rest_api.survey;

import java.util.List;

public class Survey {

	public Survey() {
		super();
	}

	public Survey(String id, String name, String description, List<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.questions = questions;
	}

	private String id;
	private String name;
	private String description;
	private List<Question> questions;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", name=" + name + ", description=" + description + ", questions=" + questions
				+ "]";
	}

}
