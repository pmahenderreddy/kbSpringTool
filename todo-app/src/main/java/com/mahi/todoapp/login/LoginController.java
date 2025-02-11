package com.mahi.todoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	// default logger: LogBack from slf4j
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		if (name == "") { // if name query parameter is empty, ?name=
			name = "user";
		}
		model.put("name", name); // to make data available to view
		logger.info("Pushed into model: query param name='{}'", name);

		return "login"; // forward to login.jsp view
	}
}
