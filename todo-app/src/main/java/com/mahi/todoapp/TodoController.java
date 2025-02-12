package com.mahi.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "name", "filter" })
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String filterTodos(@RequestParam(value = "filter", defaultValue = "") String filterBy, ModelMap model) {
		model.put("filter", filterBy);
		model.put("todos", todoService.findByUsername(filterBy));
		return "listTodos";
	}

	@RequestMapping(value = "/list-todos-filterby", method = RequestMethod.GET)
	public String filterTodos(ModelMap model, @RequestParam(value = "filter", defaultValue = "") String filterBy) {
		model.put("filter", filterBy);
		model.put("todos", todoService.findByUsername(filterBy));
		return "listTodos";
	}

	@RequestMapping(value = "/list-todos-filter", method = RequestMethod.GET)
	public String filterTodosList(ModelMap model) {
		String filterBy = (String) model.get("filter");
		if (filterBy == null) {
			filterBy = "";
		}
		model.put("todos", todoService.findByUsername(filterBy));
		return "listTodos";
	}
}
