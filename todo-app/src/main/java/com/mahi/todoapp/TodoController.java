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

	private TodoRepository todoRepository;

	public TodoController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusWeeks(3), false);
		model.put("todo", todo);

		return "addTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String saveAddTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String editTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);

		return "addTodo"; // go to required jsp to edit/update the todo
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String saveEditTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		String username = (String) model.getAttribute("name");
		model.put("todos", todoRepository.findByUsername(username));

		return "listTodos";
	}
}
