package com.mahi.todoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	// default logger: LogBack from slf4j
	private Logger logger = LoggerFactory.getLogger(getClass());

	private AuthenticationService authSerive;

	public LoginController(AuthenticationService authSerive) {
		super();
		this.authSerive = authSerive;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login"; // forward to login.jsp view
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String loginHandler(@RequestParam String username, @RequestParam String password, ModelMap model) {

		if (authSerive.authenticate(username, password)) {
			model.put("name", username);
			return "welcome";
		}
		logger.info("Login authentication failed with {}/{}", username, password);
		model.put("errorMessage", "Invalid credentials, please try again!");
		return "redirect:login"; // forward to login.jsp view
	}

}
