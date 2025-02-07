package com.mahi.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController doesn't work for MVC style (where views like jsp/html etc are involved)
@Controller
public class HelloController {

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "<h1>Hello</h1>";
	}

	@RequestMapping("/hello-jsp")
	public String htmlHello() {
		return "htmlHello";
	}
}
