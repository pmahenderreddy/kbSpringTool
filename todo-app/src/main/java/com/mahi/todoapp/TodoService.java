package com.mahi.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoIdGen = 1;

	static {
		todos.add(new Todo(todoIdGen++, "Ramakrishna", "Learn AI/ML", LocalDate.now().plusMonths(3), false));
		todos.add(new Todo(todoIdGen++, "Rajkumar", "Learn Springboot", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(todoIdGen++, "Mahender", "Learn Springboot 3", LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(todoIdGen++, "Harsha", "Learn Git/GitHub", LocalDate.now().plusWeeks(1), false));
		todos.add(new Todo(todoIdGen++, "Sri", "Learn AOSP", LocalDate.now().plusWeeks(1), false));
	}

	public List<Todo> findByUsername(String username) {
//		if (username.equalsIgnoreCase("") || username == null) {
//			return todos;
//		}
//
//		// filtering from todos which meet the criteria
//		List<Todo> filteredTodos = new ArrayList<>();
//		for (Iterator<Todo> iterator = todos.iterator(); iterator.hasNext();) {
//			Todo todo = iterator.next();
//
//			if (todo.getUsername().equalsIgnoreCase(username)) {
//				filteredTodos.add(todo);
//			}
//		}
//		return filteredTodos;
		
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new Todo(todoIdGen++, username, description, targetDate, isDone));
	}

	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findTodoById(int id) {
		// return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		Todo currentTodo = findTodoById(todo.getId());
		currentTodo.setDescription(todo.getDescription());
		currentTodo.setUsername(todo.getUsername());
		currentTodo.setTargetDate(todo.getTargetDate());
		currentTodo.setDone(todo.getDone());
	}
}
