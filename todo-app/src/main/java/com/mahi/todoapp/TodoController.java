package com.mahi.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String filterTodos(@RequestParam(value = "filter", defaultValue = "") String filter, ModelMap model) {
		model.put("filter", filter);
		model.put("todos", todoService.findByUsername(filter));
		return "listTodos";
	}
}
