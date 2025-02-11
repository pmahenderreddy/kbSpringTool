package com.mahi.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(1, "Ramakrishna", "Learn AOSP", LocalDate.now().plusMonths(3), false));
		todos.add(new Todo(1, "Rajkumar", "Learn Springboot", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(1, "Mahender", "Learn Springboot 3", LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(1, "Harsha", "Learn Git/GitHub", LocalDate.now().plusWeeks(1), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

}
