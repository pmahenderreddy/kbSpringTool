package com.mahi.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("/list-todos")
	public String listAllTodos(ModelMap model) {

		model.put("todos", todoService.findByUsername(""));
		return "listTodos";
	}

}
