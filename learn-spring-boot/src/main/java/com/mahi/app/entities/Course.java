package com.mahi.app.entities;

public class Course {
	private String id;
	private String name;
	private String author;

	public Course() {
		super();
	}

	public Course(String id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
