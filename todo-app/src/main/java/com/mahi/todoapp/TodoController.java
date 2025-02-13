package com.mahi.todoapp;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes({ "name", "filter" })
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now().plusWeeks(3), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String saveAddTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if( result.hasErrors() ) {
			return "addTodo";
		}
		todoService.addTodo((String)model.get("name"), todo.getDescription(), LocalDate.now().plusWeeks(3), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
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
