package com.mahi.todoapp;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// a custom table name can be given as follow, otherwise class name is the table name
@Entity(name = "Todo")
public class Todo {
	// Todo Bean

	// @Id implies it is primary key
	@Id
	// @GeneratedValue Provides for the specification of generation strategies for
	// the values of primary keys.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// a custom column name can be given as follow, otherwise field/property name is
	// used
	@Column(name = "name")
	private String username;

	@Size(min = 10, message = "Enter atleast 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
