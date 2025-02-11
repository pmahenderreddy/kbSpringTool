package com.mahi.todoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		if (name == "") { // if name query parameter is empty, ?name=
			name = "user";
		}
		model.put("name", name); // to make data available to view

		return "login";
	}
}
