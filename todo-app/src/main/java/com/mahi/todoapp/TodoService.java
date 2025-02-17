package com.mahi.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoIdGen = 1;

	public List<Todo> findByUsername(String username) {
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
