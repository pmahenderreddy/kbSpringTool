package com.mahi.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
		if (username.equalsIgnoreCase("") || username == null) {
			return todos;
		}

		// filtering from todos which meet the criteria
		List<Todo> filteredTodos = new ArrayList<>();
		for (Iterator iterator = todos.iterator(); iterator.hasNext();) {
			Todo todo = (Todo) iterator.next();

			if (todo.getUsername().equalsIgnoreCase(username)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

}
